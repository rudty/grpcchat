package main

import (
	context "context"
	"fmt"
	"log"
	"time"

	grpc "google.golang.org/grpc"
)

const (
	address = "localhost:6565"
)

func receiveMessage(m Message_ClientMessageClient) {
	for {
		msg, err := m.Recv()
		if err != nil {
			log.Fatalf("did not connect: %v", err)
		}
		chat := msg.GetMessage()
		if chat != nil {
			msgString := chat.GetMessage()
			log.Println(msgString)
		}
		hello := msg.GetHello()
		if hello != nil {
			log.Printf("Hello %d\n", hello.GetId())
		}
	}
}

func sendMessage(m Message_ClientMessageClient) {
	id := 0
	for {
		m.Send(&MessageRequest{
			Message: fmt.Sprintf("msg %v", id),
		})
		id++
		time.Sleep(1 * time.Second)
	}
}

func newClient() {
	conn, err := grpc.Dial(address, grpc.WithInsecure())
	if err != nil {
		log.Fatalf("did not connect: %v", err)
	}
	defer conn.Close()

	c := NewMessageClient(conn)

	m, err := c.ClientMessage(context.Background())
	if err != nil {
		log.Fatalf("msg err: %v", err)
	}
	go sendMessage(m)
	receiveMessage(m)
}

func main() {
	for i := 0; i < 10; i++ {
		go newClient()
	}
	newClient()
	time.Sleep(20 * time.Second)
}

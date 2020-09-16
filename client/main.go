package main

import (
	context "context"
	"io"
	"log"
	"strconv"
	"time"

	empty "github.com/golang/protobuf/ptypes/empty"
	grpc "google.golang.org/grpc"
)

const (
	address = "localhost:6565"
)

func newClient() {
	conn, err := grpc.Dial(address, grpc.WithInsecure())
	if err != nil {
		log.Fatalf("did not connect: %v", err)
	}
	defer conn.Close()

	c := NewMessageClient(conn)

	receive, err := c.ClientReceive(context.Background(), &empty.Empty{})
	if err != nil {
		log.Fatal(err)
	}
	go (func() {
		for i := 0; i < 10; i++ {
			req := &SendRequest{
				Message: "hello " + strconv.Itoa(i),
			}
			_, err := c.ClientSend(context.Background(), req)
			if err != nil {
				log.Print(err)
			}
			time.Sleep(300 * time.Millisecond)
		}
	})()
	for {
		reply, err := receive.Recv()
		if err != nil {
			if err == io.EOF {
				break
			}
			log.Fatal(err)
		}
		m := reply.GetMessage()
		log.Print(m)
	}
}

func main() {

	for i := 0; i < 10; i++ {
		go newClient()
	}
	newClient()
	time.Sleep(20 * time.Second)
}

package main

import (
	context "context"
	"io"
	"log"

	empty "github.com/golang/protobuf/ptypes/empty"
	grpc "google.golang.org/grpc"
)

const (
	address = "localhost:6565"
)

func newClient(conn grpc.ClientConnInterface) {
	c := NewMessageClient(conn)
	c.ClientSend(context.Background(), &SendRequest{
		Message: "hello ",
	})
	receive, err := c.ClientReceive(context.Background(), &empty.Empty{})
	if err != nil {
		log.Fatal(err)
	}
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
	conn, err := grpc.Dial(address, grpc.WithInsecure(), grpc.WithBlock())
	if err != nil {
		log.Fatalf("did not connect: %v", err)
	}
	defer conn.Close()

	for i := 0; i < 10; i++ {
		newClient(conn)
	}
	// time.Sleep(20 * time.Second)
}

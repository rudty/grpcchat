protoc --go_out=../client ./*.proto
protoc --go_out=plugins=grpc:../client ./*.proto
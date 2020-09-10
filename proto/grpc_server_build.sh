protoc --plugin=protoc-gen-grpc-java.exe --grpc-java_out=../src/main/java *.proto
protoc --java_out=../src/main/java *.proto
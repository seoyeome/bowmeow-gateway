package com.bowmeow.gateway.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.bowmeow.gateway.client.UserRequest;
import com.bowmeow.gateway.client.UserResponse;
import com.bowmeow.gateway.client.UserServiceGrpc;

public class UserClient {
    private final UserServiceGrpc.UserServiceBlockingStub blockingStub;

    public UserClient(String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = UserServiceGrpc.newBlockingStub(channel);
    }

    public UserResponse getUser(String userId) {
        UserRequest request = UserRequest.newBuilder().setUserId(userId).build();
        return blockingStub.getUser(request);
    }
}

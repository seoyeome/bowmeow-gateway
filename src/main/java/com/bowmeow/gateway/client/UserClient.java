package com.bowmeow.gateway.client;

import com.bowmeow.user.User;
import com.bowmeow.user.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

@Component
public class UserClient {
    private final UserServiceGrpc.UserServiceBlockingStub blockingStub;

    public UserClient(String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = UserServiceGrpc.newBlockingStub(channel);
    }

    public User.SignUpResponse signUp(String username, String password) {
        User.SignUpRequest request = User.SignUpRequest.newBuilder()
                .setUsername(username)
                .setPassword(password)
                .build();
        return blockingStub.signUp(request);
    }

    public User.UserResponse getUser(String userId) {
        User.UserRequest request = User.UserRequest.newBuilder()
                .setUserId(userId)
                .build();
        return blockingStub.getUser(request);
    }
}
package com.bowmeow.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.bowmeow.gateway.client.UserClient;
import com.bowmeow.gateway.client.UserResponse;

@RestController
public class GatewayController {
    private final UserClient userClient;

    public GatewayController() {
        this.userClient = new UserClient("localhost", 9090);
    }

    @GetMapping("/user/{userId}")
    public UserResponse getUser(@PathVariable String userId) {
        return userClient.getUser(userId);
    }
}

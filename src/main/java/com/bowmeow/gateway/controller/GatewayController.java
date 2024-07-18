package com.bowmeow.gateway.controller;

import com.bowmeow.gateway.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bowmeow.gateway.client.UserClient;
import com.bowmeow.gateway.client.UserResponse;

@RestController
@RequiredArgsConstructor
public class GatewayController {
//    private final UserClient userClient;
//
//    public GatewayController() {
//        this.userClient = new UserClient("localhost", 9090);
//    }
//
//    @GetMapping("/user/{userId}")
//    public UserResponse getUser(@PathVariable String userId) {
//        return userClient.getUser(userId);
//    }

    private final PaymentService paymentService;

    @PostMapping("/payments/payment") // todo: 이름도변경할거
    public String getProductInfo_payment() {
        // String productSno = productService.getProductSno();
        paymentService.payment("productSno 넣을꺼");
        return null;
    }


}

package com.bowmeow.gateway.service;

import com.bowmeow.gateway.client.PaymentClient;
import com.bowmeow.gateway.client.PaymentResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class PaymentService {

    private final PaymentClient paymentClient;
    public PaymentService() {
        this.paymentClient = new PaymentClient("localhost", 9091);
    }

    @PostMapping("/payments/{productSno}")
    public PaymentResponse payment(@PathVariable String productSno) {
        return paymentClient.payment();
    }
}

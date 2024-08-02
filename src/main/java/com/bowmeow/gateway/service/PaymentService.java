package com.bowmeow.gateway.service;

import com.bowmeow.gateway.client.PaymentClient;
import com.bowmeow.gateway.client.PaymentResponse;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentClient paymentClient;
    public PaymentService() {
        this.paymentClient = new PaymentClient("localhost", 9091);
    }

    public void payment() {
        // TODO: exception 처리
        paymentClient.payment();
    }
}

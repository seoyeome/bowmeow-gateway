package com.bowmeow.gateway.controller;

import com.bowmeow.gateway.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class GatewayController {

    private final PaymentService paymentService;

    /**
     * 결제
     */
    @PostMapping("/payments")
    public void payment() {
        log.debug("POST /payments invoke start");
        paymentService.payment();
        log.debug("POST /payments invoke end");
    }

}

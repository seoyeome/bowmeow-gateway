package com.bowmeow.gateway.client;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaymentClient {
    private final PaymentServiceGrpc.PaymentServiceBlockingStub blockingStub;

    public PaymentClient(String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        blockingStub = PaymentServiceGrpc.newBlockingStub(channel);
    }

    public PaymentResponse getPaymentHist(String paymentId) {
        PaymentRequest request = PaymentRequest.newBuilder().setPaymentId(paymentId).build();
        return blockingStub.getPaymentHist(request);
    }

    public void payment() {
        Empty request = Empty.getDefaultInstance();
        log.debug("POST /payment request : {}", request);
        Empty response = blockingStub.payment(request);
        log.debug("POST /payment response : {}", response);
    }

}

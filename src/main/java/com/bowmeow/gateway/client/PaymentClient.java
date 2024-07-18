package com.bowmeow.gateway.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

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

    public PaymentResponse payment(/* Product product */) {
        // todo: 수정예정
        PaymentRequest request = PaymentRequest.newBuilder().build();
        return blockingStub.getPaymentHist(request);
    }

}

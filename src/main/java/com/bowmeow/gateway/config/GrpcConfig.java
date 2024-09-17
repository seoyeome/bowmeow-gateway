package com.bowmeow.gateway.config;

import com.bowmeow.user.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcConfig {

    @Value("${grpc.server.host}")
    private String grpcHost;

    @Value("${grpc.server.port}")
    private int grpcPort;

    @Bean
    public ManagedChannel userServiceChannel() {
        return ManagedChannelBuilder.forAddress( grpcHost, grpcPort )
                .useTransportSecurity()
                .build();
    }

    @Bean
    public UserServiceGrpc.UserServiceBlockingStub userServiceStub( ManagedChannel channel ) {
        return UserServiceGrpc.newBlockingStub( channel );
    }
}

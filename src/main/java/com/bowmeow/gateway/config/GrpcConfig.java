package com.bowmeow.gateway.config;

import com.bowmeow.gateway.client.UserClient;
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
    public UserClient userClient() {
        return new UserClient(grpcHost, grpcPort);
    }
}

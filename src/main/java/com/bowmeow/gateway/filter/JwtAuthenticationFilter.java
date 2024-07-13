package com.bowmeow.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationFilter extends AbstractGatewayFilterFactory<JwtAuthenticationFilter.Config> {

    public JwtAuthenticationFilter() {
        super( Config.class );
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                return chain.filter(exchange);
            }

            String token = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
            if (token != null && token.startsWith("Bearer ")) {
                token = token.substring(7);
            }

            try {
                JWTUtil.validateToken(token);
            } catch (Exception e) {
                return chain.filter(exchange);
            }

            return chain.filter(exchange);
        };
    }

    public static class Config {
        // Configuration properties
        private boolean validateToken;

        public boolean isValidateToken() {
            return validateToken;
        }

        public void setValidateToken(boolean validateToken) {
            this.validateToken = validateToken;
        }
    }
}

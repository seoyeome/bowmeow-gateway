package com.bowmeow.gateway.dto.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailVerificationDto {
    private String email;
    private String token;
}

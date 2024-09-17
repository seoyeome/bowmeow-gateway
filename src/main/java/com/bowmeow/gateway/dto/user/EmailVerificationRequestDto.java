package com.bowmeow.gateway.dto.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailVerificationRequestDto {
    private String email;
}

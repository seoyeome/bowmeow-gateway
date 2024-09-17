package com.bowmeow.gateway.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDto {
    private String email;
    private String password;
    private String nickname;
    private String phoneNumber;
    private String address; // 사용자 입력 주소
    private String postcode; // 우편번호
}

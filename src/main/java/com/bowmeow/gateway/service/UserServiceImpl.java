package com.bowmeow.gateway.service;

import com.bowmeow.gateway.client.UserClient;
import com.bowmeow.gateway.dto.user.EmailVerificationDto;
import com.bowmeow.gateway.dto.user.EmailVerificationRequestDto;
import com.bowmeow.gateway.dto.user.SignUpRequestDto;
import com.bowmeow.gateway.dto.user.UserDto;
import com.bowmeow.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserClient userClient;


    @Override
    public String signUpUser( SignUpRequestDto signUpRequest ) {
        User.SignUpResponse response = userClient.signUp( signUpRequest );
        return response.getMessage();
    }

    @Override
    public UserDto getUser( String userId) {
        User.UserResponse response = userClient.getUser(userId);
        return UserDto.builder()
                .id(userId)
                .username(response.getUsername())
                .email(response.getEmail())
                .build();
    }
    @Override
    public String sendVerificationEmail(String email) {
        User.SendVerificationEmailResponse response = userClient.sendVerificationEmail(
                EmailVerificationRequestDto.builder().email(email).build());
        return response.getMessage();
    }

    @Override
    public String verifyEmail(String email, String token) {
        User.VerifyEmailResponse response = userClient.verifyEmail(
                EmailVerificationDto.builder().email(email).token(token).build());
        return response.getMessage();
    }

    @Override
    public boolean isEmailVerified(String email) {
        User.IsEmailVerifiedResponse response = userClient.isEmailVerified(email);
        return response.getVerified();
    }
}
package com.bowmeow.gateway.client;

import com.bowmeow.gateway.dto.user.SignUpRequestDto;
import com.bowmeow.gateway.dto.user.EmailVerificationRequestDto;
import com.bowmeow.gateway.dto.user.EmailVerificationDto;
import com.bowmeow.user.User;
import com.bowmeow.user.UserServiceGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserClient {
    private final UserServiceGrpc.UserServiceBlockingStub blockingStub;

    @Autowired
    public UserClient(UserServiceGrpc.UserServiceBlockingStub blockingStub) {
        this.blockingStub = blockingStub;
    }

    public User.SignUpResponse signUp(SignUpRequestDto signUpRequest) {
        User.SignUpRequest request = User.SignUpRequest.newBuilder()
                .setEmail(signUpRequest.getEmail())
                .setPassword(signUpRequest.getPassword())
                .setNickname(signUpRequest.getNickname())
                .setPhoneNumber(signUpRequest.getPhoneNumber())
                .setAddress(signUpRequest.getAddress())
                .build();
        return blockingStub.signUp(request);
    }

    public User.UserResponse getUser(String userId) {
        User.UserRequest request = User.UserRequest.newBuilder()
                .setUserId(userId)
                .build();
        return blockingStub.getUser(request);
    }

    public User.SendVerificationEmailResponse sendVerificationEmail(EmailVerificationRequestDto emailVerificationRequestDto) {
        User.SendVerificationEmailRequest request = User.SendVerificationEmailRequest.newBuilder()
                .setEmail(emailVerificationRequestDto.getEmail())
                .build();
        return blockingStub.sendVerificationEmail(request);
    }

    public User.VerifyEmailResponse verifyEmail(EmailVerificationDto emailVerificationDto) {
        User.VerifyEmailRequest request = User.VerifyEmailRequest.newBuilder()
                .setEmail(emailVerificationDto.getEmail())
                .setToken(emailVerificationDto.getToken())
                .build();
        return blockingStub.verifyEmail(request);
    }

    public User.IsEmailVerifiedResponse isEmailVerified(String email) {
        User.IsEmailVerifiedRequest request = User.IsEmailVerifiedRequest.newBuilder()
                .setEmail(email)
                .build();
        return blockingStub.isEmailVerified(request);
    }
}
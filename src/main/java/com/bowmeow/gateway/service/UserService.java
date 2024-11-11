package com.bowmeow.gateway.service;

import com.bowmeow.gateway.dto.user.SignInRequestDto;
import com.bowmeow.gateway.dto.user.SignUpRequestDto;
import com.bowmeow.gateway.dto.user.UserDto;

public interface UserService {
    String signUpUser( SignUpRequestDto signUpRequest );
    String signInUser( SignInRequestDto signInRequest );
    UserDto getUser( String userId );
    String sendVerificationEmail(String email);
    String verifyEmail(String email, String token);
    boolean isEmailVerified(String email);
}

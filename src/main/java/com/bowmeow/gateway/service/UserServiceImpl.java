package com.bowmeow.gateway.service;

import com.bowmeow.gateway.client.UserClient;
import com.bowmeow.gateway.dto.user.UserDto;
import com.bowmeow.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserClient userClient;


    @Override
    public String signUpUser(String username, String password) {
        User.SignUpResponse response = userClient.signUp(username, password);
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
}
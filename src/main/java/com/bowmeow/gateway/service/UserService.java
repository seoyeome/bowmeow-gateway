package com.bowmeow.gateway.service;

import com.bowmeow.gateway.dto.user.UserDto;

public interface UserService {
    String signUpUser( String username, String password );
    UserDto getUser( String userId );

}

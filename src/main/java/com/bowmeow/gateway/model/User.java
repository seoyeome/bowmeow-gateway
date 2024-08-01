package com.bowmeow.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class User {
    private String id;
    private String username;
    private String password;
    private String email;
}

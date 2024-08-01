package com.bowmeow.gateway.dto.user;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private String id;
    private String username;
    private String password;
    private String email;
}

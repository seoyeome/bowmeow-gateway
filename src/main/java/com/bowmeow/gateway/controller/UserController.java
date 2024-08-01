package com.bowmeow.gateway.controller;

import com.bowmeow.gateway.dto.user.SignUpRequestDto;
import com.bowmeow.gateway.dto.user.UserDto;
import com.bowmeow.gateway.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequestDto request) {
        String result = userService.signUpUser(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable String userId) {
        UserDto user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }
}
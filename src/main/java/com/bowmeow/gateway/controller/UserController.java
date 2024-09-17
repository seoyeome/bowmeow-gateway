package com.bowmeow.gateway.controller;

import com.bowmeow.gateway.dto.user.EmailVerificationDto;
import com.bowmeow.gateway.dto.user.EmailVerificationRequestDto;
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

    @PostMapping("/email-verification/send")
    public ResponseEntity<String> sendVerificationEmail(@RequestBody EmailVerificationRequestDto request) {
        String result = userService.sendVerificationEmail(request.getEmail());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/email-verification/verify")
    public ResponseEntity<String> verifyEmail(@RequestBody EmailVerificationDto request) {
        String result = userService.verifyEmail(request.getEmail(), request.getToken());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequestDto request) {
        String result = userService.signUpUser(request);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable String userId) {
        UserDto user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }
}
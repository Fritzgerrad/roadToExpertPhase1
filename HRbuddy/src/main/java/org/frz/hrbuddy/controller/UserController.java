package org.frz.hrbuddy.controller;

import lombok.RequiredArgsConstructor;
import org.frz.hrbuddy.dto.UserDto;
import org.frz.hrbuddy.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserController {
    private final UserService userService;

    @GetMapping()
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello World");
    }

    public ResponseEntity<String> login(UserDto userDto) {
        return ResponseEntity.ok(userService.login(userDto));
    }

    public ResponseEntity<String> changePassword(UserDto userDto, String password) {
        return ResponseEntity.ok(userService.changePassword(userDto,password));
    }
}

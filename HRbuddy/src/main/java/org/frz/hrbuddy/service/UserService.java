package org.frz.hrbuddy.service;

import lombok.RequiredArgsConstructor;
import org.frz.hrbuddy.dto.UserDto;
import org.frz.hrbuddy.model.User;
import org.frz.hrbuddy.repository.UserRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;

    public String signup(UserDto userDto) {
        User user = User.builder()
                .username(userDto.getUsername())
                //.password(passwordEncoder.encode(userDto.getPassword()))
                .password(userDto.getPassword())
                .role(userDto.getRole())
                .build();

        userRepository.save(user);
        return user.getUsername();
    }

    public String login(UserDto userDto) {
        return "login successful";
    }

    public String changePassword(UserDto userDto, String newPassword) {
        User user = userRepository.findByUsername(userDto.getUsername());
        String oldPassword = user.getPassword();
        String password = userDto.getPassword();
        if (!oldPassword.equals(password)) {
            return "password does not match";
        }
        user.setPassword(newPassword);
        userRepository.save(user);
        return user.getUsername();
    }
}

package org.tuandev.chat.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.tuandev.chat.dto.request.UserRequestDto;
import org.tuandev.chat.dto.response.ResponseDto;
import org.tuandev.chat.exceptions.AlreadyExistsException;
import org.tuandev.chat.mappers.UserMapper;
import org.tuandev.chat.models.User;
import org.tuandev.chat.repositories.UserRepository;
import org.tuandev.chat.services.AuthService;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseDto register(UserRequestDto userRequestDto) {
        if (!userRepository.existsByEmail(userRequestDto.getEmail())) {
            User newUser = UserMapper.toUser(userRequestDto);
            newUser.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
            userRepository.save(newUser);
            return ResponseDto.builder()
                    .code(HttpStatus.CREATED.value())
                    .message("User created successfully")
                    .build();
        }
        throw new AlreadyExistsException("User already exists");
    }
}

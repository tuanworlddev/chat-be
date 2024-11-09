package org.tuandev.chat.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tuandev.chat.dto.request.UserRequestDto;
import org.tuandev.chat.dto.response.ResponseDto;
import org.tuandev.chat.exceptions.NotValidException;
import org.tuandev.chat.services.AuthService;

@RestController
@RequestMapping("/test/api/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> createUser(@RequestBody @Valid UserRequestDto userRequestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new NotValidException("Data invalid");
        }
        ResponseDto response = authService.register(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

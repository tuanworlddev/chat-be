package org.tuandev.chat.services;

import org.tuandev.chat.dto.request.UserRequestDto;
import org.tuandev.chat.dto.response.ResponseDto;

public interface AuthService {
    ResponseDto register(UserRequestDto userRequestDto);
}

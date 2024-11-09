package org.tuandev.chat.mappers;

import org.tuandev.chat.dto.request.UserRequestDto;
import org.tuandev.chat.dto.response.UserResponseDto;
import org.tuandev.chat.models.User;

public class UserMapper {
    public static User toUser(UserRequestDto userRequestDto) {
        return User.builder()
                .email(userRequestDto.getEmail())
                .name(userRequestDto.getName())
                .build();
    }

    public static UserResponseDto toUserDto(User user) {
        return UserResponseDto.builder()
                .id(user.getUserId())
                .email(user.getEmail())
                .name(user.getName())
                .isActive(user.isActive())
                .build();
    }
}

package org.tuandev.chat.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponseDto {
    private int id;
    private String name;
    private String email;
    private boolean isActive;
}

package org.tuandev.chat.exceptions.handle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.tuandev.chat.dto.response.ResponseDto;
import org.tuandev.chat.exceptions.AlreadyExistsException;
import org.tuandev.chat.exceptions.NotValidException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ResponseDto> handleAlreadyExistsException(AlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ResponseDto.builder()
                        .code(HttpStatus.CONFLICT.value())
                        .message(e.getMessage()).build());
    }

    @ExceptionHandler(NotValidException.class)
    public ResponseEntity<ResponseDto> handleMethodArgumentNotValidException(NotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDto.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message(e.getMessage()).build());
    }
}

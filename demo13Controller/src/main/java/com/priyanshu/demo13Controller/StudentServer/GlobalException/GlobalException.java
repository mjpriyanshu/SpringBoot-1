package com.priyanshu.demo13Controller.StudentServer.GlobalException;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.priyanshu.demo13Controller.StudentServer.Dto.ExceptionResponseDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalException {

    // 1. Handlers for unchecked exceptions (Runtime exceptions)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDTO> handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        ExceptionResponseDTO response = new ExceptionResponseDTO(
            LocalDateTime.now(),
            HttpStatus.INTERNAL_SERVER_ERROR.value(), // Changed to 500 to match status below
            HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
            e.getMessage(),
            request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    // 2. Fallback handler for all other checked exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleCheckedException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(e.getMessage());
    }
}

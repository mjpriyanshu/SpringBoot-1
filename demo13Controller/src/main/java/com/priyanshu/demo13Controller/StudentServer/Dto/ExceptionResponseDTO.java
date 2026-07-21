package com.priyanshu.demo13Controller.StudentServer.Dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponseDTO {
    private LocalDateTime timestamp;
    private int statusCode;
    private String message;
    private String error;
    private String path;
}

package com.codecool.javapeno.erp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class ErrorModel {
    private String errorMessage;
    private LocalDateTime time;
    private HttpStatus status;
}

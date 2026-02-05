package com.diaries.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDto {

    private int statusCode;
    private String message;

    public ErrorResponseDto(String message)
    {
        super();
        this.message = message;
    }
}

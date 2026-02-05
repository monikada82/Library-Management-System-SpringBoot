package com.diaries.library.advice.exception;

import com.diaries.library.dto.ErrorResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@Getter
public class NoSuchBookException extends RuntimeException {
    private String message;


    public NoSuchBookException(Long id){
        super();
        this.message="Book not found:"+id;
    }


}

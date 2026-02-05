package com.diaries.library.advice;
import com.diaries.library.advice.exception.NoSuchBookException;
import com.diaries.library.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NoSuchBookException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorResponseDto handleException(NoSuchBookException ex) {
        return new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }
        @ExceptionHandler(value = MethodArgumentNotValidException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public @ResponseBody ErrorResponseDto handleException(MethodArgumentNotValidException ex){
            ex.getBindingResult().getAllErrors();
            return new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(),ex.getMessage());
        }
    }


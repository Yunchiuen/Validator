package com.example.validator.exception;

import com.example.validator.pojo.Result;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//全局異常處理
//@ControllerAdvice
@RestControllerAdvice
public class ExceptionControllerAdvice {
    //如果在controller方法中使用@Valid進行驗證，
    //失敗時會觸發 MethodArgumentNotValidException.class
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Result<String>> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        Result<String> result = new Result<>(0, objectError.getDefaultMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(result);
    }

    //如果使用 Bean Validation進行驗證，
    //失敗時會觸發 ConstraintViolationException.class
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Result<String>> handleConstraintViolationException(ConstraintViolationException ex) {
        String errorMessage = ex.getMessage();//獲取錯誤訊息
//        System.out.println(errorMessage);
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errorMessage = violation.getMessage();
            break;
        }
        Result<String> result = new Result<>(0, errorMessage);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(result);
    }
}

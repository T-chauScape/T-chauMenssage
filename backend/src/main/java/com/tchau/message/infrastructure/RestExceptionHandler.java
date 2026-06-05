package com.tchau.message.infrastructure;

import com.tchau.message.exception.EmailAlreadyExistException;
import com.tchau.message.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EmailAlreadyExistException.class)
    private ResponseEntity<RestErrorMenssage> userAlreadyExists(EmailAlreadyExistException exception) {
        RestErrorMenssage restErrorMenssage = new RestErrorMenssage(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(restErrorMenssage);
    }
    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<RestErrorMenssage> userNotFound(UserNotFoundException exception) {
        RestErrorMenssage restErrorMenssage = new RestErrorMenssage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restErrorMenssage);
    }
}

package com.tchau.message.exception;

public class EmailAlreadyExistException extends IllegalStateException {
    public EmailAlreadyExistException() { super("Email already exists"); }
    public EmailAlreadyExistException(String message) { super(message);  }

}

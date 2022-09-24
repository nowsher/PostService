package edu.mum.cs544.PostService.exceptions.handlers;

import edu.mum.cs544.PostService.model.Post;

import java.io.IOException;
import java.nio.file.FileSystemException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;

import javax.management.InvalidAttributeValueException;
import javax.persistence.RollbackException;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandleController  /*extends ResponseEntityExceptionHandler*/ {

    // @ExceptionHandler
    // public ResponseEntity<Object> exception(IllegalArgumentException exception, ConstraintViolationException ex) {
    //     return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    // }

    @ExceptionHandler
    public ResponseEntity<String> exception(Exception ex) {        
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
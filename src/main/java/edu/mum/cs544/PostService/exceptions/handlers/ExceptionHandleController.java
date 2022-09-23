package edu.mum.cs544.PostService.exceptions.handlers;

import edu.mum.cs544.PostService.model.Post;

import java.io.IOException;
import java.nio.file.FileSystemException;
import java.rmi.RemoteException;
import java.util.List;

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

@ControllerAdvice
public class ExceptionHandleController {

    @ExceptionHandler
    public ResponseEntity<Object> exception(Exception ex) {// IllegalArgumentException ex, ConstraintViolationException
        String msg = ex.getMessage();
        // if(ex instanceof MethodArgumentNotValidException) {
        //     List<FieldError> fieldErrors = ((MethodArgumentNotValidException) ex).getBindingResult().getFieldErrors();
        //     StringBuilder sb = new StringBuilder(); 
        //     for(FieldError fieldError: fieldErrors){
        //         sb.append(fieldError.getDefaultMessage());
        //         sb.append(";");
        //     }
        //     msg = sb.toString();
        // }
        return new ResponseEntity<Object>(msg, HttpStatus.BAD_REQUEST);
    }

    // @ExceptionHandler
    // public ResponseEntity<Object> exception(IllegalArgumentException exception, ConstraintViolationException ex) {
    //     return new ResponseEntity<>(io.getMessage(), HttpStatus.BAD_REQUEST);
    // }

    // @ExceptionHandler({ FileSystemException.class, RemoteException.class })
    // public String handle(Exception e) {
    //     // do something with the exception
    //     return "exception";
    // }

}
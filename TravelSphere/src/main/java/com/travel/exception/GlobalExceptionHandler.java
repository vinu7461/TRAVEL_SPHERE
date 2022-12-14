package com.travel.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myexceptionhandler(Exception e,WebRequest req){
		MyErrorDetails err =  new MyErrorDetails();
		err.setTimestamps(LocalDateTime.now());
		err.setMgs(e.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}

	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> myexceptionhandler(NoHandlerFoundException e,WebRequest req){
		MyErrorDetails err =  new MyErrorDetails();
		err.setTimestamps(LocalDateTime.now());
		err.setMgs(e.getMessage());
		err.setDetails(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myexceptionhandler(MethodArgumentNotValidException e){
		MyErrorDetails err =  new MyErrorDetails();
		err.setTimestamps(LocalDateTime.now());
		err.setMgs("validation Error");
		err.setDetails(e.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
}

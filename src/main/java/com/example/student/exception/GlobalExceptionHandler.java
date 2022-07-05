package com.example.student.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ResponseNotFoundException.class)
	public ResponseEntity<ErrorResponse> NoIdFoundException(){
		ErrorResponse response = new ErrorResponse();
		response.setMessage("No name found");
		response.setLocalDateTime(LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ErrorResponse> IdNotFoundException(){
		ErrorResponse response = new ErrorResponse();
		response.setMessage("No such Id present to delete");
		response.setLocalDateTime(LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

}

package com.pessoa;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pessoa.service.ApplicationException;

@RestControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<String> handlerApplicationException(ApplicationException e, WebRequest request) {
		return ResponseEntity.ok(e.getMessage()); 
	}
	
}

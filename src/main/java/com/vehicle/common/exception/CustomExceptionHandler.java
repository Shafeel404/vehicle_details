package com.vehicle.common.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vehicle.model.error.response.ApiError;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<Object> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
		// Create a custom error response
		ApiError apiError = new ApiError(HttpStatus.FORBIDDEN, ex.getMessage(), LocalDateTime.now());

		// Return the error response with appropriate status code
		return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	@ExceptionHandler(UserNotEnabledException.class)
	public ResponseEntity<Object> handleUserNotEnabledException(UserNotEnabledException ex) {
		// Create a custom error response
		ApiError apiError = new ApiError(HttpStatus.LOCKED, ex.getMessage(), LocalDateTime.now());

		// Return the error response with appropriate status code
		return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	@ExceptionHandler(UserNotExistException.class)
	public ResponseEntity<Object> handleUserNotExistException(UserNotExistException ex) {
		// Create a custom error response
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), LocalDateTime.now());

		// Return the error response with appropriate status code
		return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
	}
}
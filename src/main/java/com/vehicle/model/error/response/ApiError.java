package com.vehicle.model.error.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiError {
	private HttpStatus status;
	private String message;
	private LocalDateTime timestamp;
}

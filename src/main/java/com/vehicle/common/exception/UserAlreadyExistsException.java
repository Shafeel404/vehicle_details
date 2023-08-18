package com.vehicle.common.exception;

public class UserAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 5909682986369403221L;

	public UserAlreadyExistsException(String message) {
		super(message);
	}

}

package com.vehicle.common.exception;

public class UserNotExistException extends RuntimeException {

	private static final long serialVersionUID = 1981930411738694495L;

	public UserNotExistException(String message) {
		super(message);
	}
}

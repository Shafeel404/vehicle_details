package com.vehicle.common.exception;

public class UserNotEnabledException extends RuntimeException {

	private static final long serialVersionUID = -7181594475071437450L;

	public UserNotEnabledException(String message) {
		super(message);
	}
}

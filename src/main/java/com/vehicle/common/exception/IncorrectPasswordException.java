package com.vehicle.common.exception;

public class IncorrectPasswordException extends RuntimeException {
	private static final long serialVersionUID = -9196608777851183438L;

	public IncorrectPasswordException(String message) {
		super(message);
	}
}

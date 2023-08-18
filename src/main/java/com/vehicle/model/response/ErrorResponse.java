package com.vehicle.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
public class ErrorResponse {
	@JsonProperty("error_cd")
	private Integer errorCode;

	@JsonProperty("message")
	private String message;

	@JsonProperty("additional_data")
	private Object additionalData;

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(String message) {
		super();
		this.message = message;
	}

	public ErrorResponse(String message, Object additionalData) {
		super();
		this.message = message;
		this.additionalData = additionalData;
	}

	public ErrorResponse(Integer errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

	public ErrorResponse(Integer errorCode, String message, Object additionalData) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.additionalData = additionalData;
	}

	public String getMessage() {
		return message;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public Object getAdditionalData() {
		return additionalData;
	}

	@Override
	public String toString() {
		return "ErrorResponse [errorCode=" + errorCode + ", message=" + message + "]";
	}
}

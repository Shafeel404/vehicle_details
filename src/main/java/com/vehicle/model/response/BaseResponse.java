package com.vehicle.model.response;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
	
	@JsonProperty("status_cd")
	private int statusCode;

	@JsonProperty("data")
	private Object data;

	@JsonProperty("error")
	private ErrorResponse error;

	public static class ResponseBuilder {

		int statusCode;

		Object data;

		ErrorResponse error;

		public ResponseBuilder withData(Object data) {
			this.data = data;
			this.statusCode = 1;
			return this;
		}

		public ResponseBuilder withError(String message) {
			this.error = new ErrorResponse(message);
			return this;
		}

		public ResponseBuilder withError(String message, Object additionalData) {
			this.error = new ErrorResponse(message, additionalData);
			return this;
		}

		public ResponseBuilder withError(Integer errorCode, String message) {
			this.error = new ErrorResponse(errorCode, message);
			return this;
		}

		public BaseResponse build() {
			return new BaseResponse(this);
		}

	}

	private BaseResponse() {

	}

	private BaseResponse(ResponseBuilder responseBuilder) {
		this.statusCode = responseBuilder.statusCode;
		this.data = responseBuilder.data;
		this.error = responseBuilder.error;
	}

	public static ResponseBuilder builder() {
		return new ResponseBuilder();
	}
}

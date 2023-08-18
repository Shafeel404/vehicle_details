package com.vehicle.common.exception;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = -7751265205954567L;

//	private static final MessageSource messageSource = StaticContextAccessor.getBean(MessageSource.class);
//
//	private String messageCode;
//
//	private String loggerMessage;
//
//	private Object[] args;
//
//	private Object additionalData;
//
//	private Integer errorCode;
//
//	public RestException(String messageCode) {
//		super(messageSource.getMessage(messageCode, null, Locale.ENGLISH));
//		this.messageCode = messageCode;
//	}
//
//	public RestException(String messageCode, String loggerMessage) {
//		super(messageSource.getMessage(messageCode, null, Locale.ENGLISH));
//		this.messageCode = messageCode;
//		this.loggerMessage = loggerMessage;
//	}
//
//	public RestException(String messageCode, Object[] args) {
//		super(messageSource.getMessage(messageCode, args, Locale.ENGLISH));
//		this.messageCode = messageCode;
//		this.args = args;
//	}
//
//	public RestException(String messageCode, Object[] args, String loggerMessage) {
//		super(messageSource.getMessage(messageCode, args, Locale.ENGLISH));
//		this.messageCode = messageCode;
//		this.args = args;
//		this.loggerMessage = loggerMessage;
//	}
//
//	public RestException(String messageCode, Object additionalData) {
//		super(messageSource.getMessage(messageCode, null, Locale.ENGLISH));
//		this.messageCode = messageCode;
//		this.additionalData = additionalData;
//	}
//
//	public RestException(String messageCode, Object additionalData, String loggerMessage) {
//		super(messageSource.getMessage(messageCode, null, Locale.ENGLISH));
//		this.messageCode = messageCode;
//		this.additionalData = additionalData;
//		this.loggerMessage = loggerMessage;
//	}
//
//	public RestException(String messageCode, Integer errorCode) {
//		super(messageSource.getMessage(messageCode, null, Locale.ENGLISH));
//		this.messageCode = messageCode;
//		this.errorCode = errorCode;
//	}

}

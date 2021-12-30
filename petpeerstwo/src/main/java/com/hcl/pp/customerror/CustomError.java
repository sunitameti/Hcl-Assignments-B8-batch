package com.hcl.pp.customerror;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomError {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-dd hh:mm:ss")
	private LocalDateTime localDateTime;

	private String message;

	private String details;

	public CustomError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomError(LocalDateTime localDateTime, String message, String details) {
		super();
		this.localDateTime = localDateTime;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}

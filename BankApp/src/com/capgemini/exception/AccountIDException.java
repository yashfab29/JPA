package com.capgemini.exception;

public class AccountIDException extends Exception {
	public String getMessage() {
		return "Enter valid account ID";
	}

}

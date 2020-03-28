package com.cdsminiproject.users.exception;

import org.springframework.stereotype.Component;

@Component
public class CustomException {

	public static RuntimeException throwException(String message) {
		return new RuntimeException(message);
	}

	public static class InvalidUserCsvException extends RuntimeException {

		public InvalidUserCsvException() {
			super("Invalid user CSV");
		}

		public InvalidUserCsvException(String message) {
			super(message);
		}
	}
}

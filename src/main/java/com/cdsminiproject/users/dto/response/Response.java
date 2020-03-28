package com.cdsminiproject.users.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors(chain = true)
public class Response<T> {

	private Status status;
	private T data;
	private String error;

	public static <T> Response<T> success() {
		Response<T> response = new Response<>();
		response.setStatus(Status.SUCCESS);
		return response;
	}

	public static <T> Response<T> badRequest() {
		Response<T> response = new Response<>();
		response.setStatus(Status.BAD_REQUEST);
		return response;
	}

	public static <T> Response<T> unauthorized() {
		Response<T> response = new Response<>();
		response.setStatus(Status.UNAUTHORIZED);
		return response;
	}

	public static <T> Response<T> forbidden() {
		Response<T> response = new Response<>();
		response.setStatus(Status.FORBIDDEN);
		return response;
	}

	public static <T> Response<T> notFound() {
		Response<T> response = new Response<>();
		response.setStatus(Status.NOT_FOUND);
		return response;
	}

	public static <T> Response<T> internalServerError() {
		Response<T> response = new Response<>();
		response.setStatus(Status.INTERNAL_SERVER_ERROR);
		return response;
	}

	public enum Status {
		SUCCESS, BAD_REQUEST, UNAUTHORIZED, INTERNAL_SERVER_ERROR, FORBIDDEN, NOT_FOUND
	}

}

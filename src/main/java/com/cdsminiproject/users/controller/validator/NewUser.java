package com.cdsminiproject.users.controller.validator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewUser {
	@NotEmpty(message = "${constraints.NotEmpty.message}")
	private String name;

	@NotEmpty(message = "${constraints.NotEmpty.message}")
	private String salary;
}

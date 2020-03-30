package com.cdsminiproject.users.controller.validator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewUserValidator {
	@NotEmpty(message = "'name' must not be empty")
	private String name;

	@DecimalMin(value = "0.0", inclusive = true, message = "'salary' must be a positive number")
	@Digits(integer=20, fraction=2, message = "Only 'salary' values with up to 2 decimal places are allowed")
	@NotEmpty(message = "'salary' must not be empty")
	private String salary;
}

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
	@NotEmpty(message = "${constraints.NotEmpty.message}")
	private String name;

	@DecimalMin(value = "0.0", inclusive = true)
	@Digits(integer=20, fraction=2)
	@NotEmpty(message = "${constraints.NotEmpty.message}")
	private String salary;
}

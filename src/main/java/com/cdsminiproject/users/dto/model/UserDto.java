package com.cdsminiproject.users.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
	private long id;
	private String name;
	@ToString.Exclude
	private Double salary;

//	@ToString.Include(name = "salary")
//	String getSalaryString() {
//		System.out.println(String.format("%.2f", salary));
//		return String.format("%.2f", salary);
//	}
}

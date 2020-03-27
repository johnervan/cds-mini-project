package com.cdsminiproject.users.dto.mapper;


import com.cdsminiproject.users.dto.model.UserDto;
import com.cdsminiproject.users.model.user.User;

public class UserMapper	 {

	public static UserDto toUserDto(User user) {
		return new UserDto().setId(user.getId()).setName(user.getName()).setSalary(user.getSalary());
	}

	public static User toUserModel(UserDto userDto) {
		return new User().setName(userDto.getName()).setSalary(userDto.getSalary());
	}
}

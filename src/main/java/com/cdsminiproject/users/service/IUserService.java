package com.cdsminiproject.users.service;

import com.cdsminiproject.users.dto.model.UserDto;
import com.cdsminiproject.users.model.user.User;

import java.util.List;

public interface IUserService {
	List<UserDto> findAll();

	UserDto createOne(UserDto user);

	List<UserDto> createMany(List<UserDto> userDtoList);
}

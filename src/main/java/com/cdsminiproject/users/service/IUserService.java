package com.cdsminiproject.users.service;

import com.cdsminiproject.users.dto.model.UserDto;

import java.util.List;

public interface IUserService {
	List<UserDto> findAll();

	UserDto createOne(UserDto user);

	List<UserDto> createMany(List<UserDto> userDtoList);
}

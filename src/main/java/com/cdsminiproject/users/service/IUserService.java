package com.cdsminiproject.users.service;

import com.cdsminiproject.users.dto.model.UserDto;

import java.util.List;

/**
 * Service methods to create and retrieve users
 */
public interface IUserService {

	/**
	 * Retrieves all users + their respective salaries from DB
	 * @return userDTOList
	 */
	List<UserDto> findAll();

	/**
	 * Creates a new user + salary in the DB
	 * @param userDto userDTO
	 * @return createdUserDTO
	 */
	UserDto createOne(UserDto userDto);

	/**
	 * Creates a list of users + their respective salary in the DB
	 * @param userDtoList
	 * @return createdUserDTOList
	 */
	List<UserDto> createMany(List<UserDto> userDtoList);
}

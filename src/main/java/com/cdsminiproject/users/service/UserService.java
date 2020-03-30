package com.cdsminiproject.users.service;

import com.cdsminiproject.users.dto.mapper.UserMapper;
import com.cdsminiproject.users.dto.model.UserDto;
import com.cdsminiproject.users.model.user.User;
import com.cdsminiproject.users.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository repository;

	@Override
	public List<UserDto> findAll() {
		List<UserDto> userDtoList = ((List<User>) repository.findAll()).stream().map(u -> UserMapper.toUserDto(u)).collect(Collectors.toList());
		System.out.println(userDtoList.toString());
		return userDtoList;
	}

	@Override
	public UserDto createOne(UserDto userDto) {
		return UserMapper.toUserDto(repository.save(UserMapper.toUserModel(userDto)));
	}

	@Override
	public List<UserDto> createMany(List<UserDto> userDtoList) {
		List<User> userList = userDtoList.stream().map(uDto -> UserMapper.toUserModel(uDto)).collect(Collectors.toList());
		List<User> savedUserList = new ArrayList<>();
		repository.saveAll(userList).forEach(savedUserList::add);
		return savedUserList.stream().map(u -> UserMapper.toUserDto(u)).collect(Collectors.toList());
	}
}

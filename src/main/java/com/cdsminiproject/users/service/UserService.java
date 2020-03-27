package com.cdsminiproject.users.service;

import com.cdsminiproject.users.model.user.User;
import com.cdsminiproject.users.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository repository;

	@Override
	public List<User> findAll() {
		return (List<User>) repository.findAll();
	}
}

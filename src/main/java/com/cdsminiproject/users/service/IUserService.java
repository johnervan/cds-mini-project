package com.cdsminiproject.users.service;

import com.cdsminiproject.users.model.user.User;

import java.util.List;

public interface IUserService {
	List<User> findAll();
}

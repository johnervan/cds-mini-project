package com.cdsminiproject.users.controller.api;

import com.cdsminiproject.users.dto.response.Response;
import com.cdsminiproject.users.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	private IUserService userService;

	@GetMapping("")
	public Response getAllUsers() {
		return Response.success().setPayload(userService.findAll());
	}

}

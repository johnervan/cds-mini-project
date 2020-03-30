package com.cdsminiproject.users.controller;

import com.cdsminiproject.users.controller.api.UsersController;
import com.cdsminiproject.users.dto.model.UserDto;
import com.cdsminiproject.users.service.IUserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(UsersController.class)
public class UsersControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private IUserService userService;

	@Test
	public void whenGetUsers_thenReturnJsonArray() throws Exception {
		UserDto user = new UserDto().setId(1).setName("John Smith").setSalary(new BigDecimal("1234.55"));
		List<UserDto> expectedUserDtoList = new ArrayList<>();
		expectedUserDtoList.add(user);

		Mockito.when(userService.findAll()).thenReturn(expectedUserDtoList);

		mvc.perform(MockMvcRequestBuilders.get("/api/users")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("results", Matchers.hasSize(1)))
				.andExpect(MockMvcResultMatchers.jsonPath("results[0].name", Matchers.is(user.getName())))
				.andExpect(MockMvcResultMatchers.jsonPath("results[0].salary", Matchers.is(user.getSalary())));
	}
}

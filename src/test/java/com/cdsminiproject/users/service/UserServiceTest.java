package com.cdsminiproject.users.service;

import com.cdsminiproject.users.dto.model.UserDto;
import com.cdsminiproject.users.model.user.User;
import com.cdsminiproject.users.repository.user.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {IUserService.class, UserService.class})
public class UserServiceTest {

	@TestConfiguration
	static class UserServiceTestContextConfiguration {
		@Bean
		public IUserService userService() {
			return new UserService();
		}
	}

	@Autowired
	private IUserService userService;

	@MockBean
	private UserRepository userRepository;

	@Test
	public void whenFindAll_thenAllUsersShouldBeReturned() {
		// Set up test
		List<User> userModelList = new ArrayList<>();
		userModelList.add(new User().setId(new Long(1)).setName("John Smith").setSalary(new BigDecimal("1234.55")));
		userModelList.add(new User().setId(new Long(2)).setName("Mary Tan").setSalary(new BigDecimal("5432.11")));
		Mockito.when(userRepository.findAll()).thenReturn(userModelList);
		List<UserDto> expectedUserDtoList = new ArrayList<>();
		expectedUserDtoList.add(new UserDto().setId(1).setName("John Smith").setSalary(new BigDecimal("1234.55")));
		expectedUserDtoList.add(new UserDto().setId(2).setName("Mary Tan").setSalary(new BigDecimal("5432.11")));

		// Run Service
		List<UserDto> userDtoList = userService.findAll();
		Assert.assertEquals(expectedUserDtoList, userDtoList);
	}
}

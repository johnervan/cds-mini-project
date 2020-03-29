package com.cdsminiproject.users.service;

import com.cdsminiproject.users.dto.model.UserDto;
import com.cdsminiproject.users.model.user.User;
import com.cdsminiproject.users.repository.user.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {IUserService.class})
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

	List<User> userModelList = new ArrayList<>();

	@Before
	public void setUp() {
		List<User> userModelList = new ArrayList<>();
		userModelList.add(new User().setId(new Long(1)).setName("John Smith").setSalary(1234.55));
		userModelList.add(new User().setId(new Long(2)).setName("Mary Tan").setSalary(5432.11));
		User newUser = new User().setId(new Long(3)).setName("Mike Robert").setSalary(2342.31);
		Mockito.when(userRepository.findAll()).thenReturn(userModelList);
		Mockito.when(userRepository.save(newUser)).thenReturn(newUser);
	}

	@Test
	public void whenFindAll_thenAllUsersShouldBeReturned() {
		List<UserDto> defaultUserDtoList = new ArrayList<>();
		defaultUserDtoList.add(new UserDto().setId(1).setName("John Smith").setSalary(1234.55));
		defaultUserDtoList.add(new UserDto().setId(2).setName("Mary Tan").setSalary(5432.11));
		List<UserDto> userDtoList = userService.findAll();
		Assert.assertEquals(userDtoList, defaultUserDtoList);
	}

	@Test
	public void whenCreateOne_thenNewUserShouldBeReturned() {
		UserDto newUserDto = userService.createOne(new UserDto().setName("Mike Robert").setSalary(2342.31));
		Assert.assertEquals(newUserDto, new UserDto().setId(3).setName("Mike Robert").setSalary(2342.31));
	}
}

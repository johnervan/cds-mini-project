package com.cdsminiproject.users.controller.api;

import com.cdsminiproject.users.controller.validator.NewUserValidator;
import com.cdsminiproject.users.dto.model.UserDto;
import com.cdsminiproject.users.dto.response.Response;
import com.cdsminiproject.users.exception.CustomException;
import com.cdsminiproject.users.service.IUserService;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	private IUserService userService;

	@GetMapping("")
	public Response getAllUsers() {
		return Response.success().setResults(userService.findAll());
	}

	@PostMapping("")
	public Response createUser(@RequestBody @Valid NewUserValidator newUserValidator) {
			return Response.success().setResults(saveUser(newUserValidator));
	}

	@PostMapping("/upload")
	public Response handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException, CustomException.InvalidUserCsvException {
		List<NewUserValidator> newUserList;
		newUserList = fileToNewUserList(file);
		return Response.success().setResults(saveManyUsers(newUserList));
	}

	private List<NewUserValidator> fileToNewUserList(MultipartFile file) throws IOException, CustomException.InvalidUserCsvException {
		List<NewUserValidator> records = new ArrayList<>();
		Reader reader = new InputStreamReader(file.getInputStream());
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
		String[] values = null;
		while ((values = csvReader.readNext()) != null) {
			if (values.length != 2) {
				throw new CustomException.InvalidUserCsvException("Invalid CSV. Please check and try again.");
			}
			records.add(new NewUserValidator().setName(values[0]).setSalary(values[1]));
		}
		return records;
	}

	private UserDto saveUser(NewUserValidator newUser) {
		UserDto userDto = new UserDto().setName(newUser.getName()).setSalary(new BigDecimal(newUser.getSalary()).setScale(2));
		return userService.createOne(userDto);
	}

	private List<UserDto> saveManyUsers(List<NewUserValidator> newUserList) {
		List<UserDto> userDtoList = newUserList.stream().map(nu -> new UserDto().setName(nu.getName()).setSalary(new BigDecimal(nu.getSalary()).setScale(2))).collect(Collectors.toList());
		return userService.createMany(userDtoList);
	}

}

package com.cdsminiproject.users.controller.api;

import com.cdsminiproject.users.controller.validator.NewUser;
import com.cdsminiproject.users.dto.model.UserDto;
import com.cdsminiproject.users.dto.response.Response;
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
		return Response.success().setPayload(userService.findAll());
	}

	@PostMapping("")
	public Response createUser(@RequestBody @Valid NewUser newUser) {
		return Response.success().setPayload(saveUser(newUser));
	}

	@PostMapping("/upload")
	public Response handleFileUpload(@RequestParam("file") MultipartFile file) {
		List<NewUser> newUserList;
		try {
			newUserList = fileToNewUserList(file);
			return Response.success().setPayload(saveManyUsers(newUserList));
		} catch(Exception ex) {
			return Response.internalServerError().setPayload(ex);
		}
	}

	private List<NewUser> fileToNewUserList(MultipartFile file) throws IOException {
		List<NewUser> records = new ArrayList<>();
		Reader reader = new InputStreamReader(file.getInputStream());
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
		String[] values = null;
		while ((values = csvReader.readNext()) != null) {
			System.out.println(values);
			if (values.length != 2) {
				throw new IOException("Invalid user");
			}
			records.add(new NewUser().setName(values[0]).setSalary(values[1]));
		}
		return records;
	}

	private UserDto saveUser(NewUser newUser) {
		UserDto userDto = new UserDto().setName(newUser.getName()).setSalary(Double.parseDouble(newUser.getSalary()));
		return userService.createOne(userDto);
	}

	private List<UserDto> saveManyUsers(List<NewUser> newUserList) {
		List<UserDto> userDtoList = newUserList.stream().map(nu -> new UserDto().setName(nu.getName()).setSalary(Double.parseDouble(nu.getSalary()))).collect(Collectors.toList());
		return userService.createMany(userDtoList);
	}

}

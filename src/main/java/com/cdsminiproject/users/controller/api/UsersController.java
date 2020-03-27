package com.cdsminiproject.users.controller.api;

import com.cdsminiproject.users.dto.response.Response;
import com.cdsminiproject.users.service.IUserService;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	private IUserService userService;

	@GetMapping("/")
	public Response getAllUsers() {
		return Response.success().setPayload(userService.findAll());
	}

	@PostMapping("/upload")
	public Response handleFileUpload(@RequestParam("file") MultipartFile file) {
		List<List<String>> records = new ArrayList<>();
		try {
			Reader reader = new InputStreamReader(file.getInputStream());
			CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
			String[] values = null;
			while ((values = csvReader.readNext()) != null) {
				System.out.println(values);
				records.add(Arrays.asList(values));
			}
			return Response.success().setPayload(records);
		} catch(Exception ex) {
			return Response.internalServerError().setPayload(ex);
		}
	}

}

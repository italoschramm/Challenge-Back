package com.italoschramm.apivotacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.italoschramm.apivotacao.dto.UserClientDTO;
import com.italoschramm.apivotacao.service.user.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserClientDTO user) {
		
		if (userService.existsUser(user.getUsername()))
			return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists!");
		
		if(userService.registerUser(user.getUsername(), user.getPassword(), user.getAccountType()))
			 return ResponseEntity.status(HttpStatus.CREATED).body("Saved successfully.");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Save error!");
	}

}

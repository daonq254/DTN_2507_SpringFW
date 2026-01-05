package com.vti.controller;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/login")
@CrossOrigin("*")
public class LoginController {
	@GetMapping()
	public ResponseEntity<?> checklogin(Principal principal) {
//		Trả về thông tin chi tiết của đối tượng vừa login
		System.out.println("principal: " + principal);
		System.out.println("Username: " + principal.getName()); // Username
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}

}

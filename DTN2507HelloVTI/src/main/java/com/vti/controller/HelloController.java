package com.vti.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.form.HelloFormForCreating;

@RestController
@RequestMapping(value = "api/v1/hello")
@CrossOrigin("*")
public class HelloController {

//	http://localhost:8080/api/v1/hello?search=daonq&page=1&size=1
	@GetMapping()
	public String getHello(@RequestParam("search") String search, @RequestParam("page") String page,
			@RequestParam("size") String size) {
		System.out.println("search: " + search);
		System.out.println("page: " + page);
		System.out.println("size: " + size);
		return "HELLO VTI ";
	}

	@PostMapping()
	public String createHello(@RequestBody HelloFormForCreating formCreate) {
		System.out.println("username: " + formCreate.getUsername());
		System.out.println("email: " + formCreate.getEmail());
		System.out.println("password: " + formCreate.getPassword());
		System.out.println("creatDate: " + formCreate.getCreateDate());
		return "Create VTI ";
	}

	@PutMapping()
	public String updateHello() {
		return "Update VTI ";
	}

//	"api/v1/hello/{id}"
	@DeleteMapping("/{id}/{username}/{email}")
	public String deleteHello(@PathVariable("id") int id, @PathVariable("username") String username,
			@PathVariable("email") String email) {
		System.out.println("id: " + id);
		System.out.println("username: " + username);
		System.out.println("email: " + email);
		return id + " " + username + " " + email;
	}
}

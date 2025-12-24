package com.vti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.AccontDto;
import com.vti.entity.Account;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForUpdating;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
@CrossOrigin("*")
public class AccountController {

	@Autowired
	private IAccountService accountService;

//	GetAllAccount
	@GetMapping()
	public ResponseEntity<?> getAllAccounts() {
		List<Account> listAccounts = accountService.getAllAccounts();
//
		List<AccontDto> listAccountDtos = new ArrayList<>();
		for (Account account : listAccounts) {
			AccontDto accontDto = new AccontDto();
			accontDto.setId(account.getId());
			accontDto.setEmail(account.getEmail());
			accontDto.setUsername(account.getUsername());
			accontDto.setFullname(account.getFullname());
			accontDto.setDepartment(account.getDepartment().getName());
			accontDto.setPosition(account.getPosition().getName().toString());
			accontDto.setCreateDate(account.getCreateDate());

			listAccountDtos.add(accontDto);
		}

//		
		return new ResponseEntity<>(listAccountDtos, HttpStatus.OK);
	}

//	getAccountById
//	http://localhost:8080/api/v1/accounts/2
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable(name = "id") short id) {
		Account account = accountService.getAccountById(id);

		AccontDto accontDto = new AccontDto();
		accontDto.setId(account.getId());
		accontDto.setEmail(account.getEmail());
		accontDto.setUsername(account.getUsername());
		accontDto.setFullname(account.getFullname());
		accontDto.setDepartment(account.getDepartment().getName());
		accontDto.setPosition(account.getPosition().getName().toString());
		accontDto.setCreateDate(account.getCreateDate());

		return new ResponseEntity<>(accontDto, HttpStatus.OK);
	}

//	Tạo mới Account
	@PostMapping()
	public ResponseEntity<?> createNewAccount(@RequestBody AccountFormForCreating formCreating) {
		Account account = accountService.createNewAccount(formCreating);

		AccontDto accontDto = new AccontDto();
		accontDto.setId(account.getId());
		accontDto.setEmail(account.getEmail());
		accontDto.setUsername(account.getUsername());
		accontDto.setFullname(account.getFullname());
		accontDto.setDepartment(account.getDepartment().getName());
		accontDto.setPosition(account.getPosition().getName().toString());
		accontDto.setCreateDate(account.getCreateDate());

		return new ResponseEntity<>(accontDto, HttpStatus.OK);
	}

//	Update Account
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateAccount(@RequestBody AccountFormForUpdating formUpdating,
			@PathVariable(name = "id") short id) {
		Account account = accountService.updateAccount(id, formUpdating);

		AccontDto accontDto = new AccontDto();
		accontDto.setId(account.getId());
		accontDto.setEmail(account.getEmail());
		accontDto.setUsername(account.getUsername());
		accontDto.setFullname(account.getFullname());
		accontDto.setDepartment(account.getDepartment().getName());
		accontDto.setPosition(account.getPosition().getName().toString());
		accontDto.setCreateDate(account.getCreateDate());

		return new ResponseEntity<>(accontDto, HttpStatus.OK);
	}

//	Tìm Account theo Username
	@GetMapping(value = "/username/{username}")
	public ResponseEntity<?> getAccountByUsername(@PathVariable(name = "username") String username) {
		Account account = accountService.getAccountByUsername(username);

		AccontDto accontDto = new AccontDto();
		accontDto.setId(account.getId());
		accontDto.setEmail(account.getEmail());
		accontDto.setUsername(account.getUsername());
		accontDto.setFullname(account.getFullname());
		accontDto.setDepartment(account.getDepartment().getName());
		accontDto.setPosition(account.getPosition().getName().toString());
		accontDto.setCreateDate(account.getCreateDate());

		return new ResponseEntity<>(accontDto, HttpStatus.OK);
	}
}

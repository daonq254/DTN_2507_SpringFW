package com.vti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.AccontDto;
import com.vti.dto.UsernameDto;
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

	@Autowired
	private ModelMapper modelMapper;

//	GetAllAccount
	@GetMapping()
	public ResponseEntity<?> getAllAccounts(Pageable pageable, @RequestParam(required = false) String search) {

//		System.out.println("pageable: " + pageable);
		System.out.println("search: " + search);

		Page<Account> pageAccounts = accountService.getAllAccounts(pageable, search);
//
//		List<AccontDto> listAccountDtos = new ArrayList<>();
//		for (Account account : listAccounts) {
//			AccontDto accontDto = new AccontDto();
//			accontDto.setId(account.getId());
//			accontDto.setEmail(account.getEmail());
//			accontDto.setUsername(account.getUsername());
//			accontDto.setFullname(account.getFullname());
//			accontDto.setDepartment(account.getDepartment().getName());
//			accontDto.setPosition(account.getPosition().getName().toString());
//			accontDto.setCreateDate(account.getCreateDate());
//
//			listAccountDtos.add(accontDto);
//		}
//		Page<AccontDto> pageAccountDtos = pageAccounts.map(account -> {
//
//			AccontDto accountDto = modelMapper.map(account, AccontDto.class);
//			accountDto.setPosition(account.getPosition().getName().toString());
//			return accountDto;
//		});

		Page<AccontDto> pageAccountDtos = pageAccounts.map(new Function<Account, AccontDto>() {

			@Override
			public AccontDto apply(Account account) {
				AccontDto accontDto = new AccontDto();
				accontDto.setId(account.getId());
				accontDto.setEmail(account.getEmail());
				accontDto.setUsername(account.getUsername());
				accontDto.setFullname(account.getFullname());
				accontDto.setDepartment(account.getDepartment().getName());
				accontDto.setPosition(account.getPosition().getName().toString());
				accontDto.setCreateDate(account.getCreateDate());

				return accontDto;
			}

		});

		return new ResponseEntity<>(pageAccountDtos, HttpStatus.OK);
	}

//	getAccountById
//	http://localhost:8080/api/v1/accounts/2
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable(name = "id") short id) {

		Account account = accountService.getAccountById(id);

//		AccontDto accontDto = new AccontDto();
//		accontDto.setId(account.getId());
//		accontDto.setEmail(account.getEmail());
//		accontDto.setUsername(account.getUsername());
//		accontDto.setFullname(account.getFullname());
//		accontDto.setDepartment(account.getDepartment().getName());
//		accontDto.setPosition(account.getPosition().getName().toString());
//		accontDto.setCreateDate(account.getCreateDate());

		AccontDto accountDto = modelMapper.map(account, AccontDto.class);
		accountDto.setPosition(account.getPosition().getName().toString());

		return new ResponseEntity<>(accountDto, HttpStatus.OK);

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
			@PathVariable(name = "id") Short id) {
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

//	Tìm theo email hoặc username(or)
	@GetMapping(value = "/existByUsernameOrEmail")
	public ResponseEntity<?> existByUsernameOrEmail(@RequestParam String username, @RequestParam String email) {
		boolean result = accountService.existByUsernameOrEmail(username, email);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

//	Hãy tìm Account mới nhất trên hệ thống
	@GetMapping(value = "/lastest")
	public ResponseEntity<?> getLastestAccount() {
		Account account = accountService.getLastestAccount();

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

//	Hãy tìm Account trong khoảng id: idFrom: 3, idTo: 6
	@GetMapping(value = "/range")
	public ResponseEntity<?> getAccountByIdRange(@RequestParam short idFrom, @RequestParam short idTo) {
		List<Account> accounts = accountService.getAccountByIdRange(idFrom, idTo);
		List<AccontDto> accontDtos = new ArrayList<>();
		for (Account account : accounts) {
			AccontDto accontDto = new AccontDto();
			accontDto.setId(account.getId());
			accontDto.setEmail(account.getEmail());
			accontDto.setUsername(account.getUsername());
			accontDto.setFullname(account.getFullname());
			accontDto.setDepartment(account.getDepartment().getName());
			accontDto.setPosition(account.getPosition().getName().toString());
			accontDto.setCreateDate(account.getCreateDate());

			accontDtos.add(accontDto);
		}

		return new ResponseEntity<>(accontDtos, HttpStatus.OK);
	}

//	Hãy tìm Account trong khoảng [1,3,4,8]
	@PostMapping(value = "/byIds")
	public ResponseEntity<?> getAccountByIds(@RequestBody List<Short> ids) {
		List<Account> accounts = accountService.getAccountByIds(ids);

		List<AccontDto> accontDtos = new ArrayList<>();
		for (Account account : accounts) {
			AccontDto accontDto = new AccontDto();
			accontDto.setId(account.getId());
			accontDto.setEmail(account.getEmail());
			accontDto.setUsername(account.getUsername());
			accontDto.setFullname(account.getFullname());
			accontDto.setDepartment(account.getDepartment().getName());
			accontDto.setPosition(account.getPosition().getName().toString());
			accontDto.setCreateDate(account.getCreateDate());

			accontDtos.add(accontDto);
		}

		return new ResponseEntity<>(accontDtos, HttpStatus.OK);
	}

//	Lấy danh sách Username đang có trên hệ thống
	@GetMapping(value = "/usernames")
	public ResponseEntity<?> getAllUsernames() {
		List<String> usernames = accountService.getAllUsernames();
		List<UsernameDto> usernamesDtos = new ArrayList();

		for (String username : usernames) {
			UsernameDto usernameDto = new UsernameDto();
			usernameDto.setUsername(username);

			usernamesDtos.add(usernameDto);
		}

		return new ResponseEntity<>(usernamesDtos, HttpStatus.OK);
	}
//	jpql
//	Tìm danh sách account theo id phòng ban truyền vào

//	Tìm danh sách account theo tên của Position
}

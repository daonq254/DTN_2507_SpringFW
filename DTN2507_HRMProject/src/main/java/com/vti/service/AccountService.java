package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.form.AccountFormForCreating;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;
import com.vti.repository.IPossitionRepository;

@Service
@Transactional
public class AccountService implements IAccountService {
	@Autowired
	private IAccountRepository accountRepository;

	@Autowired
	private IDepartmentRepository departmentRepository;

	@Autowired
	private IPossitionRepository possitionRepository;

	@Override
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	@Override
	public Account getAccountById(short id) {
		// TODO Auto-generated method stub

		return accountRepository.getById(id);
	}
//	

	@Override
	public Account createNewAccount(AccountFormForCreating formCreating) {
//		formCreating  ==> account
		Account account = new Account();
		account.setUsername(formCreating.getUsername());
		account.setEmail(formCreating.getEmail());
		account.setFullname(formCreating.getFullname());
//		departmentId   ==> tìm Department tương ứng
		Department department = departmentRepository.getById(formCreating.getDepartmentId());
		account.setDepartment(department);

		Position position = possitionRepository.getById(formCreating.getPositionId());
		account.setPosition(position);

		Account account_new = accountRepository.save(account);

		return account_new;
	}
}

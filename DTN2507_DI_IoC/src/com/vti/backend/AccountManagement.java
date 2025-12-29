package com.vti.backend;

import java.util.List;

import com.vti.dao.IAccountDao;
import com.vti.entiy.Account;

public class AccountManagement {
	private IAccountDao accountDao;

	public AccountManagement(IAccountDao db_connect_method) {
		super();
		accountDao = db_connect_method; // Chọn cách thức kết nối DB
	}

	public Boolean createNewAccount(Account account) {
//		AccountDao accountDao = new AccountDao(); jdbc
//		Boolean result = accountDao.createNewAccount(account);

//		AccountDao_Hibernate accountDao_Hibernate = new AccountDao_Hibernate();
		Boolean result = accountDao.createNewAccount(account);
		return result;
	}

	public List<Account> getAllAcocunt() {
//		AccountDao accountDao = new AccountDao(); jdbc
//		Boolean result = accountDao.createNewAccount(account);

//		AccountDao_Hibernate accountDao_Hibernate = new AccountDao_Hibernate();
		accountDao.getAllAcocunt();
		return null;
	}
}

package com.vti.dao;

import java.util.List;

import com.vti.entiy.Account;

public interface IAccountDao {
	public Boolean createNewAccount(Account account);

	public List<Account> getAllAcocunt();
}

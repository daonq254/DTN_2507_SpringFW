package com.vti.service;

import java.util.List;

import com.vti.entity.Account;
import com.vti.form.AccountFormForCreating;

public interface IAccountService {

	List<Account> getAllAccounts();

	Account getAccountById(short id);

	Account createNewAccount(AccountFormForCreating formCreating);

}

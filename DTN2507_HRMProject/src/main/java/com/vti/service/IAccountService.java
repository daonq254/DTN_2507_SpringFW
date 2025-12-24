package com.vti.service;

import java.util.List;

import com.vti.entity.Account;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForUpdating;

public interface IAccountService {

	List<Account> getAllAccounts();

	Account getAccountById(short id);

	Account createNewAccount(AccountFormForCreating formCreating);

	Account updateAccount(short id, AccountFormForUpdating formUpdating);

}

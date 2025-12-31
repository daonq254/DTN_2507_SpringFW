package com.vti.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Account;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForUpdating;

public interface IAccountService {

	Page<Account> getAllAccounts(Pageable pageable, String search);

	Account getAccountById(short id);

	Account createNewAccount(AccountFormForCreating formCreating);

	Account updateAccount(short id, AccountFormForUpdating formUpdating);

	Account getAccountByUsername(String username);

	boolean existByUsernameOrEmail(String username, String email);

	Account getLastestAccount();

	List<Account> getAccountByIdRange(short idFrom, short idTo);

	List<Account> getAccountByIds(List<Short> ids);

	List<String> getAllUsernames();

}

package com.vti.frontend;

import com.vti.backend.AccountManagement;
import com.vti.dao.AccountDao_Hibernate;
import com.vti.entiy.Account;

public class Prgram {
	public static void main(String[] args) {
// Thêm mới account
//		Có thông tin account cần thêm mới
		Account account = new Account();
		account.setId(1);
		account.setUsername("daonq");

//		
		AccountManagement accountManagement = new AccountManagement(new AccountDao_Hibernate());
		Boolean result_CreateNewAccount = accountManagement.createNewAccount(account);
		if (result_CreateNewAccount) {
			System.out.println("Thêm mới thành công");
		} else {
			System.out.println("Không thành công");
		}

//		
	}
}

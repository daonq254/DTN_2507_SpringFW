package com.vti.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Account;

public interface IAccountRepository extends JpaRepository<Account, Short> {
//	Khai báo hàm tìm Account theo Username
	Optional<Account> findByUsername(String username);

	Optional<Account> findByEmail(String email);

	Account getByUsername(String username);

	Account getByEmail(String email);
//	account
//	null   
//	=>> account.getEmail()   ==> Null Pointer Exception

}

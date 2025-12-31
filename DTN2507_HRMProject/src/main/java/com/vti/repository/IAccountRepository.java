package com.vti.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vti.entity.Account;

public interface IAccountRepository extends JpaRepository<Account, Short>, JpaSpecificationExecutor<Account> {
//	Khai báo hàm tìm Account theo Username
	Optional<Account> findByUsername(String username);

	Optional<Account> findByEmail(String email);

	Account getByUsername(String username);

	Account getByEmail(String email);

//	account
//	null   
//	=>> account.getEmail()   ==> Null Pointer Exception
//	Kiểm tra sự tồn tại theo username hoặc email
	boolean existsByUsernameOrEmail(String username, String email);

//	Hàm tìm account mới nhất được tạo
	Account findTopByOrderByIdDesc();

//	Hàm tìm account theo dải id
	List<Account> findByIdBetween(short idFrom, short idTo);

//	Lấy danh sách Username đang có trên hệ thống
// 	JPQL
//	Làm việc theo OOP
//	Độc lập với CSDL
	@Query("select a.username from Account a")
	List<String> getAllUsernames();

//	Tìm danh sách account theo id phòng ban truyền vào: departmentId
	@Query("SELECT a FROM Account a WHERE a.department.id = :depIdParam")
	List<Account> getAccountsByDepID(@Param("depIdParam") short departmentId);

//	Tìm danh sách account theo tên của Position: Dev
	@Query(value = """
			SELECT * FROM `account` a INNER JOIN `position` p
			ON a.PositionID = p.PositionID
			WHERE p.PositionName = :posName;
						""", nativeQuery = true)
	List<Account> getAccountsByPositionName(@Param("posName") short positionName);

}

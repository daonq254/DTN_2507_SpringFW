package com.vti.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AccountFormForCreating {
	@NotBlank(message = "Email không được để trống")
	@Email(message = "Email không hợp lệ")
	private String email;

	@NotBlank(message = "Username không được để trống")
	@Size(min = 3, max = 20, message = "Username phải từ 3–20 ký tự")
	private String username;

	@NotBlank(message = "Fullname không được để trống")
	private String fullname;

	@NotNull(message = "DepartmentId không được để trống")
	private Short departmentId;

	@NotNull(message = "PositionId không được để trống")
	private Short positionId;

	public AccountFormForCreating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Short getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Short departmentId) {
		this.departmentId = departmentId;
	}

	public Short getPositionId() {
		return positionId;
	}

	public void setPositionId(Short positionId) {
		this.positionId = positionId;
	}

}

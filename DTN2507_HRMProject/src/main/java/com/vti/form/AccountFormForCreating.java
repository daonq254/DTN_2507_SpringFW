package com.vti.form;

public class AccountFormForCreating {

	private String email;

	private String username;

	private String fullname;

	private Short departmentId;

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

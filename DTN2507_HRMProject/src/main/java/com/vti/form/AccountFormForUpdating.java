package com.vti.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AccountFormForUpdating {
	@NotBlank(message = "Fullname không được để trống")
	private String fullname;

	@NotNull(message = "DepartmentId không được để trống")
	private Short departmentId;

	@NotNull(message = "PositionId không được để trống")
	private Short positionId;

	public AccountFormForUpdating() {
		super();
		// TODO Auto-generated constructor stub
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

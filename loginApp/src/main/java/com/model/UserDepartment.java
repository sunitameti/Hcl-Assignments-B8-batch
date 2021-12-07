package com.model;

public class UserDepartment {

	private String departmentName;
	private int departmentId;
	private User user;

	public UserDepartment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserDepartment(String departmentName, int departmentId, User user) {
		super();
		this.departmentName = departmentName;
		this.departmentId = departmentId;
		this.user = user;
	}

}

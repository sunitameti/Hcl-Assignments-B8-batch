package com.dao;

import com.exception.UserException;
import com.model.UserDepartment;

public interface UserDAO {
	// CRUD operations
	public abstract UserDepartment authoriseDao(int userId, String password) throws UserException;

}

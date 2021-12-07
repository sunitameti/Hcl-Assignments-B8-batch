package com.service;

import com.exception.UserException;
import com.model.User;
import com.model.UserDepartment;

public interface UserService {
	// Here we need to follow the CRUD operations/functions

	// public abstract User createValidate(User user) throws UserException;

	// public abstract User readValidateUserId(int userId) throws UserException;

	public abstract UserDepartment authorise(int userId, String password) throws UserException;

	//public abstract UserDepartment authoriseValidation(int userId, String password);

	// public abstract int updateValidate(User user) throws UserException;

	// public abstract int deleteValidateByUserId(int userId) throws UserException;

}

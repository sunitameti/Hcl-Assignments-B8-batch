package com.service;

import com.dao.UserDAO;
import com.dao.UserDaoImpl;
import com.exception.UserException;
import com.model.UserDepartment;

public class UserServiceImpl implements UserService {

	@Override
	public UserDepartment authorise(int userId, String password) throws UserException {
		// to find length of integer
		UserDepartment user = null;
		int lengthOfUserId = String.valueOf(userId).length();
		int lengthOfUserPassword = password.length();
		if (lengthOfUserId >= 5 && lengthOfUserPassword >= 5)// 51mints in video
		{
			// logic success
			// got to dao layer
			UserDAO userDao = new UserDaoImpl();
			user = userDao.authoriseDao(userId, password);
		} else {
			// logic failure
			// raise an exception
			throw new UserException("Invalid userId and password");
		}

		return user;
	}

}

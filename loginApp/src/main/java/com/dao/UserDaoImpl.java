package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.exception.UserException;
import com.model.User;
import com.model.UserDepartment;

public class UserDaoImpl implements UserDAO {
	public List<UserDepartment> init() {
		UserDepartment userDept1 = new UserDepartment("ECE", 1, new User(11111, "First", "first123"));
		UserDepartment userDept2 = new UserDepartment("CSE", 2, new User(22222, "Second", "secon123"));
		UserDepartment userDept3 = new UserDepartment("ENE", 3, new User(33333, "Third", "third123"));
		UserDepartment userDept4 = new UserDepartment("ISE", 4, new User(44444, "Fourth", "four123"));

		List<UserDepartment> deptList = new ArrayList<UserDepartment>();
		deptList.add(userDept1);
		deptList.add(userDept2);
		deptList.add(userDept3);
		deptList.add(userDept4);
		return deptList;

	}

	@Override
	public UserDepartment authoriseDao(int userId, String password) throws UserException {
		// go to database and get the data

		List<UserDepartment> departments = this.init();
		UserDepartment departmentResult = null;
		if (departments.size() > 0) {

			for (UserDepartment department : departments) {

				if (department.getUser().getUserId() == userId && department.getUser().getPassword().equals(password)) {

					departmentResult = department;
				}
			}
		}

		if (departmentResult != null) {

			return departmentResult;

		} else {

			throw new UserException("No Such User Found");

		}

	}
}

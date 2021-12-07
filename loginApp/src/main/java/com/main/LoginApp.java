package com.main;

import java.util.Scanner;

import com.exception.UserException;
import com.model.UserDepartment;
import com.service.UserService;
import com.service.UserServiceImpl;

public class LoginApp {

	public static void main(String[] args) {
		// we need to write dynamic data == user interface(UI)
		int userId = 0;
		String password = null;
		Scanner clientInput = new Scanner(System.in);
		System.out.println("Enter User Id:");

		if (clientInput.hasNextInt()) {
			userId = clientInput.nextInt();

		}
		System.out.println("Enter Your Password:");

		if (clientInput.hasNext()) {
			password = clientInput.next();
		}

		UserService userService = new UserServiceImpl();
		try {
			UserDepartment department = userService.authorise(userId, password);
			if (department != null) {

				System.out.println("Welcome :" + department.getUser().getUsername());
				System.out.println("User Id " + department.getUser().getUserId());
				System.out.println("Department Name Of Employee:" + department.getDepartmentName());

			}
		} catch (UserException e) {
			System.err.println(e.getMessage());
		} finally {

			clientInput.close();

		}

	}

}

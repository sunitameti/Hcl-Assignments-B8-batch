package com.hcl.pp.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.pp.dao.UserDAO;
import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDAO userDAO;

	@Override
	public String addUser(User user) {
		LOGGER.info("UsersController addUser Method Requset Comes Into UserServiceImpl Layer"
				+ "UserServiceImpl addUser Method Start");
		String statusAddUser = null;
		if (user.getUserPassword().equals(user.getConfirmPassword())) {
			if (user != null && user.getUserName() != null && user.getUserPassword() != null) {

				statusAddUser = userDAO.addUser(user);
				LOGGER.info("UserDAOInterface addUser Method Return Result Is" + statusAddUser);

			}
		} else {
			statusAddUser = "plz check confirm password is same as userpassword ";
			LOGGER.info("plz check confirm password is same as userpassword ");

		}

		LOGGER.info("UserServiceImpl addUser Method End");

		return statusAddUser;
	}

	@Override
	public User updateUser(User user) {

		LOGGER.info("UsersController updateUser Method Requset Comes Into UserServiceImpl Layer"
				+ "UserServiceImpl updateUser Method Start");

		User userTwo = null;
		if (user != null && user.getId() > 0 && user.getUserName() != null && user.getUserPassword() != null) {
			userTwo = userDAO.updateUser(user);
			LOGGER.info("UserDAOInterface updateUser Method Return Result");
		}

		LOGGER.info("UserServiceImpl updateUser Method End");

		return userTwo;
	}

	@Override
	public List<User> listUsers() {
		LOGGER.info("UsersController listUsers Method Requset Comes Into UserServiceImpl Layer"
				+ "UserServiceImpl listUsers Method Start");
		LOGGER.info("UserDAOInterface listUsers Method Return Result");
		LOGGER.info("UserServiceImpl listUsers Method End");

		return userDAO.listUsers();
	}

	@Override
	public User getUserById(long userId) {
		LOGGER.info("UsersController getUserById Method Requset Comes Into UserServiceImpl Layer"
				+ "UserServiceImpl getUserById Method Start");

		User user = null;
		if (userId > 0) {
			user = userDAO.getUserById(userId);
			LOGGER.info("UserDAOInterface getUserById Method Return Result");

		}

		LOGGER.info("UserServiceImpl getUserById Method End");
		return user;
	}

	@Override
	public String removeUser(long userId) {
		String statusOfRemoveUser = null;
		if (userId > 0) {
			statusOfRemoveUser = userDAO.removeUser(userId);
		}
		return statusOfRemoveUser;
	}

	@Override
	public List<Pet> authenticateUser(String userName, String password) {
		LOGGER.info("UsersController loginUser Method Requset Comes Into UserServiceImpl Layer"
				+ "UserServiceImpl authenticateUser Method Start");
		List<Pet> pets = null;
		if (userName != null && password != null) {
			pets = userDAO.authenticateUser(userName, password);
			LOGGER.info("UserDAOInterface authenticateUser Method Return Result");
		}
		LOGGER.info("UserServiceImpl authenticateUser Method End");
		return pets;
	}

	@Override
	public User findByUserName(String username) {
		LOGGER.info("UsersController findByUserName Method Requset Comes Into UserServiceImpl Layer"
				+ "UserServiceImpl findByUserName Method Start");
		User user = null;
		if (username != null) {
			user = userDAO.findByUserName(username);
			LOGGER.info("UserDAOInterface findByUserName Method Return Result");
		}

		LOGGER.info("UserServiceImpl findByUserName Method End");
		return user;
	}

	@Override
	public int buyPet(long userId, long petId) {
		LOGGER.info("UsersController buyPet Method Requset Comes Into UserServiceImpl Layer"
				+ "UserServiceImpl buyPet Method Start");
		int numberOfRowAffected = 0;

		if (userId > 0 && petId > 0) {
			numberOfRowAffected = userDAO.buyPet(userId, petId);
			LOGGER.info("UserDAOInterface buyPet Method Return Result");

		}
		LOGGER.info("UserServiceImpl buyPet Method End");
		return numberOfRowAffected;
	}

	@Override
	public String deleteUser(long userId) {
		LOGGER.info("UsersController deleteUser Method Requset Comes Into UserServiceImpl Layer"
				+ "UserServiceImpl deleteUser Method Start");
		String statusOfRemoveUser = null;
		if (userId > 0) {
			statusOfRemoveUser = userDAO.removeUser(userId);
			LOGGER.info("UserDAOInterface deleteUser Method Return Result");
		}
		LOGGER.info("UserServiceImpl deleteUser Method End");
		return statusOfRemoveUser;
	}

	@Override
	public List<Pet> getMyPets(long userId) {
		LOGGER.info("UsersController getMyPets Method Requset Comes Into UserServiceImpl Layer"
				+ "UserServiceImpl getMyPets Method Start");
		List<Pet> pets = null;
		if (userId > 0) {
			pets = userDAO.getMyPets(userId);
			LOGGER.info("UserDAOInterface getMyPets Method Return Result");

		}
		LOGGER.info("UserServiceImpl getMyPets Method End");
		return pets;
	}

	@Override
	public String loginApp(String userName, String password) {

		String loginStatus = "";
		LOGGER.info("UsersController loginUserOne Method Requset Comes Into UserServiceImpl Layer"
				+ "UserServiceImpl loginApp Method Start");

		loginStatus = userDAO.loginApp(userName, password);
		LOGGER.info("UserDAOInterface loginApp Method Return Result");

		LOGGER.info("UserServiceImpl loginApp Method End");

		return loginStatus;
	}

}

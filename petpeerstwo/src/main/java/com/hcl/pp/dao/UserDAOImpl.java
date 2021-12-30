package com.hcl.pp.dao;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;
import com.hcl.pp.repository.PetRepository;
import com.hcl.pp.repository.UserRepository;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger LOGGER = LogManager.getLogger(UserDAOImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PetRepository petRepository;

	@Override
	public String addUser(User user) {

		LOGGER.info("UsersController addUser Method Requset Comes Into UserDAOImpl Layer"
				+ "UserDAOImpl addUser Method Start");
		String statusAddUser = null;

		User userOne = userRepository.findByName(user.getUserName());
		LOGGER.info(
				"UsersController addUser Method Requset Goging Into UserRepository Class Calling findByName Return User Object:"
						+ " Purpose Checking userName Present In DB Or Not" + userOne);

		if (userOne == null) {

			User userTwo = userRepository.save(user);
			LOGGER.info("User Data Saved Into DataBase");
			if (userTwo != null) {

				statusAddUser = "Your are successfully registerd please sign in";
				LOGGER.info("Your are successfully registerd please sign in");

			} else {

				statusAddUser = "Your are not successfully registerd please try agin";
				LOGGER.info("Your are not successfully registerd please try agin");

			}

		} else {
			statusAddUser = "Your are already registered user";
			LOGGER.info("Your are already registered user");
		}

		LOGGER.info("UserDAOImpl addUser Method End");

		return statusAddUser;
	}

	@Override
	public User updateUser(User user) {
		LOGGER.info("UsersController updateUser Method Requset Comes Into UserDAOImpl Layer"
				+ "UserDAOImpl updateUser Method Start");
		User userOne = null;
		Optional<User> optionalUser = userRepository.findById(user.getId());
		LOGGER.info(
				"UsersController updateUser Method Requset Goging Into UserRepository Class Calling findById Return Optional User Object:"
						+ " Purpose Checking userId Present In DB Or Not");
		if (optionalUser.isPresent()) {
			userOne = userRepository.save(user);
			LOGGER.info("User Data Upadte Into DataBase");
		}

		LOGGER.info("UserDAOImpl updateUser Method End");

		return userOne;
	}

	@Override
	public List<User> listUsers() {
		LOGGER.info("UsersController listUsers Method Requset Comes Into UserDAOImpl Layer"
				+ "UserDAOImpl listUsers Method Start");
		List<User> users = null;
		users = userRepository.findAll();
		LOGGER.info("User Data Return Into DataBase");
		if (users.size() > 0) {
			LOGGER.info("UserDAOImpl updateUser Method End");
			return users;
		} else {
			LOGGER.info("UserDAOImpl updateUser Method End");
			return null;
		}

	}

	@Override
	public User getUserById(long userId) {
		LOGGER.info("UsersController getUserById Method Requset Comes Into UserDAOImpl Layer"
				+ "UserDAOImpl getUserById Method Start");
		User user = null;
		Optional<User> optionalUser = userRepository.findById(userId);

		if (optionalUser.isPresent()) {
			user = optionalUser.get();
			LOGGER.info("User Data Get Into DataBase");
		}
		LOGGER.info("UserDAOImpl getUserById Method End");
		return user;
	}

	@Override
	public String removeUser(long userId) {

		String statusOfRemoveUser = null;
		Optional<User> optionalUser = userRepository.findById(userId);

		if (optionalUser.isPresent()) {
			userRepository.deleteById(userId);
			statusOfRemoveUser = "User Record Is Removed";
		} else {
			statusOfRemoveUser = "User Record Is Not Present Is DB";

		}

		return statusOfRemoveUser;
	}

	@Override
	public List<Pet> authenticateUser(String userName, String password) {
		LOGGER.info("UsersController loginUser Method Requset Comes Into UserDAOImpl Layer"
				+ "UserDAOImpl authenticateUser Method Start");
		List<Pet> pets = null;

		User user = userRepository.findByNameAndPassword(userName, password);

		if (user != null) {

			pets = petRepository.findAllRecord();
			LOGGER.info("Pet Data Get Into DataBase");

		}

		LOGGER.info("UserDAOImpl authenticateUser Method End");

		return pets;
	}

	@Override
	public User findByUserName(String username) {
		LOGGER.info("UsersController findByUserName Method Requset Comes Into UserDAOImpl Layer"
				+ "UserDAOImpl findByUserName Method Start");

		User user = userRepository.findByName(username);
		LOGGER.info("User Data Get Into DataBase");
		LOGGER.info("UserDAOImpl findByUserName Method End");

		return user;
	}

	@Override
	public int buyPet(long userId, long petId) {
		LOGGER.info("UsersController buyPet Method Requset Comes Into UserDAOImpl Layer"
				+ "UserDAOImpl buyPet Method Start");
		int numberOfRowAffected = 0;
		Optional<User> optionalUser = userRepository.findById(userId);
		Optional<Pet> optionalPet = petRepository.findById(petId);
		LOGGER.info(
				"UsersController buyPet Method Requset Goging Into UserRepository Class Calling findById Return Optional User & Pet Object:"
						+ " Purpose Checking userId & Pet Id Present In DB Or Not");

		if (optionalUser.isPresent() && optionalPet.isPresent()) {

			numberOfRowAffected = petRepository.updatePetByUserId(userId, petId);
			LOGGER.info("User Data Upadte Into DataBase");

		}

		LOGGER.info("UserDAOImpl buyPet Method End");

		return numberOfRowAffected;
	}

	@Override
	public String deleteUser(long userId) {
		LOGGER.info("UsersController deleteUser Method Requset Comes Into UserDAOImpl Layer"
				+ "UserDAOImpl deleteUser Method Start");
		String statusOfRemoveUser = null;
		Optional<User> optionalUser = userRepository.findById(userId);
		LOGGER.info(
				"UsersController deleteUser Method Requset Goging Into UserRepository Class Calling findById Return Optional User Object:"
						+ " Purpose Checking userId Present In DB Or Not");

		if (optionalUser.isPresent()) {
			userRepository.deleteById(userId);
			statusOfRemoveUser = "User Record Is Removed";
			LOGGER.info("User Record Is Removed");

		} else {
			statusOfRemoveUser = "User Record Is Not Present Is DB";
			LOGGER.info("User Record Is Not Present Is DB");

		}

		LOGGER.info("UserDAOImpl deleteUser Method End");
		return statusOfRemoveUser;
	}

	@Override
	public List<Pet> getMyPets(long userId) {
		LOGGER.info("UsersController getMyPets Method Requset Comes Into UserDAOImpl Layer"
				+ "UserDAOImpl getMyPets Method Start");
		LOGGER.info("Pet Record fetech  In DB");
		LOGGER.info("UserDAOImpl getMyPets Method End");

		return petRepository.findByUserId(userId);
	}

	@Override
	public String loginApp(String userName, String password) {

		LOGGER.info("UsersController loginUserOne Method Requset Comes Into UserDAOImpl Layer"
				+ "UserDAOImpl loginApp Method Start");
		String loginStatus = null;

		User user = userRepository.findByNameAndPassword(userName, password);

		if (user != null) {
			loginStatus = "Login Successful";
			LOGGER.info("Login Successful");

		}

		LOGGER.info("UserDAOImpl loginApp Method End");

		return loginStatus;
	}

}

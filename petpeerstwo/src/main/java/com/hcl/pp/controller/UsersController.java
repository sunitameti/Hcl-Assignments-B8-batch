package com.hcl.pp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.pp.model.Pet;
import com.hcl.pp.model.ResponseMessage;
import com.hcl.pp.model.User;
import com.hcl.pp.service.UserService;

@RestController
public class UsersController {

	private static final Logger LOGGER = LogManager.getLogger(UsersController.class);

	@Autowired
	UserService userService;

	
	@PostMapping(value = "/user/add")
	public ResponseEntity<ResponseMessage> addUser(@Valid @RequestBody User user) {
		LOGGER.info(" Request sent by client" + " " + "URL" + "/user/add" + "addUserMethod Start");
		String addStatus = userService.addUser(user);
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setMessage(addStatus);
		LOGGER.info("UserServiceInterface addUser Method Return Result Is" + addStatus);
		ResponseEntity<ResponseMessage> responseEntity = new ResponseEntity<ResponseMessage>(responseMessage,
				HttpStatus.CREATED);
		LOGGER.info("End of UsersController addUser Method");
		return responseEntity;

	}

	
	@GetMapping(value = "/user/login/{userName}/{userPassword}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Object>> loginUser(@PathVariable String userName, @PathVariable String userPassword) {
		LOGGER.info(" Request sent by client" + " " + "URL" + "/user/login/" + userName + "/" + userPassword
				+ "loginUser Start");
		List<Pet> pets = null;
		List<Object> errorMessageObject = null;
		pets = userService.authenticateUser(userName, userPassword);
		ResponseEntity<List<Object>> responseEntity = null;
		LOGGER.info("UserServiceInterface loginUser Method Return Result");
		if (pets != null) {
			LOGGER.info("UserServiceInterface loginUser Method Return Result List<Pet> Not Null Its Contains Data");
			List<Object> petObjects = new ArrayList<Object>();
			petObjects.addAll(pets);
			responseEntity = new ResponseEntity<List<Object>>(petObjects, HttpStatus.OK);
			return responseEntity;
		} else {
			errorMessageObject = new ArrayList<Object>();
			errorMessageObject.add("Login is Failed please Check your user Name And Password");
			responseEntity = new ResponseEntity<List<Object>>(errorMessageObject, HttpStatus.BAD_REQUEST);
			LOGGER.info("Login Failed Check Your User Name And Password");

		}

		LOGGER.info("End of UsersController loginUser Method ");

		return responseEntity;

	}

	
	@GetMapping(value = "/user/loginapp/{userName}/{userPassword}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseMessage> loginApp(@PathVariable String userName, @PathVariable String userPassword) {
		ResponseMessage responseMessage = new ResponseMessage();
		String loginStatus = null;
		ResponseEntity<ResponseMessage> responseEntity = null;
		loginStatus = userService.loginApp(userName, userPassword);
		if (loginStatus != null) {
			responseMessage.setMessage(loginStatus);
			responseEntity = new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.OK);
		} else {
			loginStatus = "Login Failed Check Your User Name And Password";
			responseMessage.setMessage(loginStatus);
			responseEntity = new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.OK);
		}

		return responseEntity;

	}

	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Object>> listUsers() {
		LOGGER.info("Client Send The Requset" + " " + "URL" + "/users" + "listUsers Method Start");
		List<User> users = null;
		List<Object> errorMessageObject = null;
		users = userService.listUsers();
		ResponseEntity<List<Object>> responseEntity = null;
		LOGGER.info("UserServiceInterface listUsers Method Return Result");
		if (users != null) {
			LOGGER.info("UserServiceInterface listUsers Method Return Result List<User>  List Contains Data");
			List<Object> userObject = new ArrayList<Object>();
			userObject.addAll(users);
			responseEntity = new ResponseEntity<List<Object>>(userObject, HttpStatus.FOUND);
			return responseEntity;
		} else {
			errorMessageObject = new ArrayList<Object>();
			errorMessageObject.add("Cureently User Table Is Empty");
			responseEntity = new ResponseEntity<List<Object>>(errorMessageObject, HttpStatus.BAD_REQUEST);
			LOGGER.info("Login Failed Check Your User Name And Password");

		}

		LOGGER.info("UsersController listUsers Method End");

		return responseEntity;
	}

	@DeleteMapping(value = "/delete/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseMessage> deleteUser(@PathVariable long userId) {
		LOGGER.info("Client Send The Requset" + " " + "URL" + "/delete/" + userId + "deleteUser Method Start");
		String deleteStatus = userService.deleteUser(userId);
		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setMessage(deleteStatus);
		LOGGER.info("UserServiceInterface deleteUser Method Return Result");
		ResponseEntity<ResponseMessage> responseEntity = new ResponseEntity<ResponseMessage>(responseMessage,
				HttpStatus.GONE);
		LOGGER.info("UsersController deleteUser Method End");
		return responseEntity;

	}

	@GetMapping(value = "/pets/myPets/{userId}")
	public List<Object> myPets(@PathVariable long userId) {
		LOGGER.info("Client Send The Requset" + " " + "URL" + "/pets/myPets/" + userId + "myPets Method Start");
		List<Pet> pets = null;
		List<Object> errorMessageObject = null;
		pets = userService.getMyPets(userId);
		LOGGER.info("UserServiceInterface myPets Method Return Result");
		if (pets != null && pets.size() > 0) {
			LOGGER.info("UserServiceInterface myPets Method Return Result List<Pets> List Contains Data");
			List<Object> petsObjects = new ArrayList<Object>();
			petsObjects.addAll(pets);
			return petsObjects;

		} else {
			errorMessageObject = new ArrayList<Object>();
			errorMessageObject.add("No pets are avalible in database for this user id");
			LOGGER.info("No pets are avalible in database for this user id");

		}
		LOGGER.info("UsersController myPets Method End");
		return errorMessageObject;

	}

	@GetMapping(value = "/pets/buyPet/{userId}/{petId}")
	public ResponseEntity<ResponseMessage> buyPet(@PathVariable long userId, @PathVariable long petId) {
		LOGGER.info("Client Send The Requset" + " " + "URL" + "/pets/buyPet/" + userId + "/ " + petId
				+ "buyPet Method Start");
		ResponseEntity<ResponseMessage> responseEntity = null;
		int numberOfRowAffected = userService.buyPet(userId, petId);
		ResponseMessage responseMessage = new ResponseMessage();
		LOGGER.info("UserServiceInterface buyPet Method Return Result");
		if (numberOfRowAffected > 0) {
			LOGGER.info("UserServiceInterface buyPet Method Return Result integer Data");
			responseMessage.setMessage("Add the New pet to the user");

			return responseEntity = new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.FOUND);

		} else {
			responseMessage.setMessage("Pet is Already Sold Out");
			responseEntity = new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.BAD_REQUEST);
			LOGGER.info("Sorry... the pet is sold out");
		}

		LOGGER.info("UsersController buyPet Method End");
		return responseEntity;

	}

	@PutMapping(value = "/upadteUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateUser(@Valid @RequestBody User user) {

		LOGGER.info(" Client Send The Requset" + " " + "URL" + "/upadteUser" + "updateUser Start");
		User userOne = null;
		ResponseEntity<Object> responseEntity = null;
		userOne = userService.updateUser(user);
		LOGGER.info("PetServiceInterface updatePetDetails Method Return Result");
		if (userOne != null) {
			responseEntity = new ResponseEntity<Object>(userOne, HttpStatus.ACCEPTED);

		} else {
			responseEntity = new ResponseEntity<Object>("Upadate Failed Check User Object Details",
					HttpStatus.BAD_REQUEST);
			LOGGER.info("Upadate Failed Check User Object Details");

		}
		LOGGER.info("UserController updateUser Method End");
		return responseEntity;

	}

}

package com.hcl.pp.dao;

import java.util.List;

import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;

public interface UserDAO {

	public abstract String addUser(User user);

	public abstract User updateUser(User user);

	public abstract List<User> listUsers();

	public abstract User getUserById(long userId);

	public abstract String removeUser(long userId);

	public abstract List<Pet> authenticateUser(String userName, String password);

	public abstract User findByUserName(String username);

	public abstract String loginApp(String userName, String password);

	public abstract int buyPet(long userId, long petId);

	public abstract String deleteUser(long userId);

	public abstract List<Pet> getMyPets(long userId);

}

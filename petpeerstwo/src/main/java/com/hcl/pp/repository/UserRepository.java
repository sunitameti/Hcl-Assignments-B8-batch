package com.hcl.pp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.pp.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	@Query("select u from User u where u.userName = :userName")
	public abstract User findByName(@Param("userName") String userName);

	@Query("select u from User u where u.userName = :userName and u.userPassword = :userPassword")
	public abstract User findByNameAndPassword(@Param("userName") String userName,
			@Param("userPassword") String userPassword);

	public abstract List<User> findAll();

}

package com.hcl.pp.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "PET_USER")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;

	@Column(name = "USER_NAME")
	@NonNull
	@NotEmpty(message = "Please Enter UserName")
	private String userName;

	@Column(name = "USER_PASSWORD")
	@NonNull
	@NotEmpty(message = "Please Enter UserPassword")
	private String userPassword;

	@Transient
	@NonNull
	@NotEmpty(message = "Please Enter ConfirmPassword")
	private String confirmPassword;

	@OneToMany(mappedBy = "owner", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH }, fetch = FetchType.LAZY) //cascade==just it will just delete the user records not the user details persist=save,merger=update,detach=delete
	@JsonManagedReference
	private Set<Pet> pets;

	public User() {
		super();

	}

	public User(String userName, String userPassword, Set<Pet> pets) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.pets = pets;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}

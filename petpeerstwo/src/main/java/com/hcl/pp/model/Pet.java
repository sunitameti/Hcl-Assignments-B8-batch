package com.hcl.pp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "PETS")
public class Pet implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;

	@Column(name = "PET_NAME")
	@NonNull
	@NotEmpty(message = "Please Enter PetName")
	private String name;

	@Column(name = "PET_AGE")
	@Min(1)
	private int age;

	@Column(name = "PET_PLACE")
	@NonNull
	@NotEmpty(message = "Please Enter PetPlace")
	private String place;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PET_OWNERID")
	@JsonBackReference
	private User owner;

	public Pet() {
		super();

	}

	public Pet(String name, int age, String place) {
		super();
		this.name = name;
		this.age = age;
		this.place = place;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

}

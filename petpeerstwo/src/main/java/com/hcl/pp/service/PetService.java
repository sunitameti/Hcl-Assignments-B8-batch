package com.hcl.pp.service;

import java.util.List;

import com.hcl.pp.model.Pet;

public interface PetService {

	public abstract String savePet(Pet pet);

	public abstract List<Pet> getAllPets();

	public abstract Pet getPetById(long petId);

	public abstract Pet updatePet(Pet pet);

	public abstract String deletePetById(long petId);

}

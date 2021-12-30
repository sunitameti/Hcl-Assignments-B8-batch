package com.hcl.pp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.pp.dao.PetDAO;
import com.hcl.pp.model.Pet;

@Service
public class PetServiceImpl implements PetService {

	@Autowired
	private PetDAO petDAO;

	@Override
	public String savePet(Pet pet) {

		String statusSavePet = null;
		if (pet != null && pet.getName() != null && pet.getPlace() != null && pet.getAge() > 0) {

			statusSavePet = petDAO.savePet(pet);

		}

		return statusSavePet;
	}

	@Override
	public List<Pet> getAllPets() {

		return petDAO.getAllPets();
	}

	@Override
	public Pet getPetById(long petId) {
		Pet pet = null;
		if (petId > 0) {
			pet = petDAO.getPetById(petId);
		}
		return pet;
	}

	@Override
	public Pet updatePet(Pet pet) {
		Pet petTwo = null;
		if (pet != null && pet.getId() > 0) {

			petTwo = petDAO.updatePet(pet);

		}
		return petTwo;
	}

	@Override
	public String deletePetById(long petId) {
		String statusOfRemovePet = null;
		if (petId > 0) {
			statusOfRemovePet = petDAO.deletePetById(petId);
		}
		return statusOfRemovePet;
	}

}

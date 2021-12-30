package com.hcl.pp.dao;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.pp.model.Pet;
import com.hcl.pp.repository.PetRepository;

@Repository
public class PetDAOImpl implements PetDAO {

	private static final Logger LOGGER = LogManager.getLogger(PetDAOImpl.class);

	@Autowired
	private PetRepository petRepository;

	@Override
	public String savePet(Pet pet) {
		String statusSavePet = null;
		Pet petTwo = petRepository.save(pet);
		if (petTwo != null) {

			statusSavePet = "Your are successfully add the pet record";

		} else {

			statusSavePet = "Your are not successfully add the pet record try later ";

		}

		return statusSavePet;
	}

	@Override
	public List<Pet> getAllPets() {

		return petRepository.findAllRecord();
	}

	@Override
	public Pet getPetById(long petId) {
		Pet pet = null;

		Optional<Pet> optionalPet = petRepository.findById(petId);

		if (optionalPet.isPresent()) {
			pet = optionalPet.get();
		}

		return pet;
	}

	@Override
	public Pet updatePet(Pet pet) {
		Pet petTwo = null;
		Optional<Pet> optionalPet = petRepository.findById(pet.getId());
		if (optionalPet.isPresent()) {
			petTwo = petRepository.save(pet);
		}

		return petTwo;
	}

	@Override
	public String deletePetById(long petId) {
		String statusOfRemovePet = null;
		Optional<Pet> optionalPet = petRepository.findById(petId);

		if (optionalPet.isPresent()) {
			petRepository.deleteById(petId);
			statusOfRemovePet = "Pet Record Is Removed";
		} else {
			statusOfRemovePet = "Pet Record Is Not Present Is DB";

		}
		return statusOfRemovePet;
	}

}

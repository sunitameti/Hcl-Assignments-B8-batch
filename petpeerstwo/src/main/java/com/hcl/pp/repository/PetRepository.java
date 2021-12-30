package com.hcl.pp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.pp.model.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {

	public abstract List<Pet> findAll();

	@Query(value = "SELECT * FROM pets", nativeQuery = true)
	public abstract List<Pet> findAllRecord();

	@Query(value = "SELECT * FROM pets p WHERE p.PET_OWNERID= :userId", nativeQuery = true)
	public abstract List<Pet> findByUserId(@Param("userId") long userId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE pets SET PET_OWNERID= :userId WHERE ID = :petId AND PET_OWNERID IS NULL", nativeQuery = true)
	public abstract int updatePetByUserId(@Param("userId") long userId, @Param("petId") long petId);

}

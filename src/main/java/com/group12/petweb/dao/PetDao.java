package com.group12.petweb.dao;

import com.group12.petweb.model.Pet;
import jakarta.persistence.PersistenceException;

import java.util.Optional;
import java.util.UUID;

public interface PetDao {
	Optional<Pet> findById(UUID id);

	void create(Pet model) throws PersistenceException;
}

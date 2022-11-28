package com.group12.petweb.dao;

import com.group12.petweb.model.Pet;
import jakarta.persistence.PersistenceException;

import java.util.Optional;
import java.util.UUID;

public interface PetDao {
	Optional<Pet> findById(UUID id);

	void create(Pet pet) throws PersistenceException;
	Pet[] findSomeOffset(int offset, int count) throws PersistenceException;
	void update(Pet pet) throws PersistenceException;
}

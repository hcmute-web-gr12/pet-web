package com.group12.petweb.dao;

import com.group12.petweb.model.Pet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceException;

import java.util.Optional;
import java.util.UUID;

public class PetDaoImpl implements PetDao {
	private final EntityManagerFactory factory;

	public PetDaoImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}

	@Override()
	public Optional<Pet> findById(UUID id) {
		try (final EntityManager manager = factory.createEntityManager()) {
			manager.getTransaction().begin();
			final Optional<Pet> pet = manager
					.createQuery("SELECT p FROM Pet p WHERE id = :id", Pet.class)
					.setParameter("id", id)
					.setMaxResults(1)
					.getResultStream()
					.findFirst();
			manager.getTransaction().commit();
			return pet;
		}
	}

	@Override
	public void create(Pet pet) throws PersistenceException {
		try (final EntityManager manager = factory.createEntityManager()) {
			manager.getTransaction().begin();
			manager.persist(pet);
			manager.flush();
			manager.getTransaction().commit();
		}
	}

	@Override
	public void update(Pet pet) throws PersistenceException {
		try (final EntityManager manager = factory.createEntityManager()) {
			manager.getTransaction().begin();
			manager.merge(pet);
			manager.getTransaction().commit();
		}
	}
}

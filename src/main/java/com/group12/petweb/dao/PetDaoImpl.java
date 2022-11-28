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
			final Optional<Pet> user = manager
					.createQuery("SELECT p FROM Pet p WHERE id = :id", Pet.class)
					.setParameter("id", id)
					.setMaxResults(1)
					.getResultStream()
					.findFirst();
			manager.getTransaction().commit();
			return user;
		}
	}

	@Override
	public void create(Pet user) throws PersistenceException {
		try (final EntityManager manager = factory.createEntityManager()) {
			manager.getTransaction().begin();
			manager.persist(user);
			manager.flush();
			manager.getTransaction().commit();
		}
	}
}

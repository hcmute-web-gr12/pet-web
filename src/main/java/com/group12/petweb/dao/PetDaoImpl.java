package com.group12.petweb.dao;

import com.group12.petweb.model.Pet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceException;

import java.util.Optional;
import java.util.UUID;

public class PetDaoImpl implements PetDao {
	private final EntityManagerFactory factory;

	public PetDaoImpl(final EntityManagerFactory factory) {
		this.factory = factory;
	}

	@Override()
	public Optional<Pet> findById(final UUID id) {
		try (final EntityManager manager = factory.createEntityManager()) {
			manager.getTransaction().begin();
			final var optional = Optional.of(manager.find(Pet.class, id));
			manager.getTransaction().commit();
			return optional;
		}
	}

	@Override
	public void create(final Pet pet) throws PersistenceException {
		try (final EntityManager manager = factory.createEntityManager()) {
			manager.getTransaction().begin();
			manager.persist(pet);
			manager.flush();
			manager.getTransaction().commit();
		}
	}

	@Override
	public void update(final Pet pet) throws PersistenceException {
		try (final EntityManager manager = factory.createEntityManager()) {
			manager.getTransaction().begin();
			manager.merge(pet);
			manager.getTransaction().commit();
		}
	}

	@Override
	public Pet[] findSomeOffset(int offset, int count) throws PersistenceException {
		try (final EntityManager manager = factory.createEntityManager()) {
			manager.getTransaction().begin();
			@SuppressWarnings("unchecked")
			final var pets = (Pet[]) manager
					.createNativeQuery("SELECT * FROM PET ORDER BY CREATED_DATE DESC OFFSET :offset ROWS FETCH FIRST :count ROWS ONLY", Pet.class)
					.setParameter("offset", offset)
					.setParameter("count", count)
					.getResultStream()
					.toArray(Pet[]::new);
			manager.getTransaction().commit();
			return pets;
		}
	}

	@Override
	public long countAll() throws PersistenceException {
		try (final EntityManager manager = factory.createEntityManager()) {
			manager.getTransaction().begin();
			final var count = (long)manager
					.createNativeQuery("SELECT COUNT(*) FROM PET")
					.getSingleResult();
			manager.getTransaction().commit();
			return count;
		}
	}
}

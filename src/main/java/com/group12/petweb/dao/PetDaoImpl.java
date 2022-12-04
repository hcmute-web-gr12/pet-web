package com.group12.petweb.dao;

import com.group12.petweb.model.Pet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

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
					.createNativeQuery("SELECT * FROM PET ORDER BY CREATED_DATE DESC", Pet.class)
					.setFirstResult(offset)
					.setMaxResults(count)
					.getResultStream()
					.toArray(Pet[]::new);
			manager.getTransaction().commit();
			return pets;
		}
	}

	@Override
	public Pet[] findCategoryOffset(byte category, int offset, int count) throws PersistenceException {
		try (final EntityManager manager = factory.createEntityManager()) {
			manager.getTransaction().begin();
			@SuppressWarnings("unchecked")
			final var pets = (Pet[]) manager
					.createNativeQuery("SELECT * FROM PET WHERE CATEGORY = :category ORDER BY CREATED_DATE DESC", Pet.class)
					.setParameter("category", category)
					.setFirstResult(offset)
					.setMaxResults(count)
					.getResultStream()
					.toArray(Pet[]::new);
			manager.getTransaction().commit();
			return pets;
		}
	}

	@Override
	public Pet[] findCategoriesOffset(byte[] categories, int offset, int count) throws PersistenceException {
		try (final EntityManager manager = factory.createEntityManager()) {
			manager.getTransaction().begin();
			@SuppressWarnings("unchecked")
			final var pets = (Pet[]) manager
					.createNativeQuery("SELECT * FROM PET WHERE CATEGORY IN (:categories) ORDER BY CREATED_DATE DESC", Pet.class)
					.setParameter("categories", StringUtils.join(ArrayUtils.toObject(categories), ","))
					.setFirstResult(offset)
					.setMaxResults(count)
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

	@Override
	public int deleteById(UUID id) throws PersistenceException {
		try (final EntityManager manager = factory.createEntityManager()) {
			manager.getTransaction().begin();
			final var count = manager
					.createQuery("DELETE FROM Pet WHERE id = :id")
					.setMaxResults(1)
					.executeUpdate();
			manager.getTransaction().commit();
			return count;
		}
	}

	@Override
	public int deleteById(List<UUID> ids) throws PersistenceException {
		try (final EntityManager manager = factory.createEntityManager()) {
			manager.getTransaction().begin();
			final var count = manager
					.createQuery("DELETE FROM Pet WHERE id IN :ids")
					.setParameter("ids", ids)
					.executeUpdate();
			manager.getTransaction().commit();
			return count;
		}
	}
}

package com.group12.petweb.dao;

import com.group12.petweb.model.UserCredentials;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceException;

import java.util.Optional;
import java.util.UUID;

public class UserCredentialsDaoImpl implements UserCredentialsDao {
	private final EntityManagerFactory factory;

	public UserCredentialsDaoImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}

	@Override()
	public Optional<UserCredentials> findById(UUID id) {
		try (final EntityManager manager = factory.createEntityManager()) {
			manager.getTransaction().begin();
			final var credentials = manager.find(UserCredentials.class, id);
			manager.getTransaction().commit();
			return credentials == null
					? Optional.empty()
					: Optional.of(credentials);
		}
	}

	@Override()
	public Optional<UserCredentials> findByEmail(String email) {
		try (final EntityManager manager = factory.createEntityManager()) {
			manager.getTransaction().begin();
			final var user = manager
					.createQuery("SELECT u FROM UserCredentials u WHERE email = :email", UserCredentials.class)
					.setParameter("email", email)
					.setMaxResults(1)
					.getResultStream()
					.findFirst();
			manager.getTransaction().commit();
			return user;
		}
	}

	@Override
	public void create(UserCredentials user) throws PersistenceException {
		try (final EntityManager manager = factory.createEntityManager()) {
			manager.getTransaction().begin();
			manager.persist(user);
			manager.flush();
			manager.getTransaction().commit();
		}
	}

	@Override()
	public UserCredentials getReference(UUID id) {
		try (final EntityManager manager = factory.createEntityManager()) {
			return manager.getReference(UserCredentials.class, id);
		}
	}
}

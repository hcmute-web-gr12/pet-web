package com.group12.petweb.dao;

import com.group12.petweb.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceException;

import java.util.Optional;

public class UserDaoImpl implements UserDao {
	private final EntityManagerFactory factory;

	public UserDaoImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}

	@Override()
	public Optional<User> findByEmail(String email) {
		try (final EntityManager manager = factory.createEntityManager()) {
			manager.getTransaction().begin();
			final Optional<User> user = manager
					.createQuery("SELECT u FROM User u WHERE email = :email", User.class)
					.setParameter("email", email)
					.setMaxResults(1)
					.getResultStream()
					.findFirst();
			manager.getTransaction().commit();
			return user;
		}
	}

	@Override
	public void create(User user) throws PersistenceException {
		try (final EntityManager manager = factory.createEntityManager()) {
			manager.getTransaction().begin();
			manager.persist(user);
			manager.flush();
			manager.getTransaction().commit();
		}
	}
}

package com.group12.petweb.dao;

import com.group12.petweb.model.Cart;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceException;

import java.util.Optional;
import java.util.UUID;

public class CartDaoImpl implements CartDao {
	private final EntityManagerFactory factory;

	public CartDaoImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}

	public Optional<Cart> findById(UUID id) {
		try (final var manager = factory.createEntityManager()) {
			manager.getTransaction().begin();
			final var cart = manager.find(Cart.class, id);
			manager.getTransaction().commit();
			return cart == null
					? Optional.empty()
					: Optional.of(cart);
		}
	}

	@Override
	public void create(Cart cart) throws PersistenceException {
		try (final var manager = factory.createEntityManager()) {
			manager.getTransaction().begin();
			manager.persist(cart);
			manager.flush();
			manager.getTransaction().commit();
		}
	}

	@Override
	public void update(Cart cart) throws PersistenceException {
		try (final var manager = factory.createEntityManager()) {
			manager.getTransaction().begin();
			manager.merge(cart);
			manager.getTransaction().commit();
		}
	}

	@Override
	public Optional<Cart> findByUserId(UUID id) {
		try (final var manager = factory.createEntityManager()) {
			manager.getTransaction().begin();
			final var optional = manager
				.createQuery("SELECT c FROM Cart c WHERE c.user.id = :id", Cart.class)
				.setParameter("id", id)
				.setMaxResults(1)
				.getResultStream()
				.findFirst();
			manager.getTransaction().commit();
			return optional;
		}
	}
}

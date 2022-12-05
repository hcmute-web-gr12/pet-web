package com.group12.petweb.dao;

import com.group12.petweb.model.CartItem;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceException;

import java.util.Optional;
import java.util.UUID;

public class CartItemDaoImpl implements CartItemDao {
	private final EntityManagerFactory factory;

	public CartItemDaoImpl(EntityManagerFactory factory) {
		this.factory = factory;
	}
	public Optional<CartItem> findById(UUID id) {
		try (final var manager = factory.createEntityManager()) {
			final var cartItem = manager.find(CartItem.class, id);
			manager.flush();
			manager.getTransaction().commit();
			return cartItem == null
					? Optional.empty()
					: Optional.of(cartItem);
		}
	}

	public void create(CartItem cartItem) throws PersistenceException {
		try (final var manager = factory.createEntityManager()) {
			manager.getTransaction().begin();
			manager.persist(cartItem);
			manager.flush();
			manager.getTransaction().commit();
		}
	}
	@Override
	public void update(CartItem cartItem) throws PersistenceException {
		try (final var manager = factory.createEntityManager()) {
			manager.getTransaction().begin();
			manager.merge(cartItem);
			manager.getTransaction().commit();
		}
	}
}

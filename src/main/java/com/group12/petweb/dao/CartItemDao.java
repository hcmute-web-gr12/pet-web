package com.group12.petweb.dao;

import com.group12.petweb.model.CartItem;
import jakarta.persistence.PersistenceException;

import java.util.Optional;
import java.util.UUID;

public interface CartItemDao {
	Optional<CartItem> findById(UUID id);
	void create(CartItem cartItem) throws PersistenceException;
	void update(CartItem cartItem) throws PersistenceException;
}

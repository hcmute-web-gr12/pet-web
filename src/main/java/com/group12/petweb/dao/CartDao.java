package com.group12.petweb.dao;

import com.group12.petweb.model.Cart;
import jakarta.persistence.PersistenceException;

import java.util.Optional;
import java.util.UUID;

public interface CartDao {
	Optional<Cart> findById(UUID id);
	Optional<Cart> findByUserId(UUID id);
	void create(Cart cart) throws PersistenceException;
	void update(Cart cart) throws PersistenceException;
}

package com.group12.petweb.dao;

import com.group12.petweb.model.User;
import jakarta.persistence.PersistenceException;

import java.util.Optional;
import java.util.UUID;

public interface UserDao {
	Optional<User> findById(UUID id);
	Optional<User> findByEmail(String email);

	void create(User model) throws PersistenceException;
}

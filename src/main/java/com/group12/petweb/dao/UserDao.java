package com.group12.petweb.dao;

import com.group12.petweb.model.User;
import jakarta.persistence.PersistenceException;

import java.util.Optional;

public interface UserDao {
	Optional<User> findByEmail(String email);

	void create(User model) throws PersistenceException;
}

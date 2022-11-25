package com.group12.petweb.dao;

import com.group12.petweb.model.UserCredentials;
import jakarta.persistence.PersistenceException;

import java.util.Optional;
import java.util.UUID;

public interface UserCredentialsDao {
	Optional<UserCredentials> findById(UUID id);
	Optional<UserCredentials> findByEmail(String email);

	void create(UserCredentials model) throws PersistenceException;
}

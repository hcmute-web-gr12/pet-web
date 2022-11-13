package com.group12.petweb.dao;

import com.group12.petweb.model.User;

import java.util.Optional;

public interface UserDao {
    Optional<User> findByEmail(String email);
    boolean create(User model);
}
package com.group12.petweb.dao;

import com.group12.petweb.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Tuple;

import java.util.Optional;
import java.util.UUID;

public class UserDaoImpl implements UserDao {
    private final EntityManagerFactory factory;

    public UserDaoImpl(EntityManagerFactory factory) {
        this.factory = factory;
    }

    public Optional<User> findByEmail(String email) {
        EntityManager manager = factory.createEntityManager();
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

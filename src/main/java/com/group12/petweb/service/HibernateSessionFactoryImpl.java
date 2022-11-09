package com.group12.petweb.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateSessionFactoryImpl implements HibernateSessionFactory {
    private final SessionFactory factory;

    public HibernateSessionFactoryImpl() {
        Properties properties = new Properties();
        properties.setProperty("a", "b");
        factory = new Configuration()
            .addProperties(properties)
            .buildSessionFactory();
    }

    @Override
    public final Session openSession() {
        return factory.openSession();
    }
}

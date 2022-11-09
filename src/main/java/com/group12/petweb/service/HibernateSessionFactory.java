package com.group12.petweb.service;

import org.hibernate.Session;

public interface HibernateSessionFactory {
    Session openSession();
}

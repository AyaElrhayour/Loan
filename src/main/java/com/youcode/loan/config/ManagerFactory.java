package com.youcode.loan.config;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ManagerFactory {

    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";

    private static EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    public static void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        factory = entityManagerFactory;
    }

    public static void close() {
        if (factory != null) {
            factory.close();
        }
    }
}

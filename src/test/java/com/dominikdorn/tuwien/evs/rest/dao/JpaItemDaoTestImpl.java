package com.dominikdorn.tuwien.evs.rest.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Dominik Dorn
 * 0626165
 * dominik.dorn@tuwien.ac.at
 */
public class JpaItemDaoTestImpl extends AbstractItemDaoTest {

    private static EntityManagerFactory emf;

    private EntityManager em;

    @BeforeClass
    public static void createEntityManagerFactory() {
        emf = Persistence.createEntityManagerFactory("RestPersistenceUnit");
    }

    @AfterClass
    public static void closeEntityManagerFactory() {
        emf.close();
    }

    @Before
    public void beginTransaction() {
        em = emf.createEntityManager();
        JpaItemDao realDao = new JpaItemDao();
        realDao.setEm(em);
        dao = realDao;
        em.getTransaction().begin();
    }

    @After
    public void rollbackTransaction() {

        if (em.getTransaction().isActive())
            em.getTransaction().rollback();

        if (em.isOpen())
            em.close();
    }

    public JpaItemDaoTestImpl() {

    }

}

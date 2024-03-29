package com.example.Controller.MODEL;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Date;

public class PersistEmployee {

    public static void main(String args[]) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("projetit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Employe employee1 = new Employe();
        employee1.setId(101L);
        employee1.setName("Gaurav");
        employee1.setEmail("gaurav@example.com");
        employee1.setSkills(List.of("Java", "SQL", "Spring"));

        Employe employee2 = new Employe();
        employee2.setId(102L);
        employee2.setName("Yassine");
        employee2.setEmail("yassine@example.com");
        employee2.setSkills(List.of("HTML", "CSS", "JavaScript"));

        em.persist(employee1);
        em.persist(employee2);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}

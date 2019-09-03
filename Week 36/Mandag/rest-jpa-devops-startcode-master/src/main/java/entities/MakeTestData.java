package entities;

import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class MakeTestData {

    private static EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.DROP_AND_CREATE);
    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        Animal ani0 = new Animal("Crow","Corvus","Corvidae","https://en.wikipedia.org/wiki/Crow");
        Animal ani1 = new Animal("Polar Bear", "Ursus", "Ursidae", "https://en.wikipedia.org/wiki/Polar_bear");
        Animal ani2 = new Animal("Lion", "Panthera", "Felidae", "https://en.wikipedia.org/wiki/Lion");
        Animal ani3 = new Animal("Great White Shark", "Carcharodon", "Lamnidae", "https://en.wikipedia.org/wiki/Great_white_shark");

        try {
            em.getTransaction().begin();
            em.persist(ani0);
            em.persist(ani1);
            em.persist(ani2);
            em.persist(ani3);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}

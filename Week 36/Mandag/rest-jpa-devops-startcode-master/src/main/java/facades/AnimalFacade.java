package facades;

import dto.AnimalDTO;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class AnimalFacade {

    private static AnimalFacade instance;
    private static EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.DROP_AND_CREATE);
    
    //Private Constructor to ensure Singleton
    private AnimalFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static AnimalFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new AnimalFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public long getAnimalCount(){
        EntityManager em = getEntityManager();
        try{
            long animalCount = (long)em.createQuery("SELECT COUNT(r) FROM Animal r").getSingleResult();
            return animalCount;
        }finally{  
            em.close();
        }
    }

    /*
    public AnimalDTO getAnimalById(Long id){
        EntityManager em = getEntityManager();

    }
    */
}

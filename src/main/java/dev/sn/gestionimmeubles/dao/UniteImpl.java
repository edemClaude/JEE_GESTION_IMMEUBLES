package dev.sn.gestionimmeubles.dao;

import dev.sn.gestionimmeubles.entities.UniteLocation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.Collections;

import java.util.List;
import java.util.logging.Logger;

public class UniteImpl implements IUniteLocation{

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    private final EntityManager em = emf.createEntityManager();
    private final EntityTransaction et = em.getTransaction();
    Logger logger = Logger.getLogger(UniteImpl.class.getName());
    @Override
    public boolean addUnite(UniteLocation unite) {
        try{
            et.begin();
            em.persist(unite);
            et.commit();
            return true;
        }catch(Exception e){
            logger.info("Add Error :"+e.getMessage());
            et.rollback();
            return false;
        }
    }

    @Override
    public boolean updateUnite(int id, UniteLocation uniteLocation) {
        try {
            et.begin();
            uniteLocation.setId(id);
            em.merge(uniteLocation);
            et.commit();
            return true;
        } catch (Exception e) {
            logger.info("Update Error :"+e.getMessage());
            et.rollback();
            return false;
        }
    }

    @Override
    public boolean deleteUnite(int id) {
        try {
            et.begin();
            UniteLocation unite = em.find(UniteLocation.class, id);
            em.remove(unite);
            et.commit();
            return true;
        } catch (Exception e) {
            logger.info("Delete Error :"+e.getMessage());
            et.rollback();
            return false;
        }
    }

    @Override
    public List<UniteLocation> getUniteLocations(String key) {
        try {
            return em.createQuery(
                    "SELECT u FROM UniteLocation u WHERE u.uniteNumber LIKE :key", UniteLocation.class)
                    .setParameter("key", "%" + key + "%").getResultList();
        } catch (Exception e) {
            logger.info("Get Error :"+e.getMessage());
            return Collections.emptyList();
        }
    }


    @Override
    public List<UniteLocation> getAllUnites() {
        try {
            return em.createQuery("SELECT u FROM UniteLocation u", UniteLocation.class).getResultList();
        } catch (Exception e) {
            logger.info("Error :"+e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public UniteLocation getOneUnite(int id) {
        try {
            return em.find(UniteLocation.class, id);
        } catch (Exception e) {
            logger.info("Get one Error :"+e.getMessage());
            return null;
        }
    }
}

package dev.sn.gestionimmeubles.dao;

import dev.sn.gestionimmeubles.entities.ContratLocation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.Collections;

import java.util.List;
import java.util.logging.Logger;

public class ContratImpl implements IContratLocation{
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    private final EntityManager em = emf.createEntityManager();
    private final EntityTransaction et = em.getTransaction();
    Logger logger = Logger.getLogger(ContratImpl.class.getName());
    @Override
    public boolean addContrat(ContratLocation contrat) {
        try {
            et.begin();
            em.persist(contrat);
            et.commit();
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteContrat(int id) {
        try {
            et.begin();
            ContratLocation contrat = em.find(ContratLocation.class, id);
            em.remove(contrat);
            et.commit();
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateContrat(int id, ContratLocation contrat) {
        try {
            et.begin();
            contrat.setId((long) id);
            em.merge(contrat);
            et.commit();
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
    }

    @Override
    public List<ContratLocation> getAllContrat() {
        try{
            return em.createQuery("select c from ContratLocation c", ContratLocation.class).getResultList();
        }catch (Exception e){
            logger.info(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public List<ContratLocation> getContratByLodger(int id) {
        try{
            return em.createQuery("select c from ContratLocation c where c.lodger.id = :id", ContratLocation.class).setParameter("id", id).getResultList();
        }catch (Exception e){
            logger.info(e.getMessage());
            return Collections.emptyList();
        }
    }
}

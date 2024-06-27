package dev.sn.gestionimmeubles.dao;

import dev.sn.gestionimmeubles.entities.Paiement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.Collections;

import java.util.List;
import java.util.logging.Logger;

public class PaiementImpl implements IPaiement{

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    private final EntityManager em = emf.createEntityManager();
    private final EntityTransaction et = em.getTransaction();
    Logger logger = Logger.getLogger(PaiementImpl.class.getName());
    @Override
    public boolean addPaiement(Paiement paiement) {
        try {
            et.begin();
            em.persist(paiement);
            et.commit();
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            et.rollback();
            return false;
        }
    }

    @Override
    public boolean deletePaiement(int id) {
        try {
            et.begin();
            Paiement p = em.find(Paiement.class, id);
            em.remove(p);
            et.commit();
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            et.rollback();
            return false;
        }
    }

    @Override
    public boolean updatePaiement(int id, Paiement p) {
        try {
            et.begin();
            Paiement paiement = em.find(Paiement.class, id);
            paiement.setMontant(p.getMontant());
            paiement.setDate(p.getDate());
            paiement.setStatut(p.isStatut());
            et.commit();
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            et.rollback();
            return false;
        }
    }

    @Override
    public List<Paiement> getPaiements(String key) {
        try{
            return em.createQuery("SELECT p FROM Paiement p WHERE p.contrat.id = :key", Paiement.class)
                    .setParameter("key", key).getResultList();
        }catch(Exception e){
            logger.info(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public List<Paiement> getPaiements() {
        try{
            return em.createQuery("SELECT p FROM Paiement p", Paiement.class)
                    .getResultList();
        }catch(Exception e){
            logger.info(e.getMessage());
            return Collections.emptyList();
        }
    }
}

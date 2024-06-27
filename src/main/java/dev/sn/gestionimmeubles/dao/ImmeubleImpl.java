package dev.sn.gestionimmeubles.dao;

import dev.sn.gestionimmeubles.entities.Immeuble;
import dev.sn.gestionimmeubles.entities.Owner;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class ImmeubleImpl implements IImmeuble {

    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    private final EntityManager manager = factory.createEntityManager();
    private final EntityTransaction transaction = manager.getTransaction();

    Logger logger = Logger.getLogger(ImmeubleImpl.class.getName());
    @Override
    public boolean addImmeuble(Immeuble immeuble) {
        try{
            transaction.begin();
            manager.persist(immeuble);
            transaction.commit();
            return true;
        }catch(Exception e){
            logger.info("Error while adding immeuble : " + e.getMessage());
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean deleteImmeuble(int id) {
        try{
            transaction.begin();
            Immeuble immeuble = manager.find(Immeuble.class, id);
            manager.remove(immeuble);
            transaction.commit();
            return true;
        }catch(Exception e){
            logger.info("Error while deleting immeuble : " + e.getMessage());
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean updateImmeuble(int id, Immeuble immeuble) {
        try{
            transaction.begin();
            immeuble.setId(id);
            manager.merge(immeuble);
            transaction.commit();
            return true;
        } catch(Exception e){
            logger.info("Error while updating immeuble : " + e.getMessage());
            transaction.rollback();
            return false;
        }
    }

    @Override
    public List<Immeuble> getAllImmeubleByMC(String key) {
        try {
            List<Immeuble> immeubles = new ArrayList<>();
            TypedQuery<Immeuble> query = manager.createNamedQuery("getAll", Immeuble.class);

            for (Immeuble i: query.getResultList()) {
                i.setOwner(manager.find(Owner.class, i.getId()));
                immeubles.add(i);
            }
            return immeubles;
        } catch (Exception e) {
            logger.info("Error while getting all immeubles : " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public Immeuble getImmeubleById(int id) {
        try {
            return manager.find(Immeuble.class, id);
        } catch (Exception e) {
            logger.info("Error while getting immeuble by id : " + e.getMessage());
            return null;
        }
    }

    @Override
    public Immeuble getImmeubleByName(String name) {
        try {
            return manager.find(Immeuble.class, name);
        } catch (Exception e) {
            logger.info("Error while getting immeuble by name : " + e.getMessage());
            return null;
        }
    }

}

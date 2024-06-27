package dev.sn.gestionimmeubles.dao;

import dev.sn.gestionimmeubles.entities.Lodger;
import dev.sn.gestionimmeubles.entities.Owner;
import dev.sn.gestionimmeubles.entities.Person;
import dev.sn.gestionimmeubles.entities.User;
import jakarta.persistence.*;

public class RegistrationImpl implements IRegistration {

    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    private final EntityManager manager = factory.createEntityManager();
    private final EntityTransaction transaction = manager.getTransaction();
    @Override
    public boolean login(String username, String password) {
        try{
            transaction.begin();
            TypedQuery<Person> query = manager.createQuery(
                    "SELECT p FROM Person p WHERE p.username = :username AND p.password = :password", Person.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            Person person = query.getSingleResult();
            transaction.commit();
            return person != null;
        }catch (NoResultException e){
            transaction.rollback();
            return false;
        }

    }

    @Override
    public boolean register(User user) {
        try{
            transaction.begin();
            manager.persist(user);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean register(Owner owner) {
        try{
            transaction.begin();
            manager.persist(owner);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean register(Lodger lodger) {
        try{
            transaction.begin();
            manager.persist(lodger);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean register(Person person) {
        try{
            transaction.begin();
            manager.persist(person);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }
    }
}

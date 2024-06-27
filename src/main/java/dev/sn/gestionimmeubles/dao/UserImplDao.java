package dev.sn.gestionimmeubles.dao;

import dev.sn.gestionimmeubles.entities.Lodger;
import dev.sn.gestionimmeubles.entities.Owner;
import dev.sn.gestionimmeubles.entities.Person;
import dev.sn.gestionimmeubles.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Collections;
import java.util.List;

public class UserImplDao implements IUserDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction et = em.getTransaction();


    @Override
    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public List<Person> getAllUsers() {
        try {
            return em.createQuery("select p from Person p", Person.class).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Person> getUsersByRole(String role) {
        try{
            return  em.createQuery("select p from Person p where p.role = :role", Person.class)
                    .setParameter("role", role).getResultList();
        } catch (Exception e){
            return Collections.emptyList();
        }
    }

    @Override
    public Person getUserByName(String name) {
        // get user from database by first_name or last_name
        try {

            List<Person> users = em.createQuery("select p from Person p where p.firstName = :name or p.lastName = :name", Person.class)
            .setParameter("name", name)
            .getResultList();
            if (!users.isEmpty()) {
                return users.get(0);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean insertUser(User user) {
        try{
            et.begin();
            em.persist(user);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            return false;
        }
    }

    @Override
    public boolean insertUser(Owner owner) {
        try{
            et.begin();
            em.persist(owner);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            return false;
        }
    }

    @Override
    public boolean insertUser(Lodger lodger) {
        try{
            et.begin();
            em.persist(lodger);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            return false;
        }
    }

    @Override
    public boolean updatePassword(int id, String password) {
        try {
            et.begin();
            em.createQuery("update User u set u.password = :password where u.id = :id")
                    .setParameter("password", password)
                    .setParameter("id", id)
                    .executeUpdate();
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            return false;
        }
    }

    @Override
    public boolean deleteUser(int id) {
        try {
            et.begin();
            em.remove(em.find(User.class, id));
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            return false;
        }

    }

    @Override
    public boolean updateUser(int id, Person user) {
        try {
            et.begin();
            em.merge(user);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            return false;
        }

    }

    @Override
    public String getRole(int id) {
        try {
            return em.createQuery("select p.role from Person p where p.id = :id", String.class)
                    .setParameter("id", id)
                    .getSingleResult();

        } catch (Exception e) {
            return null;
        }
    }
}

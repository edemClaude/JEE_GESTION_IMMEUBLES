package dev.sn.gestionimmeubles.dao;

import dev.sn.gestionimmeubles.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

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
    public List<User> getAllUsers() {
        try {
            return em.createQuery("select u from User u", User.class).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public User getUserByName(String name) {
        // get user from database by first_name or last_name
        try {

            List<User> users = em.createQuery("select u from User u where u.firstName = :name or u.lastName = :name", User.class)
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
    public boolean updateUser(int id, User user) {
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
}

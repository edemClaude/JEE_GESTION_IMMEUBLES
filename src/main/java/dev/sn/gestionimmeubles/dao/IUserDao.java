package dev.sn.gestionimmeubles.dao;

import dev.sn.gestionimmeubles.entities.User;

import java.util.List;

public interface IUserDao {

    User getUserById(int id);
    List<User> getAllUsers();

    User getUserByName(String name);

    boolean insertUser(User user);

    boolean updatePassword(int id, String password);

    boolean deleteUser(int id);

    boolean updateUser(int id, User user);

}

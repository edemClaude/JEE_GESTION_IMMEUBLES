package dev.sn.gestionimmeubles.dao;

import dev.sn.gestionimmeubles.entities.Lodger;
import dev.sn.gestionimmeubles.entities.Owner;
import dev.sn.gestionimmeubles.entities.Person;
import dev.sn.gestionimmeubles.entities.User;

import java.util.List;

public interface IUserDao {

    Person getUserById(int id);
    List<Person> getAllUsers();

    List<Person> getUsersByRole(String role);

    Person getUserByName(String name);

    boolean insertUser(User user);
    boolean insertUser(Owner owner);
    boolean insertUser(Lodger lodger);

    boolean updatePassword(int id, String password);

    boolean deleteUser(int id);

    boolean updateUser(int id, Person person);

    String getRole(int id);


}

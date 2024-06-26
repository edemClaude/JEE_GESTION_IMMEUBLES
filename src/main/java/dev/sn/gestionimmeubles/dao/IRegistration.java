package dev.sn.gestionimmeubles.dao;

import dev.sn.gestionimmeubles.entities.Lodger;
import dev.sn.gestionimmeubles.entities.Owner;
import dev.sn.gestionimmeubles.entities.Person;
import dev.sn.gestionimmeubles.entities.User;

public interface IRegistration {
    boolean login(String username, String password);

    boolean register(User user);
    boolean register(Owner owner);
    boolean register(Lodger lodger);
    boolean register(Person person);
}

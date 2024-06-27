package dev.sn.gestionimmeubles.test;

import dev.sn.gestionimmeubles.dao.IRegistration;
import dev.sn.gestionimmeubles.dao.RegistrationImpl;
import dev.sn.gestionimmeubles.entities.Owner;
import dev.sn.gestionimmeubles.entities.User;

public class TestLogin {
    public static void main(String[] args) {

        IRegistration iRegistration = new RegistrationImpl();

        User user = new User();
        user.setUsername("claude");
        user.setAddress("Dakar");
        user.setPhoneNumber("77 777 77 77");
        user.setFirstName("Claude");
        user.setLastName("KUMAZA");
        user.setRole("User");
        user.setPassword("passer123");

        boolean rest1 = iRegistration.register(user);
        System.out.println(rest1);

        boolean result = iRegistration.login("claude", "passer123");
        System.out.println(result);


        Owner owner = new Owner();
        owner.setFirstName("Propriot");
        owner.setLastName("PPPP");
        owner.setAddress("Dakar");
        owner.setPhoneNumber("77 777 77 77");
        owner.setUsername("prorpiot1");
        owner.setRole("Owner");
        owner.setPassword("passer123");
        boolean rest2 = iRegistration.register(owner);
        System.out.println(rest2);

    }
}

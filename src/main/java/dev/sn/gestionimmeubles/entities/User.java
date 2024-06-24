package dev.sn.gestionimmeubles.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.experimental.Accessors;

@Entity
@Accessors
public class User extends Person {
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}

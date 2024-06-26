package dev.sn.gestionimmeubles.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "person")
public class Person {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    protected int id;

    @Column(name = "first_name")
    protected String firstName;

    @Column(name = "last_name")
    protected String lastName;

    @Column(name = "phone_number")
    protected String phoneNumber;

    @Column(name = "address")
    protected String address;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;


}

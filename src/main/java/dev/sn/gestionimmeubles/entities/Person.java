package dev.sn.gestionimmeubles.entities;


import jakarta.persistence.*;
import lombok.experimental.Accessors;

@Entity
@Accessors
@Table(name = "person")
public class Person {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;


}

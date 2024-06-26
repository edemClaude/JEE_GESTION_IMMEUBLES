package dev.sn.gestionimmeubles.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@NamedQuery(name = "getAll", query = "select i from Immeuble i")
@NamedQuery(name = "getById", query = "select i from Immeuble i where i.id = :id")
@Table(name = "immeubles")
public class Immeuble {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "equipments")
    private String equipments;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;


}

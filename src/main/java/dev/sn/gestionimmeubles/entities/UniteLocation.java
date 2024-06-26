package dev.sn.gestionimmeubles.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UniteLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "unite_number", unique = true, nullable = false, length = 30)
    private String uniteNumber;

    @ManyToOne
    @JoinColumn(name = "immeuble_id")
    private Immeuble immeuble;

    @Column(name = "rent")
    private Double rent;

    @Column(name = "square")
    private Double square;

    @Column(name = "number_of_rooms")
    private Integer numberOfRooms;

}

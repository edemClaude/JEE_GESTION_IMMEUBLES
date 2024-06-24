package dev.sn.gestionimmeubles.entities;

import jakarta.persistence.*;
import lombok.experimental.Accessors;


@Entity
@Accessors
@Table(name = "contrat_location")
public class ContratLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "id_immeuble", referencedColumnName = "id")
    private Immeuble immeuble;

    @ManyToOne
    @JoinColumn(name = "id_lodger", referencedColumnName = "id")
    private Lodger lodger;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;


}

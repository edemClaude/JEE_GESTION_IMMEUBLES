package dev.sn.gestionimmeubles.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "paiements")
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "montant")
    private Double montant;

    @ManyToOne
    @JoinColumn(name = "contrat_id")
    private ContratLocation contrat;

    @Column(name = "statut")
    private boolean statut;

}

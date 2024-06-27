package dev.sn.gestionimmeubles.dao;

import dev.sn.gestionimmeubles.entities.Paiement;

import java.util.List;

public interface IPaiement {
    boolean addPaiement(Paiement paiement);
    boolean deletePaiement(int id);
    boolean updatePaiement(int id, Paiement p);
    List<Paiement> getPaiements(String key);
    List<Paiement> getPaiements();
}

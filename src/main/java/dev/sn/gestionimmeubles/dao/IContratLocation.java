package dev.sn.gestionimmeubles.dao;

import dev.sn.gestionimmeubles.entities.ContratLocation;

import java.util.List;

public interface IContratLocation {
    boolean addContrat(ContratLocation contrat);
    boolean deleteContrat(int id);
    boolean updateContrat(int id, ContratLocation contrat);
    List<ContratLocation> getAllContrat();
    List<ContratLocation> getContratByLodger(int id);

}

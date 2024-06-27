package dev.sn.gestionimmeubles.dao;

import dev.sn.gestionimmeubles.entities.Immeuble;

import java.util.List;

public interface IImmeuble {
    boolean addImmeuble(Immeuble immeuble);
    boolean deleteImmeuble(int id);
    boolean updateImmeuble(int id, Immeuble immeuble);
    List<Immeuble> getAllImmeubleByMC(String key);
    Immeuble getImmeubleById(int id);
    Immeuble getImmeubleByName(String name);

}

package dev.sn.gestionimmeubles.dao;

import dev.sn.gestionimmeubles.entities.Immeuble;

import java.util.List;

public interface IImmeuble {
    void addImmeuble(Immeuble immeuble);
    void deleteImmeuble(int id);
    void updateImmeuble(int id, Immeuble immeuble);
    List<Immeuble> getAllImmeuble();
    Immeuble getImmeubleById(int id);
    Immeuble getImmeubleByName(String name);

}

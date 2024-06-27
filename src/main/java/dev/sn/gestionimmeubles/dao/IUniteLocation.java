package dev.sn.gestionimmeubles.dao;

import dev.sn.gestionimmeubles.entities.UniteLocation;

import java.util.List;

public interface IUniteLocation {
    boolean addUnite(UniteLocation unite);
    boolean updateUnite(int id, UniteLocation uniteLocation);
    boolean deleteUnite(int id);
    List<UniteLocation> getUniteLocations(String key);

    List<UniteLocation> getAllUnites();

    UniteLocation getOneUnite(int id);

}

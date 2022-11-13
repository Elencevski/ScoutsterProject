package mk.ukim.finki.scoutster.service;

import mk.ukim.finki.scoutster.model.Terrain;

import java.util.List;

public interface TerrainService {

    Terrain create(String name, String description);
    Terrain update(String name, String description);

    void delete(String name);

    List<Terrain> listCategories();

    List<Terrain> searchCategories(String searchText);
}

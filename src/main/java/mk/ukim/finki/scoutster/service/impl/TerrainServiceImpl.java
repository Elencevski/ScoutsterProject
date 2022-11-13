package mk.ukim.finki.scoutster.service.impl;

import mk.ukim.finki.scoutster.model.Terrain;
import mk.ukim.finki.scoutster.repository.TerrainRepository;
import mk.ukim.finki.scoutster.service.TerrainService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TerrainServiceImpl implements TerrainService {

    private final TerrainRepository terrainRepository;

    public TerrainServiceImpl(TerrainRepository terrainRepository) {
        this.terrainRepository = terrainRepository;
    }


    @Override
    public Terrain create(String name, String description) {
        if ( name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Terrain c = new Terrain(name,description);
        terrainRepository.save(c);
        return c;
    }

    @Override
    public Terrain update(String name, String description) {
        if ( name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Terrain t = new Terrain(name,description);
        terrainRepository.save(t);
        return t;
    }

    @Override
    public void delete(String name) {

        if ( name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }


        terrainRepository.deleteByName(name);

    }

    @Override
    public List<Terrain> listCategories() {
        return terrainRepository.findAll();
    }

    @Override
    public List<Terrain> searchCategories(String searchText) {
        return terrainRepository.findAllByNameLike(searchText);
    }
}

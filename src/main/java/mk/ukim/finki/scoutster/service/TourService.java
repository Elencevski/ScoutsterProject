package mk.ukim.finki.scoutster.service;

import mk.ukim.finki.scoutster.model.Guide;
import mk.ukim.finki.scoutster.model.Terrain;
import mk.ukim.finki.scoutster.model.Tour;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface TourService {

    List<Tour> findAll();
    Optional<Tour> findById(Long id);
    Optional<Tour> findByName(String name);
    Optional<Tour> save(String name, Double price, Integer persons, Long terrainId,Long guide,String condition);  // so long imase nesto

    @Transactional
    Optional<Tour> edit( Long id,String name, Double price, Integer persons, Long terrainId,Long guide, String condition);

    void deleteById(Long id);
}

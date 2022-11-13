package mk.ukim.finki.scoutster.service.impl;

import mk.ukim.finki.scoutster.model.Guide;
import mk.ukim.finki.scoutster.model.Terrain;
import mk.ukim.finki.scoutster.model.Tour;
import mk.ukim.finki.scoutster.model.exceptions.GuideNotFoundException;
import mk.ukim.finki.scoutster.model.exceptions.TerrainNotFoundException;
import mk.ukim.finki.scoutster.model.exceptions.TourNotFoundException;
import mk.ukim.finki.scoutster.repository.GuideRepository;
import mk.ukim.finki.scoutster.repository.TerrainRepository;
import mk.ukim.finki.scoutster.repository.TourRepository;
import mk.ukim.finki.scoutster.service.TourService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TourServiceImpl implements TourService {

    private final GuideRepository guideRepository;
    private final TerrainRepository terrainRepository;
    private final TourRepository tourRepository;

    public TourServiceImpl(GuideRepository guideRepository, TerrainRepository terrainRepository, TourRepository tourRepository) {
        this.guideRepository = guideRepository;
        this.terrainRepository = terrainRepository;
        this.tourRepository = tourRepository;
    }


    @Override
    public List<Tour> findAll() {
        return this.tourRepository.findAll();
    }

    @Override
    public Optional<Tour> findById(Long id) {
        return this.tourRepository.findById(id);
    }

    @Override
    public Optional<Tour> findByName(String name) {
        return this.tourRepository.findByName(name);
    }

    @Override
    public Optional<Tour> save(String name, Double price, Integer persons, Long terrainId, Long guideId, String condition) {  // treba guide i terrain !!!
         Guide guide  = this.guideRepository.findById(guideId).orElseThrow();
        Terrain terrain = this.terrainRepository.findById(terrainId)
                .orElseThrow(() -> new TerrainNotFoundException(terrainId));


        this.tourRepository.deleteByName(name);
        Tour tour = new Tour(name,price,persons,terrain, guide ,condition);
        this.tourRepository.save(tour);
        return Optional.of(tour);   // ???
    }

    @Override
    @Transactional
    public Optional<Tour> edit(Long id, String name, Double price, Integer persons, Long terrainId, Long guideId, String condition) {  //// ???????
        Tour tour = this.tourRepository.findById(id).orElseThrow(() -> new TourNotFoundException(id));

        tour.setName(name);
        tour.setPrice(price);
        tour.setPersons(persons);

        Terrain terrain = this.terrainRepository.findById(terrainId)
                .orElseThrow(() -> new TerrainNotFoundException(terrainId));
        tour.setTerrain(terrain);

      Guide guide = this.guideRepository.findById(guideId).orElseThrow();
      tour.setGuide(guide);

        this.tourRepository.save(tour);
        return Optional.of(this.tourRepository.save(tour));
    }

    @Override
    public void deleteById(Long id) {

        this.tourRepository.deleteById(id);


    }
}

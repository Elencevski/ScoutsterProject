package mk.ukim.finki.scoutster.service;

import mk.ukim.finki.scoutster.model.Guide;

import java.util.List;
import java.util.Optional;

public interface GuideService {

    List<Guide> findAll();
    Optional<Guide> findById(Long id);
    Optional<Guide> save(String name, String address);
    void deleteById(Long id);
}

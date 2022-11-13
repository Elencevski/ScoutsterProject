package mk.ukim.finki.scoutster.service.impl;

import mk.ukim.finki.scoutster.model.Guide;
import mk.ukim.finki.scoutster.repository.GuideRepository;
import mk.ukim.finki.scoutster.service.GuideService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuideServiceImpl implements GuideService {

    private final GuideRepository guideRepository;

    public GuideServiceImpl(GuideRepository guideRepository) {
        this.guideRepository = guideRepository;
    }

    @Override
    public List<Guide> findAll() {
        return this.guideRepository.findAll();
    }

    @Override
    public Optional<Guide> findById(Long id) {
        return this.guideRepository.findById(id);
    }

    @Override
    public Optional<Guide> save(String name, String address) {
        return Optional.of(this.guideRepository.save(new Guide(name, address)));
    }

    @Override
    public void deleteById(Long id) {
        this.guideRepository.deleteById(id);
    }
}

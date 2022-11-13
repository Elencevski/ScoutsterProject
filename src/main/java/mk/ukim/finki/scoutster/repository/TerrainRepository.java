package mk.ukim.finki.scoutster.repository;

import mk.ukim.finki.scoutster.model.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TerrainRepository  extends JpaRepository<Terrain,Long> {

    List<Terrain> findAllByNameLike(String text);
    void deleteByName(String name);

}

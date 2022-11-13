package mk.ukim.finki.scoutster.repository;

import mk.ukim.finki.scoutster.model.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GuideRepository extends JpaRepository<Guide,Long> {


}

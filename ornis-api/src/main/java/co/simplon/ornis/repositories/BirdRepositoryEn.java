package co.simplon.ornis.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.ornis.dtos.BirdViewEn;
import co.simplon.ornis.entities.Bird;

public interface BirdRepositoryEn
	extends JpaRepository<Bird, Long> {

    Collection<BirdViewEn> findAllProjectedBy();
}

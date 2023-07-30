package co.simplon.ornis.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.ornis.dtos.BirdViewFr;
import co.simplon.ornis.entities.Bird;

public interface BirdRepositoryFr
	extends JpaRepository<Bird, Long> {

    Collection<BirdViewFr> findAllProjectedBy();
}

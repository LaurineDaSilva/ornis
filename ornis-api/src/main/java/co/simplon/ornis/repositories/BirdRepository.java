package co.simplon.ornis.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.ornis.dtos.BirdView;
import co.simplon.ornis.entities.Bird;

public interface BirdRepository
	extends JpaRepository<Bird, Long> {

    Collection<BirdView> findAllProjectedBy();
}

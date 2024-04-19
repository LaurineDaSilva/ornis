package co.simplon.ornis.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.ornis.dtos.birds.BirdColorDto;
import co.simplon.ornis.entities.BirdColor;

public interface BirdColorRepository
	extends JpaRepository<BirdColor, Long> {

    Collection<BirdColorDto> findAllByBirdId(Long birdId);

}

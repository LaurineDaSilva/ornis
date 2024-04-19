package co.simplon.ornis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.ornis.entities.BirdColor;

public interface BirdColorRepository
	extends JpaRepository<BirdColor, Long> {

}

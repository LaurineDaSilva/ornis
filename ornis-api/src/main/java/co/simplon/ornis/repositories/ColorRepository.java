package co.simplon.ornis.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.ornis.dtos.birds.BirdPartView;
import co.simplon.ornis.entities.Color;

public interface ColorRepository
	extends JpaRepository<Color, Long> {

    Collection<BirdPartView> findAllProjectedBy();

}
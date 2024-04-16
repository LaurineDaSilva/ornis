package co.simplon.ornis.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.ornis.dtos.birds.BirdPartView;
import co.simplon.ornis.entities.FeetShape;

public interface FeetShapeRepository
	extends JpaRepository<FeetShape, Long> {

    Collection<BirdPartView> findAllProjectedBy();

}

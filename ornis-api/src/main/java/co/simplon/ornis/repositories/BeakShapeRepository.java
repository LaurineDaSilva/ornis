package co.simplon.ornis.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.ornis.dtos.birds.BirdPartView;
import co.simplon.ornis.entities.BeakShape;

public interface BeakShapeRepository
	extends JpaRepository<BeakShape, Long> {

    Collection<BirdPartView> findAllProjectedBy();

}

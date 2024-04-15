package co.simplon.ornis.services;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.ornis.dtos.birds.BirdPartView;
import co.simplon.ornis.repositories.BeakShapeRepository;

@Service
@Transactional(readOnly = true)
public class BeakShapeServiceImpl
	implements BeakShapeService {

    private final BeakShapeRepository beakShapes;

    public BeakShapeServiceImpl(
	    BeakShapeRepository beakShapes) {
	this.beakShapes = beakShapes;
    }

    @Override
    public Collection<BirdPartView> getAll() {
	return beakShapes.findAllProjectedBy();
    }

}

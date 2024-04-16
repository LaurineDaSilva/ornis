package co.simplon.ornis.services;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.ornis.dtos.birds.BirdPartView;
import co.simplon.ornis.repositories.FeetShapeRepository;

@Service
@Transactional(readOnly = true)
public class FeetShapeServiceImpl
	implements FeetShapeService {

    private final FeetShapeRepository feetShapes;

    public FeetShapeServiceImpl(
	    FeetShapeRepository feetShapes) {
	this.feetShapes = feetShapes;
    }

    @Override
    public Collection<BirdPartView> getAll() {
	return feetShapes.findAllProjectedBy();
    }

}

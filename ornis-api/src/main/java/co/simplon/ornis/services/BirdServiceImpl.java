package co.simplon.ornis.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import co.simplon.ornis.dtos.BirdDetail;
import co.simplon.ornis.dtos.BirdView;
import co.simplon.ornis.repositories.BirdRepository;

@Service
public class BirdServiceImpl implements BirdService {

    private BirdRepository birds;

    public BirdServiceImpl(BirdRepository birds) {
	this.birds = birds;
    }

    @Override
    public Collection<BirdView> getAll(Long id) {
	return birds.findAllProjectedBy();
    }

    @Override
    public BirdDetail detail(Long id) {
	return birds.findProjectedDetailById(id);
    }

}

package co.simplon.ornis.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import co.simplon.ornis.dtos.BirdView;
import co.simplon.ornis.repositories.BirdRepository;

@Service
public class BirdServiceImpl implements BirdService {

    private BirdRepository birds;

    public BirdServiceImpl(BirdRepository birds) {
	this.birds = birds;
    }

    @Override
    public Collection<BirdView> getAll() {
	// TODO Auto-generated method stub
	return birds.findAllProjectedBy();
    }

}

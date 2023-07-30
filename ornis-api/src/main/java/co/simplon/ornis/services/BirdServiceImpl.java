package co.simplon.ornis.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import co.simplon.ornis.dtos.BirdViewEn;
import co.simplon.ornis.dtos.BirdViewFr;
import co.simplon.ornis.repositories.BirdRepositoryEn;
import co.simplon.ornis.repositories.BirdRepositoryFr;

@Service
public class BirdServiceImpl implements BirdService {

    private BirdRepositoryEn birdsEn;
    private BirdRepositoryFr birdsFr;

    public BirdServiceImpl(BirdRepositoryEn birdsEn,
	    BirdRepositoryFr birdsFr) {
	this.birdsEn = birdsEn;
	this.birdsFr = birdsFr;
    }

    @Override
    public Collection<BirdViewEn> getAllEn() {
	return birdsEn.findAllProjectedBy();
    }

    @Override
    public Collection<BirdViewFr> getAllFr() {
	return birdsFr.findAllProjectedBy();
    }

}

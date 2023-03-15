package co.simplon.ornis.services;

import java.util.Collection;

import co.simplon.ornis.dtos.BirdView;

public interface BirdService {

    Collection<BirdView> getAll();

    Object[] findFrenchBirds();

}

package co.simplon.ornis.services;

import java.util.Collection;

import co.simplon.ornis.dtos.birds.BirdPartView;

public interface BeakShapeService {

    Collection<BirdPartView> getAll();

}

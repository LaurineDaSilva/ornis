package co.simplon.ornis.services;

import java.util.Collection;

import co.simplon.ornis.dtos.BirdViewEn;
import co.simplon.ornis.dtos.BirdViewFr;

public interface BirdService {

    Collection<BirdViewEn> getAllEn();

    Collection<BirdViewFr> getAllFr();

}

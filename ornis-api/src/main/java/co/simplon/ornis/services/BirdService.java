package co.simplon.ornis.services;

import java.util.Collection;

import co.simplon.ornis.dtos.BirdDetail;
import co.simplon.ornis.dtos.BirdView;

public interface BirdService {

    Collection<BirdView> getAll(Long id);

    BirdDetail detail(Long id);

}

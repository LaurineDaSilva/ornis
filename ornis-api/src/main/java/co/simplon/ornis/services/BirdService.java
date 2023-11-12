package co.simplon.ornis.services;

import java.util.Collection;

import co.simplon.ornis.dtos.BirdCreate;
import co.simplon.ornis.dtos.BirdDetail;
import co.simplon.ornis.dtos.BirdToUpdate;
import co.simplon.ornis.dtos.BirdUpdate;
import co.simplon.ornis.dtos.BirdView;

public interface BirdService {

    Collection<BirdView> getAll(Long id);

    BirdDetail getDetail(Long id);

    void createBird(BirdCreate inputs);

    BirdToUpdate getBirdToUpdate(Long id);

    void updateBird(Long id, BirdUpdate inputs);

    void delete(Long id);

}

package co.simplon.ornis.services;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.ornis.dtos.birds.BirdPartView;
import co.simplon.ornis.repositories.ColorRepository;

@Service
@Transactional(readOnly = true)
public class ColorServiceImpl implements ColorService {

    private final ColorRepository colors;

    public ColorServiceImpl(ColorRepository colors) {
	this.colors = colors;
    }

    @Override
    public Collection<BirdPartView> getAll() {
	return colors.findAllProjectedBy();
    }

}

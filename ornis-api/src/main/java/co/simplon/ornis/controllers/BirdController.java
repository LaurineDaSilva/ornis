package co.simplon.ornis.controllers;

import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.ornis.dtos.BirdView;
import co.simplon.ornis.services.BirdService;

@RestController
@RequestMapping("/birds")
@CrossOrigin
public class BirdController {

    private final BirdService service;

    public BirdController(BirdService service) {
	this.service = service;
    }

    @GetMapping
    public Collection<BirdView> getAll() {
	return service.getAll();
    }

    @GetMapping("/selected")
    public Object[] findFrenchBirds() {
	return service.findFrenchBirds();
    }
}

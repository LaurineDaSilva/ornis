package co.simplon.ornis.controllers;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.ornis.dtos.birds.BirdPartView;
import co.simplon.ornis.services.FeetShapeService;

@RestController
@RequestMapping("/feetShapes")
public class FeetShapeController {

    private final FeetShapeService service;

    public FeetShapeController(FeetShapeService service) {
	this.service = service;
    }

    @GetMapping
    public Collection<BirdPartView> getAll() {
	return service.getAll();
    }
}
package co.simplon.ornis.controllers;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.ornis.dtos.birds.BirdPartView;
import co.simplon.ornis.services.BeakShapeService;

@RestController
@RequestMapping("/beakShapes")
public class BeakShapeController {

    private final BeakShapeService service;

    public BeakShapeController(BeakShapeService service) {
	this.service = service;
    }

    @GetMapping
    public Collection<BirdPartView> getAll() {
	return service.getAll();
    }
}
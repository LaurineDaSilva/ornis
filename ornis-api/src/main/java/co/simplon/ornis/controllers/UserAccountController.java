package co.simplon.ornis.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.ornis.dtos.users.CreateUserAccount;
import co.simplon.ornis.services.UserAccountAuthenticationService;

@RestController
@RequestMapping("/join")
public class UserAccountController {

    private final UserAccountAuthenticationService service;

    public UserAccountController(
	    UserAccountAuthenticationService service) {
	this.service = service;
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void signUp(
	    @RequestBody @Valid CreateUserAccount inputs) {
	service.signUp(inputs);
    }

}

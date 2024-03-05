package co.simplon.ornis.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.ornis.dtos.users.TokenInfo;
import co.simplon.ornis.dtos.users.UserAccountCreate;
import co.simplon.ornis.dtos.users.UserAccountLogTo;
import co.simplon.ornis.services.UserAccountAuthenticationService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/join")
public class UserAccountController {

    private final UserAccountAuthenticationService service;

    public UserAccountController(
	    UserAccountAuthenticationService service) {
	this.service = service;
    }

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void signUp(
	    @RequestBody @Valid UserAccountCreate inputs) {
	service.signUp(inputs);
    }

    @PostMapping("/sign-in")
    public TokenInfo signIn(
	    @RequestBody UserAccountLogTo inputs) {
	return service.signIn(inputs);
    }

}

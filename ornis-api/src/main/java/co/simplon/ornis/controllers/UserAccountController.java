package co.simplon.ornis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.ornis.dtos.CreateUserAccount;
import co.simplon.ornis.services.UserAccountAuthenticationService;

@RestController
@RequestMapping("/join")
public class UserAccountController {

    @Autowired
    private UserAccountAuthenticationService service;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void signUp(
	    @RequestBody CreateUserAccount inputs) {
	service.signUp(inputs);
    }

}
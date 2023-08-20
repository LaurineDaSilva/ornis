package co.simplon.ornis.services;

import co.simplon.ornis.dtos.CreateUserAccount;

public interface AuthenticationService {

    public void signUp(CreateUserAccount inputs);

}

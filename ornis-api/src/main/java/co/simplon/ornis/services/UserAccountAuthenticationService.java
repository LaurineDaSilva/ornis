package co.simplon.ornis.services;

import co.simplon.ornis.dtos.CreateUserAccount;

public interface UserAccountAuthenticationService {

    public void signUp(CreateUserAccount inputs);

}

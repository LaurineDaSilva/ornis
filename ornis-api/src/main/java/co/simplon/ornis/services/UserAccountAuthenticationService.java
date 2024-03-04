package co.simplon.ornis.services;

import co.simplon.ornis.dtos.users.CreateUserAccount;

public interface UserAccountAuthenticationService {

    public void signUp(CreateUserAccount inputs);

    public boolean emailAddressExists(String email);

    public boolean nicknameExists(String nickname);

}

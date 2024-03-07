package co.simplon.ornis.services;

import co.simplon.ornis.dtos.users.TokenInfo;
import co.simplon.ornis.dtos.users.UserAccountCreate;
import co.simplon.ornis.dtos.users.UserAccountLogTo;

public interface UserAccountAuthenticationService {

    public void signUp(UserAccountCreate inputs);

    public TokenInfo signIn(UserAccountLogTo inputs);

    public boolean emailAddressExists(String email);

    public boolean nicknameExists(String nickname);

}

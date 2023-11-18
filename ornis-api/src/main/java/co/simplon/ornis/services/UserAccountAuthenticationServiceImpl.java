package co.simplon.ornis.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.ornis.dtos.CreateUserAccount;
import co.simplon.ornis.entities.UserAccount;
import co.simplon.ornis.repositories.UserAccountRepository;
import co.simplon.ornis.security.AuthenticationHelper;

@Service
@Transactional(readOnly = true)
public class UserAccountAuthenticationServiceImpl
	implements UserAccountAuthenticationService {

    private final AuthenticationHelper authenticationHelper;
    private final UserAccountRepository userAccounts;

    public UserAccountAuthenticationServiceImpl(
	    AuthenticationHelper authenticationHelper,
	    UserAccountRepository userAccounts) {
	this.authenticationHelper = authenticationHelper;
	this.userAccounts = userAccounts;
    }

    @Transactional
    @Override
    public void signUp(CreateUserAccount inputs) {
	UserAccount userAccount = new UserAccount();
	userAccount.setNickname(inputs.getNickname());
	userAccount
		.setEmailAddress(inputs.getEmailAddress());
	String hashedPassword = authenticationHelper
		.encode(inputs.getPassword());
	userAccount.setPassword(hashedPassword);
	userAccount.setRoles("ROLE_USER");
	userAccounts.save(userAccount);
    }

    @Override
    public boolean emailAddressExists(String email)
	    throws UnsupportedOperationException {

	return this.userAccounts
		.existsByEmailAddress(email.toString());
    }

    @Override
    public boolean nicknameExists(String nickname)
	    throws UnsupportedOperationException {

	return this.userAccounts
		.existsByNickname(nickname.toString());
    }

}

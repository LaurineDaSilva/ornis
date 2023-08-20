package co.simplon.ornis.services;

import co.simplon.ornis.dtos.CreateUserAccount;
import co.simplon.ornis.entities.UserAccount;
import co.simplon.ornis.repositories.UserAccountRepository;
import co.simplon.ornis.security.AuthenticationHelper;

public class AuthenticationServiceImpl
	implements AuthenticationService {

    private final AuthenticationHelper authenticationHelper;
    private final UserAccountRepository userAccounts;

    public AuthenticationServiceImpl(
	    AuthenticationHelper authenticationHelper,
	    UserAccountRepository userAccounts) {
	this.authenticationHelper = authenticationHelper;
	this.userAccounts = userAccounts;
    }

    @Override
    public void signUp(CreateUserAccount inputs) {
	UserAccount userAccount = new UserAccount();
	userAccount.setUsername(inputs.getUsername());
	userAccount
		.setEmailAddress(inputs.getEmailAddress());
	String hashedPassword = authenticationHelper
		.encode(inputs.getPassword());
	userAccount.setPassword(hashedPassword);
	userAccounts.save(userAccount);
    }

}

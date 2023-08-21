package co.simplon.ornis.services;

import org.springframework.stereotype.Service;

import co.simplon.ornis.dtos.CreateUserAccount;
import co.simplon.ornis.entities.UserAccount;
import co.simplon.ornis.repositories.UserAccountRepository;
import co.simplon.ornis.security.AuthenticationHelper;

@Service
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

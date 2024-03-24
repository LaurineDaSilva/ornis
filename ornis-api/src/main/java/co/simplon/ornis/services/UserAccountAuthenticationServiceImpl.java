package co.simplon.ornis.services;

import java.util.regex.Pattern;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.ornis.dtos.users.TokenInfo;
import co.simplon.ornis.dtos.users.UserAccountCreate;
import co.simplon.ornis.dtos.users.UserAccountLogTo;
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
    public void signUp(UserAccountCreate inputs) {
	UserAccount userAccount = new UserAccount();
	userAccount.setNickname(inputs.getNickname());
	userAccount
		.setEmailAddress(inputs.getEmailAddress());
	String hashedPassword = authenticationHelper
		.encode(inputs.getPassword());
	userAccount.setPassword(hashedPassword);
	userAccount.setRole("ROLE_USER");
	userAccounts.save(userAccount);
    }

    @Override
    public TokenInfo signIn(UserAccountLogTo inputs) {
	String nicknameOrEmailAddress = inputs
		.getNicknameOrEmailAddress();
	String candidate = inputs.getPassword();

	UserAccount userAccount = isEmailAddress(
		nicknameOrEmailAddress)
			? userAccounts.findByEmailAddress(
				nicknameOrEmailAddress)
			: userAccounts.findByNickname(
				nicknameOrEmailAddress);

	if (userAccount != null) {
	    boolean match = authenticationHelper.matches(
		    candidate, userAccount.getPassword());

	    if (match) {
		String nickname = userAccount.getNickname();
		String emailAddress = userAccount
			.getEmailAddress();
		String role = userAccount.getRole();
		String token = authenticationHelper
			.createJWT(role, nickname);

		TokenInfo tokenInfo = new TokenInfo();
		tokenInfo.setNickname(nickname);
		tokenInfo.setEmailAddress(emailAddress);
		tokenInfo.setToken(token);
		tokenInfo.setRole(role);

		return tokenInfo;
	    } else {
		throw new BadCredentialsException(
			"Wrong credentials");
	    }
	} else {
	    throw new BadCredentialsException(
		    "Wrong credentials");
	}
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

    public boolean isEmailAddress(String input) {
	String regexPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
	return Pattern.compile(regexPattern).matcher(input)
		.matches();
    }
}

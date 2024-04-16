package co.simplon.ornis.dtos.users;

import co.simplon.ornis.dtos.users.validators.EmailUnicity;
import co.simplon.ornis.dtos.users.validators.UsernameUnicity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserAccountCreate {

    @NotBlank
    @Size(max = 100)
    @Email
    @EmailUnicity
    private String emailAddress;

    @NotBlank
    @Size(max = 20)
    @UsernameUnicity
    private String username;

    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[%*!]).{8,42}$")
    private String password;

    public UserAccountCreate() {
    }

    public String getEmailAddress() {
	return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    @Override
    public String toString() {
	return "{emailAddress=" + emailAddress
		+ ", username=" + username
		+ ", password={protected} ";
    }

}

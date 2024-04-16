package co.simplon.ornis.dtos.users;

import jakarta.validation.constraints.NotBlank;

public class UserAccountLogTo {

    @NotBlank
    private String usernameOrEmailAddress;

    @NotBlank
    private String password;

    public UserAccountLogTo() {
    }

    public String getUsernameOrEmailAddress() {
	return usernameOrEmailAddress;
    }

    public void setUsernameOrEmailAddress(
	    String usernameOrEmailAddress) {
	this.usernameOrEmailAddress = usernameOrEmailAddress;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    @Override
    public String toString() {
	return "{usernameOrEmailAddress="
		+ usernameOrEmailAddress
		+ ", password={protected} ";
    }

}

package co.simplon.ornis.dtos;

public class CreateUserAccount {

    private String emailAddress;

    private String username;

    private String password;

    public CreateUserAccount() {
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
		+ ", password={protected}";
    }

}

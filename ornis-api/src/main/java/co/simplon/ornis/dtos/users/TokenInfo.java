package co.simplon.ornis.dtos.users;

public class TokenInfo {

    private String token;

    private String role;

    private String username;

    private String emailAddress;

    public TokenInfo() {
    }

    public String getToken() {
	return token;
    }

    public void setToken(String token) {
	this.token = token;
    }

    public String getRole() {
	return role;
    }

    public void setRole(String role) {
	this.role = role;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getEmailAddress() {
	return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
	return "{token=" + token + ", role=" + role
		+ ", username=" + username
		+ ", emailAddress=" + emailAddress + "}";
    }

}

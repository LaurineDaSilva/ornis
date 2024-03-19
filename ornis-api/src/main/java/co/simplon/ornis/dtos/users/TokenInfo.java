package co.simplon.ornis.dtos.users;

public class TokenInfo {

    private String token;
    private String role;
    private String nickname;
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

    public String getNickname() {
	return nickname;
    }

    public void setNickname(String nickname) {
	this.nickname = nickname;
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
		+ ", nickname=" + nickname
		+ ", emailAddress=" + emailAddress + "}";
    }

}

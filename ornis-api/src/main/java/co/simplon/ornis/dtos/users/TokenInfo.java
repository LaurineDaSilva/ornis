package co.simplon.ornis.dtos.users;

import java.util.List;

public class TokenInfo {

    private String token;
    private List<String> roles;

    public TokenInfo() {
	super();
	// TODO Auto-generated constructor stub
    }

    public String getToken() {
	return token;
    }

    public void setToken(String token) {
	this.token = token;
    }

    public List<String> getRoles() {
	return roles;
    }

    public void setRoles(List<String> roles) {
	this.roles = roles;
    }

    @Override
    public String toString() {
	return "{token=" + token + ", roles=" + roles + "}";
    }

}

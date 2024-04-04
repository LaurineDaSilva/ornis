package co.simplon.ornis.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_user_accounts")
public class UserAccount extends AbstractEntity {

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    public UserAccount() {
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

    public String getRole() {
	return role;
    }

    public void setRole(String role) {
	this.role = role;
    }

    @Override
    public int hashCode() {
	return Objects.hash(emailAddress);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	return obj instanceof UserAccount other && Objects
		.equals(emailAddress, other.emailAddress);
    }

    @Override
    public String toString() {
	return "{emailAddress=" + emailAddress
		+ ", username=" + username
		+ ", password={protected}" + ", role="
		+ role + "}";
    }

}

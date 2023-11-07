package co.simplon.ornis.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_accounts")
public class UserAccount extends AbstractEntity {

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "roles")
    private String roles;

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

    public String getRoles() {
	return roles;
    }

    public void setRoles(String roles) {
	this.roles = roles;
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
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	UserAccount other = (UserAccount) obj;
	return Objects.equals(emailAddress,
		other.emailAddress);
    }

    @Override
    public String toString() {
	return "{emailAddress=" + emailAddress
		+ ", username=" + username
		+ ", password={protected}" + ", roles="
		+ roles + "}";
    }

}

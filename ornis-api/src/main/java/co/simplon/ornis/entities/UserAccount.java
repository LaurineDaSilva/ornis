package co.simplon.ornis.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_accounts")
public class UserAccount extends AbstractEntity {

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "nickname")
    private String nickname;

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

    public String getNickname() {
	return nickname;
    }

    public void setNickname(String nickname) {
	this.nickname = nickname;
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
		+ ", nickname=" + nickname
		+ ", password={protected}" + ", roles="
		+ roles + "}";
    }

}

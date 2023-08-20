package co.simplon.ornis.entities;

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

    @Column(name = "roles_id")
    private int roles;

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

    public int getRoles() {
	return roles;
    }

    public void setRoles(int roles) {
	this.roles = roles;
    }

    @Override
    public String toString() {
	return String.format(
		"{id=%s, emailAddress=%s, username=%s,password=%s, roles=%s}",
		getId(), emailAddress, username, password,
		roles);
    }

}

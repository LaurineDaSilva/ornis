package co.simplon.ornis.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import co.simplon.ornis.dtos.validators.EmailUnicity;
import co.simplon.ornis.dtos.validators.NicknameUnicity;

public class CreateUserAccount {

    @NotBlank
    @Size(max = 100)
    @Email
    @EmailUnicity
    private String emailAddress;

    @NotBlank
    @Size(max = 20)
    @NicknameUnicity
    private String nickname;

    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[%*!]).{8,42}$")
    private String password;

    public CreateUserAccount() {
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

    @Override
    public String toString() {
	return "{emailAddress=" + emailAddress
		+ ", nickname=" + nickname
		+ ", password={protected} ";
    }

}

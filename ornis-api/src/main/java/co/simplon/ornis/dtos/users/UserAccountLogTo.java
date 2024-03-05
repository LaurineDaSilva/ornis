package co.simplon.ornis.dtos.users;

import jakarta.validation.constraints.NotBlank;

public class UserAccountLogTo {

    @NotBlank
    private String nicknameOrEmailAddress;

    @NotBlank
    private String password;

    public UserAccountLogTo() {
    }

    public String getNicknameOrEmailAddress() {
	return nicknameOrEmailAddress;
    }

    public void setNicknameOrEmailAddress(
	    String nicknameOrEmailAddress) {
	this.nicknameOrEmailAddress = nicknameOrEmailAddress;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    @Override
    public String toString() {
	return "{nicknameOrEmailAddress="
		+ nicknameOrEmailAddress
		+ ", password={protected} ";
    }

}

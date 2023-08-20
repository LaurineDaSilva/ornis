package co.simplon.ornis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.ornis.entities.UserAccount;

public interface UserAccountRepository
	extends JpaRepository<UserAccount, Long> {

}

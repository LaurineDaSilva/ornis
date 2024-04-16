package co.simplon.ornis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.ornis.entities.UserAccount;

public interface UserAccountRepository
	extends JpaRepository<UserAccount, Long> {

    boolean existsByEmailAddress(String emailAddress);

    boolean existsByUsername(String username);

    UserAccount findByEmailAddress(String emailAddress);

    UserAccount findByUsername(String username);

}

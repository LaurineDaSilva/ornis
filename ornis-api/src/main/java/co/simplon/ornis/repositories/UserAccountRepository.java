package co.simplon.ornis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.ornis.entities.UserAccount;

public interface UserAccountRepository
	extends JpaRepository<UserAccount, Long> {

    boolean existsByEmailAddress(String emailAddress);

    boolean existsByNickname(String nickname);

    UserAccount findByEmailAddress(String emailAddress);

    UserAccount findByNickname(String nickname);

}

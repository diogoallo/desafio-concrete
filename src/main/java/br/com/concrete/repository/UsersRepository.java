package br.com.concrete.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.concrete.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	
	Optional<Users> findByEmail(String Email);
	
}

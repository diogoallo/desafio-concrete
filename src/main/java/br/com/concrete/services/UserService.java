package br.com.concrete.services;

import java.util.Optional;

import br.com.concrete.model.Users;

public interface UserService {
		
	Users save(Users u);
	
	Optional<Users> findByEmail(String Email);
}

package br.com.concrete.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.concrete.model.Users;
import br.com.concrete.repository.UsersRepository;
import br.com.concrete.services.UserService;

@Service
public class UsersServiceImpl implements UserService {
	
	@Autowired
	UsersRepository repository;
	
	@Override
	public Users save(Users u) {
		return repository.save(u);
	}

	@Override
	public Optional<Users> findByEmail(String Email) {
		return repository.findByEmail(Email);
	}

}

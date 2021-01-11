package br.com.concrete.controller;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.concrete.dto.UsersDTO;
import br.com.concrete.response.Response;
import br.com.concrete.services.UserService;

@RestController
@RequestMapping("user")
public class UserContreller {
	
	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<Response<UsersDTO>> cadastrar(@Valid @RequestBody UsersDTO usersDto,
			BindingResult result) throws NoSuchAlgorithmException {
		
		
		return null;
	}
	
}

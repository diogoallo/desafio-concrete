package br.com.concrete.service;


import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.concrete.model.Users;
import br.com.concrete.repository.UsersRepository;
import br.com.concrete.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {
	
	@MockBean
	UsersRepository repository;
	
	@Autowired
	UserService service;
	
	@Before
	public void setUp() {
		BDDMockito.given(repository.findByEmail(Mockito.anyString())).willReturn(Optional.of(new Users()));
	}
	
	@Test
	public void testFindByEmail() {
		Optional<Users> u = service.findByEmail("email@teste.com.br");
		assertTrue(u.isPresent());
	}
}

package br.com.concrete.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.concrete.model.Phones;
import br.com.concrete.model.Users;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioRepositoryTest {
	
	private static final String email = "email@teste.com.br";
	
	@Autowired
	UsersRepository repository;
	
	
	@Before
	public void setUp() {
		Users u = new Users();
		u.setName("Set Up Usuário");
		u.setPassword("Senha1234");
		u.setEmail(email);
		repository.save(u);
	}
	
	
	@After
	public void tearDow() {
		repository.deleteAll();
	}
	
	
	@Test
	public void testSave() {
		Users u = new Users();
	
		u.setName("Teste");
		u.setPassword("123456");
		u.setEmail("teste@teste.com.br");
		
		Users response = repository.save(u);
		assertNotNull(response);
	}
    
	@Test 
	public void testFindByEmail() {
		
		Optional<Users> response = repository.findByEmail(email);
		
		assertTrue(response.isPresent());
		assertEquals(response.get().getEmail(), email);
	}
	
	private List<Phones> getListaTelefones(){
		 List<Phones> listaTelefone = new ArrayList<>();
		 
		 Phones telefones = new Phones();
		 telefones.setDdd("19");
		 telefones.setNumber("989318997");
		 
		 listaTelefone.add(telefones);
		return listaTelefone;
	}
	
	
}

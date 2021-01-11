package br.com.concrete.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.concrete.dto.UsersDTO;
import br.com.concrete.model.Users;
import br.com.concrete.services.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UsersControllerTest {
	
	private static final String EMAIL = "email@test.com.br";
	private static final String NAME = "User Test";
	private static final String PASSWORD = "123456";
	private static final String URL = "/users";
	
	@MockBean
	UserService service;
	
	@Autowired
	MockMvc mvc;
	
	@Test
	public void testSave() throws Exception {
		
		mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayLoad())
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated());
	}
	
	public Users getUser() {
		Users u = new Users();
		u.setName(NAME);
		u.setEmail(EMAIL);
		u.setPassword(PASSWORD);
		
		return u;
	}
	
	public String getJsonPayLoad() {
		UsersDTO dto = new UsersDTO();
		dto.setName(NAME);
		dto.setEmail(EMAIL);
		dto.setPassword(PASSWORD);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValueAsString(dto);
	}

}

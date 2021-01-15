package br.com.concrete.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.concrete.dto.UsersDTO;
import br.com.concrete.model.Users;
import br.com.concrete.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserControllerTest {
	
	private static final String URL = "/users";
	private static final String NAME = "User Test";
	private static final String EMAIL = "email@test.com";
	private static final String PASSWORS = "123456";

	
	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserService service;
	
	@Test
	public void testSave() throws JsonProcessingException, Exception {
		mvc.perform(MockMvcRequestBuilders.post(URL).content(this.getJsonPayLoad())
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	private Users getMockUser(){
		Users u = new Users();
		u.setName(NAME);
		u.setEmail(EMAIL);
		u.setPassword(PASSWORS);
		
		return u;
	}
	
	public String  getJsonPayLoad() throws JsonProcessingException {
		UsersDTO dto = new UsersDTO();
		dto.setName(NAME);
		dto.setEmail(EMAIL);
        dto.setPassword(PASSWORS);		
		
        ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(dto);
	}
	
	
	
	
}

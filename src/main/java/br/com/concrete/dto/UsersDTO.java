package br.com.concrete.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UsersDTO {

	private Long id;
	
	@Length(min=3, max=50, message = "O nome deve conter entre 3 e 50 caracteres" )
	private String name;
	
	@Email(message = "Email Inválido")
	private String email;
	
	@NotNull
	@Length(min=6, message = "A senha deve conterno mínimo 6 caracteres" )
	private String password;

}

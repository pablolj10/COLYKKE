package com.colykke.dto.usuario;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsuarioResponseDto {

	private Long id;
	
	private String email;
	
	private String username;
}

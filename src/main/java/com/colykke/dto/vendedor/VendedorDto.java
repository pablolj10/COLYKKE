package com.colykke.dto.vendedor;

import com.colykke.dto.usuario.UsuarioResponseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VendedorDto {

	private long id;
	
	private String nombre;
	private String logo;
	private int telefono;
	private String info;
	
	private UsuarioResponseDto usuario;
}

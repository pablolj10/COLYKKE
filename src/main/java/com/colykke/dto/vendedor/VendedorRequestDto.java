package com.colykke.dto.vendedor;

import com.colykke.dto.usuario.UsuarioRequestDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VendedorRequestDto {

	private String nombre;
	private String logo;
	private int telefono;
	private String info;
	
	private UsuarioRequestDto usuario;
}

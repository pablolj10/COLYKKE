package com.colykke.dto.cliente;


import com.colykke.dto.usuario.UsuarioResponseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClienteSinPedidosResponseDto {

	private long id;
	
	private String nombre;

	private UsuarioResponseDto usuario;
	
}

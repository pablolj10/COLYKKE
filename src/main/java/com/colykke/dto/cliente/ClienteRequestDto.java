package com.colykke.dto.cliente;


import com.colykke.dto.usuario.UsuarioRequestDto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClienteRequestDto {

	private String nombre;

	private UsuarioRequestDto usuario;

	
}

package com.colykke.dto.cliente;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClienteSinPedidosResponseDto {

	private long id;
	
	private String nombre;
	private String correoElectronico;
	private String contrasenia;
	
}

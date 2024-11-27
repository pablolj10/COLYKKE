package com.colykke.dto.cliente;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClienteSinPedidosResponseDto {

	private String nombre;
	private int telefono;
	@Column(name="correo_electronico")
	private String correoElectronico;
	private String contrasenia;
	
}

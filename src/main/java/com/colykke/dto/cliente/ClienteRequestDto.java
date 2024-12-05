package com.colykke.dto.cliente;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClienteRequestDto {

	private String nombre;
	@Column(name="correo_electronico")
	private String correoElectronico;
	private String contrasenia;

	
}

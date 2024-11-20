package com.colykke.dto.vendedor;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VendedorDto {

	private long id;
	
	private String nombre;
	private String correoElectronico;
	private String contrasenia;
	private String logo;
	private int telefono;
	private String info;
}

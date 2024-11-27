package com.colykke.dto.vendedor;

import java.util.List;

import com.colykke.dto.producto.ProductoResponseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VendedorResponseDto {

	private String nombre;
	private String correoElectronico;
	private String contrasenia;
	private String logo;
	private int telefono;
	private String info;
	
	private List<ProductoResponseDto> productos;
	
}

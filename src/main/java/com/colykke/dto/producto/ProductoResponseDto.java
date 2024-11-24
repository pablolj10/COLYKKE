package com.colykke.dto.producto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductoResponseDto {
	
	private String nombre;
	private String descripcion;
	private String color;
	private float precio;
	private String imagen;
	private String vendedorNombre;
	
	public ProductoResponseDto() {}
}

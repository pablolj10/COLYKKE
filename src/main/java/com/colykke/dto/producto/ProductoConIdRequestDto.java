package com.colykke.dto.producto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductoConIdRequestDto {
	
	private long id;
	private String nombre;
	private String descripcion;
	private String color;
	private float precio;
	private String imagen;
	private int vendedorId;
}

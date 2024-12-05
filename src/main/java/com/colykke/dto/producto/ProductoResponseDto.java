package com.colykke.dto.producto;

import com.colykke.dto.vendedor.VendedorSinProductosResponseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductoResponseDto {
	
	private long id;
	private String nombre;
	private String descripcion;
	private String color;
	private float precio;
	private String imagen;
	private VendedorSinProductosResponseDto vendedor;

}

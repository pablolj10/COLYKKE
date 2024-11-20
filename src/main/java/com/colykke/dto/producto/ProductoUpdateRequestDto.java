package com.colykke.dto.producto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductoUpdateRequestDto {

	private String nombre;
	private String descripcion;
	private String color;
	private float precio;
	private String imagen;
	
}

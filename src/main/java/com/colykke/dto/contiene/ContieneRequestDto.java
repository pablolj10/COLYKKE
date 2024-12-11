package com.colykke.dto.contiene;

import com.colykke.dto.producto.ProductoConIdRequestDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContieneRequestDto {
	
	private long productoId;
	
	private int cantidad;
}
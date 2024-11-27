package com.colykke.dto.contiene;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContieneRequestDto {

	private int pedidoId;
	
	private int productoId;
	
	private int cantidad;
}
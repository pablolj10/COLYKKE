package com.colykke.dto.contiene;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContieneRequestDto {

	private Long pedidoId;
	
	private Long productoId;
	
	private int cantidad;
}
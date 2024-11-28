package com.colykke.dto.pedido;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PedidoRequestDto {
	
	private String fechaRealizado;
	
	private String direccion;

	private int clienteId;
}
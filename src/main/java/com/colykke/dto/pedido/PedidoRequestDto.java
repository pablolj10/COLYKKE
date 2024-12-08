package com.colykke.dto.pedido;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PedidoRequestDto {
		
	private String direccion;

	private int clienteId;
}
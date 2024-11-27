package com.colykke.dto.pedido;

import com.colykke.entity.Cliente;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PedidoRequestDto {
	
	private String direccion;

	// private List<Contiene> contiene;

	private Cliente cliente;
}
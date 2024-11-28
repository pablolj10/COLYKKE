package com.colykke.dto.pedido;

import java.util.List;

import com.colykke.dto.cliente.ClienteResponseDto;
import com.colykke.dto.cliente.ClienteSinPedidosResponseDto;
import com.colykke.dto.contiene.ContieneResponseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PedidoResponseDto {
	
	private String fechaRealizado;
	
	private String direccion;
	
	private ClienteSinPedidosResponseDto cliente;
	
}
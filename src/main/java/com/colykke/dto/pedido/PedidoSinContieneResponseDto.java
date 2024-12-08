package com.colykke.dto.pedido;

import java.util.Date;

import com.colykke.dto.cliente.ClienteSinPedidosResponseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PedidoSinContieneResponseDto {

	private long id;
	
	private Date fechaRealizado;
	
	private String direccion;
	
	private ClienteSinPedidosResponseDto cliente;
}

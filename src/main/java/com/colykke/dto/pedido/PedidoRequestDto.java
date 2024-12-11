package com.colykke.dto.pedido;

import java.util.List;

import com.colykke.dto.contiene.ContieneRequestDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PedidoRequestDto {
		
	private String direccion;

	private long clienteId;
	
	private List<ContieneRequestDto> contiene;
}
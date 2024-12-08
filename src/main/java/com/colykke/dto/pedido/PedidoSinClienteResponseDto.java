package com.colykke.dto.pedido;

import java.util.Date;
import java.util.List;

import com.colykke.dto.contiene.ContieneResponseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PedidoSinClienteResponseDto {

	private long id;
	
	private Date fechaRealizado;
	
	private String direccion;

	private List<ContieneResponseDto> contiene;
	
}

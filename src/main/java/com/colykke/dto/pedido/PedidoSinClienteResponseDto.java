package com.colykke.dto.pedido;

import java.time.LocalDateTime;
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

	private Long id;
	
	private Date fechaRealizado;
	
	private LocalDateTime horaReserva;
	
	private List<ContieneResponseDto> contiene;
	
}

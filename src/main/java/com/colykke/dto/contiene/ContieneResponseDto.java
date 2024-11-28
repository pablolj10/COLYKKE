package com.colykke.dto.contiene;

import com.colykke.dto.pedido.PedidoResponseDto;
import com.colykke.dto.pedido.PedidoSinContieneResponseDto;
import com.colykke.dto.producto.ProductoResponseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContieneResponseDto {

	private PedidoSinContieneResponseDto pedido;
	
	private ProductoResponseDto producto;
	
	private int cantidad;
}
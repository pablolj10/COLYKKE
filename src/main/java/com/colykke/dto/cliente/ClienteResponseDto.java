package com.colykke.dto.cliente;

import java.util.List;

import com.colykke.dto.pedido.PedidoSinClienteResponseDto;
import com.colykke.dto.usuario.UsuarioResponseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClienteResponseDto {

	private long id;
	private String nombre;
	
	private UsuarioResponseDto usuario;

	private List<PedidoSinClienteResponseDto> pedidos;
	
}

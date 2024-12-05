package com.colykke.dto.cliente;

import java.util.List;

import com.colykke.dto.pedido.PedidoResponseDto;
import com.colykke.dto.pedido.PedidoSinClienteResponseDto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClienteResponseDto {

	private long id;
	private String nombre;
	@Column(name="correo_electronico")
	private String correoElectronico;
	private String contrasenia;

	private List<PedidoSinClienteResponseDto> pedidos;
	
}

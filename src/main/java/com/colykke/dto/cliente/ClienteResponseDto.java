package com.colykke.dto.cliente;

import java.util.List;

import com.colykke.entity.Pedido;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClienteResponseDto {

	private String nombre;
	private int telefono;
	@Column(name="correo_electronico")
	private String correoElectronico;
	private String contrasenia;

	private List<Pedido> pedidos;
	
}

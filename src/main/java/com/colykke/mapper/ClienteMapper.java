package com.colykke.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.colykke.dto.cliente.ClienteRequestDto;
import com.colykke.dto.cliente.ClienteResponseDto;
import com.colykke.dto.cliente.ClienteSinPedidosResponseDto;
import com.colykke.entity.Cliente;

@Mapper(componentModel="spring")
public interface ClienteMapper {

	public ClienteResponseDto mapToClienteDto(Cliente cliente);

	public List<ClienteResponseDto> mapToClienteDto(List<Cliente> clientes);
	
	public Cliente mapClienteRequestDtoToCliente(ClienteRequestDto clienteDto);
	
	public Cliente mapToCliente(Long id, ClienteRequestDto clienteDto);
	
	public ClienteResponseDto mapClienteRequestDtoToClienteResponseDto(ClienteRequestDto clienteDto);
	
	public ClienteSinPedidosResponseDto mapToClienteSPDto(Cliente cliente);
	
	public List<ClienteSinPedidosResponseDto> mapToClienteSPDto(List<Cliente> clientes);
}

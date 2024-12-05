package com.colykke.service;

import java.util.List;

import com.colykke.dto.cliente.ClienteRequestDto;
import com.colykke.dto.cliente.ClienteResponseDto;
import com.colykke.dto.cliente.ClienteSinPedidosResponseDto;

public interface ClienteService {

	ClienteResponseDto findById(Long id);

	List<ClienteResponseDto> findAll();
	
	ClienteSinPedidosResponseDto add(ClienteRequestDto dto);
	
	ClienteSinPedidosResponseDto update(Long id, ClienteRequestDto dto);
	
	void delete(Long id);
	
}

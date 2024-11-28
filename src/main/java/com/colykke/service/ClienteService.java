package com.colykke.service;

import java.util.List;

import com.colykke.dto.cliente.ClienteRequestDto;
import com.colykke.dto.cliente.ClienteResponseDto;
import com.colykke.dto.cliente.ClienteSinPedidosResponseDto;

public interface ClienteService {

	ClienteSinPedidosResponseDto findById(Long id);

	List<ClienteSinPedidosResponseDto> findAll();
	
	ClienteResponseDto add(ClienteRequestDto dto);
	
	ClienteResponseDto update(Long id, ClienteRequestDto dto);
	
	void delete(Long id);
	
}

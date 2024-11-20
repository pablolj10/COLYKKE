package com.colykke.service;

import java.util.List;

import com.colykke.dto.cliente.ClienteRequestDto;
import com.colykke.dto.cliente.ClienteResponseDto;

public interface ClienteService {

	ClienteResponseDto findById(Long id);

	List<ClienteResponseDto> findAll();
	
	ClienteResponseDto add(ClienteRequestDto dto);
	
	ClienteResponseDto update(Long id, ClienteRequestDto dto);
	
	void delete(Long id);
	
}

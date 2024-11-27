package com.colykke.service;

import java.util.List;

import com.colykke.dto.pedido.PedidoRequestDto;
import com.colykke.dto.pedido.PedidoResponseDto;

public interface PedidoService {

	PedidoResponseDto findById(Long id);

	List<PedidoResponseDto> findAll();
	
	PedidoResponseDto add(PedidoRequestDto dto);

	PedidoResponseDto update(Long id, PedidoRequestDto dto);

	void delete(Long id);
}
package com.colykke.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colykke.dto.pedido.PedidoRequestDto;
import com.colykke.dto.pedido.PedidoResponseDto;
import com.colykke.entity.Pedido;
import com.colykke.mapper.PedidoMapper;
import com.colykke.repository.PedidoRepository;
import com.colykke.service.PedidoService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PedidoServiceImpl implements PedidoService {

	@Autowired PedidoRepository pedidoRepository;

	@Autowired PedidoMapper pedidoMapper;

	@Override
	public PedidoResponseDto findById(Long id) {
		
		Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

		if (pedidoOptional.isEmpty()) {
			log.error("No existe un pedido con el id: " + id);
			throw new IllegalArgumentException("No existe un pedido con ese id");
		}
		return pedidoMapper.mapToPedidoDto(pedidoOptional.get());
	}

	@Override
	public List<PedidoResponseDto> findAll() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		return pedidoMapper.mapToPedidoDto(pedidos);
	}

	

	@Override
	public PedidoResponseDto add(PedidoRequestDto dto) {
		pedidoRepository.save(pedidoMapper.mapPedidoRequestDtoToPedido(dto));
		return pedidoMapper.mapPedidoRequestDtoToPedidoResponseDto(dto);
	}

	@Override
	public PedidoResponseDto update(Long id, PedidoRequestDto dto) {
		Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

		if (pedidoOptional.isPresent()) {
			Pedido pedido = pedidoMapper.mapToPedido(id, dto);

			pedidoRepository.save(pedido);

			return pedidoMapper.mapPedidoRequestDtoToPedidoResponseDto(dto);
		}
		log.error("No existe un pedido con el id: " + id);
		throw new IllegalArgumentException("No existe un pedido con ese id");
	}

	@Override
	public void delete(Long id) {
		if (!pedidoRepository.findById(id).isPresent()) {
			log.error("No existe un pedido con el id: " + id);
			throw new IllegalArgumentException("No existe un pedido con ese id");
		}
		pedidoRepository.deleteById(id);
	}

}
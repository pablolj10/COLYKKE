package com.colykke.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colykke.dto.cliente.ClienteRequestDto;
import com.colykke.dto.cliente.ClienteResponseDto;
import com.colykke.dto.cliente.ClienteSinPedidosResponseDto;
import com.colykke.entity.Cliente;
import com.colykke.mapper.ClienteMapper;
import com.colykke.repository.ClienteRepository;
import com.colykke.service.ClienteService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClienteServiceImpl implements ClienteService {

	@Autowired ClienteRepository clienteRepository;
	@Autowired ClienteMapper clienteMapper;

	@Override
	public ClienteSinPedidosResponseDto findById(Long id) {
		
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);

		if (clienteOptional.isEmpty()) {
			log.error("No existe un cliente con el id: " + id);
			throw new IllegalArgumentException("No existe un cliente con ese id");
		}
		return clienteMapper.mapToClienteSPDto(clienteOptional.get());
	}

	@Override
	public List<ClienteSinPedidosResponseDto> findAll() {
		List<Cliente> clientes = clienteRepository.findAll();
		return clienteMapper.mapToClienteSPDto(clientes);
	}

	

	@Override
	public ClienteResponseDto add(ClienteRequestDto dto) {
		clienteRepository.save(clienteMapper.mapClienteRequestDtoToCliente(dto));
		return clienteMapper.mapClienteRequestDtoToClienteResponseDto(dto);
	}

	@Override
	public ClienteResponseDto update(Long id, ClienteRequestDto dto) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);

		if (clienteOptional.isPresent()) {
			Cliente cliente = clienteMapper.mapToCliente(id, dto);

			clienteRepository.save(cliente);

			return clienteMapper.mapClienteRequestDtoToClienteResponseDto(dto);
		}
		log.error("No existe un cliente con el id: " + id);
		throw new IllegalArgumentException("No existe un cliente con ese id");
	}

	@Override
	public void delete(Long id) {
		if (!clienteRepository.findById(id).isPresent()) {
			log.error("No existe un cliente con el id: " + id);
			throw new IllegalArgumentException("No existe un cliente con ese id");
		}
		clienteRepository.deleteById(id);
	}
	
}

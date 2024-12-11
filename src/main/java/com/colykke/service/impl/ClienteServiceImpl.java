package com.colykke.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colykke.dto.cliente.ClienteRequestDto;
import com.colykke.dto.cliente.ClienteResponseDto;
import com.colykke.dto.cliente.ClienteSinPedidosResponseDto;
import com.colykke.entity.Cliente;
import com.colykke.entity.Usuario;
import com.colykke.mapper.ClienteMapper;
import com.colykke.repository.ClienteRepository;
import com.colykke.repository.UsuarioRepository;
import com.colykke.service.ClienteService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClienteServiceImpl implements ClienteService {

	@Autowired ClienteRepository clienteRepository;
	@Autowired ClienteMapper clienteMapper;
	@Autowired UsuarioRepository usuarioRepository;
	
	@Override
	public ClienteResponseDto findById(Long id) {
		
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);

		if (clienteOptional.isEmpty()) {
			log.error("No existe un cliente con el id: " + id);
			throw new IllegalArgumentException("No existe un cliente con ese id");
		}
		return clienteMapper.mapToClienteDto(clienteOptional.get());
	}

	@Override
	public List<ClienteResponseDto> findAll() {
		List<Cliente> clientes = clienteRepository.findAll();
		return clienteMapper.mapToClienteDto(clientes);
	}

	

	@Override
	public ClienteSinPedidosResponseDto add(ClienteRequestDto dto) {
		Usuario usuario = usuarioRepository.findById(dto.getUsuarioId()).get();
		if(usuario == null) {
			throw new IllegalArgumentException("El usuario no se encuentra en la base de datos");
		}
		Cliente cliente = new Cliente();
		cliente.setNombre(dto.getNombre());
		//cliente.setTelefono();
		cliente.setUsuario(usuario);
		clienteRepository.save(cliente);
		return clienteMapper.mapToClienteSinPedidosDto(cliente);
	}

	@Override
	public ClienteSinPedidosResponseDto update(Long id, ClienteRequestDto dto) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);

		if (clienteOptional.isPresent()) {
			Cliente cliente = clienteMapper.mapToCliente(id, dto);
			Usuario usuario = usuarioRepository.findById(dto.getUsuarioId()).get();
			if(usuario == null) {
				throw new IllegalArgumentException("El usuario no se encuentra en la base de datos");
			}
			cliente.setNombre(dto.getNombre());
			//cliente.setTelefono();
			cliente.setUsuario(usuario);
			clienteRepository.save(cliente);

			return clienteMapper.mapToClienteSinPedidosDto(cliente);
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

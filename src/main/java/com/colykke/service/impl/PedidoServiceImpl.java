package com.colykke.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colykke.dto.contiene.ContieneRequestDto;
import com.colykke.dto.pedido.PedidoRequestDto;
import com.colykke.dto.pedido.PedidoResponseDto;
import com.colykke.entity.Cliente;
import com.colykke.entity.Contiene;
import com.colykke.entity.Pedido;
import com.colykke.entity.Producto;
import com.colykke.mapper.ClienteMapper;
import com.colykke.mapper.PedidoMapper;
import com.colykke.repository.ClienteRepository;
import com.colykke.repository.PedidoRepository;
import com.colykke.repository.ProductoRepository;
import com.colykke.service.PedidoService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PedidoServiceImpl implements PedidoService {

	@Autowired PedidoRepository pedidoRepository;

	@Autowired PedidoMapper pedidoMapper;
	
	@Autowired ProductoRepository productoRepository;
	
	@Autowired ClienteRepository clienteRepository;

	@Autowired ClienteMapper clienteMapper;
	
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
	public List<PedidoResponseDto> findAllByOrderByFechaRealizadoAsc() {
		List<Pedido> pedidos = pedidoRepository.findAllByOrderByFechaRealizadoAsc();
		return pedidoMapper.mapToPedidoDto(pedidos);
	}
	
	@Override
	public List<PedidoResponseDto> findAllByOrderByFechaRealizadoDesc() {
		List<Pedido> pedidos = pedidoRepository.findAllByOrderByFechaRealizadoDesc();
		return pedidoMapper.mapToPedidoDto(pedidos);
	}

	@Override
	public List<PedidoResponseDto> findByClienteUsuarioEmail(String email) {
		List<Pedido> pedidos = pedidoRepository.findByClienteUsuarioEmail(email);
		return pedidoMapper.mapToPedidoDto(pedidos);
	}
	
	@Override
	public List<PedidoResponseDto> findDistinctByContieneProductoId(Long idProducto) {
		List<Pedido> pedidos = pedidoRepository.findDistinctByContieneProductoId(idProducto);
		return pedidoMapper.mapToPedidoDto(pedidos);
	}
	
	@Override
	public PedidoResponseDto add(PedidoRequestDto dto) {
		
		Pedido pedido = new Pedido();
	        
        Optional<Cliente> cliente = clienteRepository.findById((long) dto.getClienteId());
        
        pedido.setCliente(cliente.get());

        pedidoRepository.save(pedido);
        
        PedidoResponseDto response = pedidoMapper.mapPedidoRequestDtoToPedidoResponseDto(dto);
        
        response.setCliente(clienteMapper.mapToClienteSPDto(cliente.get()));
        
        return response;

	}

	@Override
	public PedidoResponseDto update(Long id, PedidoRequestDto dto) {
		
		Pedido pedido = pedidoRepository.findById(id).get();

		Optional<Cliente> cliente = clienteRepository.findById((long) dto.getClienteId());
        
        pedido.setCliente(cliente.get());
        
        for(Contiene c: pedido.getContiene()) {
        	c.setPedido(null);
        }
        pedido.setContiene(null);

        pedidoRepository.save(pedido);
        
        PedidoResponseDto response = pedidoMapper.mapPedidoRequestDtoToPedidoResponseDto(dto);
        
        response.setCliente(clienteMapper.mapToClienteSPDto(cliente.get()));
        
        return response;
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
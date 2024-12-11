package com.colykke.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colykke.dto.contiene.ContieneRequestDto;
import com.colykke.dto.contiene.ContieneResponseDto;
import com.colykke.entity.Contiene;
import com.colykke.entity.Pedido;
import com.colykke.entity.Producto;
import com.colykke.mapper.ContieneMapper;
import com.colykke.repository.ContieneRepository;
import com.colykke.repository.PedidoRepository;
import com.colykke.repository.ProductoRepository;
import com.colykke.service.ContieneService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContieneServiceImpl implements ContieneService {

	@Autowired	ContieneRepository contieneRepository;

	@Autowired ContieneMapper contieneMapper;
	
	@Autowired PedidoRepository pedidoRepository;
	
	@Autowired ProductoRepository productoRepository;

	@Override
	public ContieneResponseDto findById(Long id) {
		Optional<Contiene> contieneOptional = contieneRepository.findById(id);

		if (contieneOptional.isEmpty()) {
			log.error("No existe un contiene con el id: " + id);
			throw new IllegalArgumentException("No existe un contiene con ese id");
		}
		return contieneMapper.mapToContieneDto(contieneOptional.get());
	}

	@Override
	public List<ContieneResponseDto> findAll() {
		List<Contiene> contienes = contieneRepository.findAll();
		return contieneMapper.mapToContieneDto(contienes);
	}

	
//	@Override
//	public ContieneResponseDto add(ContieneRequestDto dto) {
//		Optional<Pedido> pedido = pedidoRepository.findById(dto.getPedidoId());
//		Optional<Producto> producto = productoRepository.findById(dto.getProductoId());
//		
//		if(producto.isEmpty()|| pedido.isEmpty()) {
//			throw new IllegalArgumentException("El pedido o el producto no existen");
//		}
//		Contiene contiene = new Contiene();
//		contiene.setPedido(pedido.get());
//		contiene.setProducto(producto.get());
//		contiene.setCantidad(dto.getCantidad());
//		return contieneMapper.mapToContieneDto(contiene);
//	}
//
//	@Override
//	public ContieneResponseDto update(Long id, ContieneRequestDto dto) {
//		Optional<Contiene> contieneOptional = contieneRepository.findById(id);
//
//		if (contieneOptional.isPresent()) {
//			Contiene contiene = contieneMapper.mapToContiene(id, dto);
//
//			contieneRepository.save(contiene);
//
//			return contieneMapper.mapContieneRequestDtoToContieneResponseDto(dto);
//		}
//		log.error("No existe un contiene con el id: " + id);
//		throw new IllegalArgumentException("No existe un contiene con ese id");
//	}

	@Override
	public void delete(Long id) {
		if (!contieneRepository.findById(id).isPresent()) {
			log.error("No existe un contiene con el id: " + id);
			throw new IllegalArgumentException("No existe un contiene con ese id");
		}
		contieneRepository.deleteById(id);
	}

}
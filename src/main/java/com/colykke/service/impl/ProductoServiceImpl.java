package com.colykke.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colykke.dto.producto.ProductoRequestDto;
import com.colykke.dto.producto.ProductoResponseDto;
import com.colykke.dto.producto.ProductoUpdateRequestDto;
import com.colykke.dto.vendedor.VendedorNombreResponseDto;
import com.colykke.entity.Producto;
import com.colykke.entity.Vendedor;
import com.colykke.mapper.ProductoMapper;
import com.colykke.mapper.VendedorMapper;
import com.colykke.repository.ProductoRepository;
import com.colykke.repository.VendedorRepository;
import com.colykke.service.ProductoService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired ProductoRepository productoRepository;
	@Autowired VendedorRepository vendedorRepository;
	@Autowired ProductoMapper productoMapper;
	@Autowired VendedorMapper vendedorMapper;
	
	@Override
	public ProductoResponseDto findById(Long id) {
		Optional<Producto> productoOptional = productoRepository.findById(id);
		if (productoOptional.isEmpty()) {
			log.error("No existe un producto con el id:" + id);
			throw new IllegalArgumentException("No existe un producto con ese id");
		}
		ProductoResponseDto productoDto = productoMapper.mapToProductoResponseDto(productoOptional.get());
		VendedorNombreResponseDto vendedorDto = vendedorMapper.mapVendedorToVendedorNombreResponseDto(productoOptional.get().getVendedor());
		productoDto.setVendedorNombre(vendedorDto);
		return productoDto;
	}
	
	@Override
	public List<ProductoResponseDto> findAll() {
		List<Producto> productos = productoRepository.findAll();
		List<ProductoResponseDto> productosDto = productoMapper.mapToProductoDto(productos);
		int i =0;
		for(ProductoResponseDto p: productosDto) {
			VendedorNombreResponseDto vendedorDto = vendedorMapper.mapVendedorToVendedorNombreResponseDto(productos.get(i).getVendedor());
			p.setVendedorNombre(vendedorDto);
			i++;
		}
		return productosDto;
	}

	

	@Override
	public ProductoResponseDto add(ProductoRequestDto dto) {
		Producto producto = productoMapper.mapProductoRequestDtoToProducto(dto);
		Long id = (long) dto.getIdVendedor();
		Optional<Vendedor> vendedor = vendedorRepository.findById(id);
		producto.setVendedor(vendedor.get());
		productoRepository.save(producto);
		return productoMapper.mapProductoRequestDtoToProductoResponseDto(dto);
	}

	@Override
	public ProductoResponseDto update(Long id, ProductoUpdateRequestDto dto) {
		Optional<Producto> productoOptional = productoRepository.findById(id);

		if (productoOptional.isPresent()) {
			Producto producto = productoMapper.mapToProducto(id, dto);

			productoRepository.save(producto);
			
			return productoMapper.mapToProductoResponseDto(productoRepository.findById(id).get());
		}
		log.error("No existe un producto con el id: " + id);
		throw new IllegalArgumentException("No existe un producto con ese id");
	}

	@Override
	public void delete(Long id) {
		if (!productoRepository.findById(id).isPresent()) {
			log.error("No existe un producto con el id: " + id);
			throw new IllegalArgumentException("No existe un producto con ese id");
		}
		productoRepository.deleteById(id);
	}

	@Override
	public List<ProductoResponseDto> findAllByOrderByPrecioAsc() {
		
		return productoMapper.mapToProductoDto(productoRepository.findAllByOrderByPrecioAsc());
	}

	@Override
	public List<ProductoResponseDto> findAllByOrderByPrecioDesc() {
		return productoMapper.mapToProductoDto(productoRepository.findAllByOrderByPrecioDesc());
	}

	
	
}

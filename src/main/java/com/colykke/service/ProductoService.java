package com.colykke.service;

import java.util.List;

import com.colykke.dto.producto.ProductoRequestDto;
import com.colykke.dto.producto.ProductoResponseDto;
import com.colykke.dto.producto.ProductoUpdateRequestDto;

public interface ProductoService {

	ProductoResponseDto findById(Long id);

	List<ProductoResponseDto> findAll();
	
	public List<ProductoResponseDto> findAllByOrderByPrecioAsc();
	
	public List<ProductoResponseDto> findAllByOrderByPrecioDesc();
		
	ProductoResponseDto add(ProductoRequestDto dto);

	ProductoResponseDto update(Long id, ProductoUpdateRequestDto dto);

	void delete(Long id);
	
	
}

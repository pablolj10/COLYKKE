package com.colykke.service;

import java.util.List;

import com.colykke.dto.vendedor.VendedorRequestDto;
import com.colykke.dto.vendedor.VendedorResponseDto;

public interface VendedorService {


	
	VendedorResponseDto findById(Long id);

	List<VendedorResponseDto> findAll();
	
	VendedorResponseDto add(VendedorRequestDto dto);

	VendedorResponseDto update(Long id, VendedorRequestDto dto);

	void delete(Long id);
	
}

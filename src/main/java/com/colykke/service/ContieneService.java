package com.colykke.service;

import java.util.List;

import com.colykke.dto.contiene.ContieneRequestDto;
import com.colykke.dto.contiene.ContieneResponseDto;

public interface ContieneService {

	ContieneResponseDto findById(Long id);

	List<ContieneResponseDto> findAll();
	
	ContieneResponseDto add(ContieneRequestDto dto);

	ContieneResponseDto update(Long id, ContieneRequestDto dto);

	
	void delete(Long id);
}
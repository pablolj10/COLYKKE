package com.colykke.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.colykke.dto.contiene.ContieneRequestDto;
import com.colykke.dto.contiene.ContieneResponseDto;
import com.colykke.entity.Contiene;

@Mapper(componentModel="spring")
public interface ContieneMapper {

	public ContieneResponseDto mapToContieneDto(Contiene contiene);

	public List<ContieneResponseDto> mapToContieneDto(List<Contiene> contienes);
	
	public Contiene mapContieneRequestDtoToContiene(ContieneRequestDto contieneDto);
	
	public Contiene mapToContiene(Long id, ContieneRequestDto contieneDto);
	
	public ContieneResponseDto mapContieneRequestDtoToContieneResponseDto(ContieneRequestDto contieneDto);
	
	
}
package com.colykke.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.colykke.dto.vendedor.VendedorRequestDto;
import com.colykke.dto.vendedor.VendedorResponseDto;
import com.colykke.entity.Vendedor;

@Mapper(componentModel="spring")
public interface VendedorMapper {

	public VendedorResponseDto mapToVendedorDto(Vendedor vendedor);

	public List<VendedorResponseDto> mapToVendedorDto(List<Vendedor> vendedores);
	
	public Vendedor mapVendedorRequestDtoToVendedor(VendedorRequestDto vendedorDto);
	
	public Vendedor mapToVendedor(Long id, VendedorRequestDto vendedorDto);
	
	public VendedorResponseDto mapVendedorRequestDtoToVendedorResponseDto(VendedorRequestDto vendedorDto);
	
}

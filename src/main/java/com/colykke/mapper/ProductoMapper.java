package com.colykke.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.colykke.dto.producto.ProductoRequestDto;
import com.colykke.dto.producto.ProductoResponseDto;
import com.colykke.dto.producto.ProductoUpdateRequestDto;
import com.colykke.entity.Producto;
import com.colykke.entity.Vendedor;

@Mapper(componentModel="spring")
public interface ProductoMapper {

    ProductoResponseDto mapToProductoResponseDto(Producto producto);
	
	public List<ProductoResponseDto> mapToProductoDto(List<Producto> productos);
	
	public Producto mapProductoRequestDtoToProducto(ProductoRequestDto productoDto);
	
	public Producto mapToProducto(Long id, ProductoUpdateRequestDto productoDto);
	
	public ProductoResponseDto mapProductoRequestDtoToProductoResponseDto(ProductoRequestDto productoDto);
	
	public ProductoResponseDto mapProductoUpdateRequestDtoToProductoResponseDto(ProductoRequestDto productoDto);
	
}

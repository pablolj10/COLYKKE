package com.colykke.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.colykke.dto.pedido.PedidoRequestDto;
import com.colykke.dto.pedido.PedidoResponseDto;
import com.colykke.entity.Pedido;

@Mapper(componentModel="spring")
public interface PedidoMapper {

	public PedidoResponseDto mapToPedidoDto(Pedido pedido);

	public List<PedidoResponseDto> mapToPedidoDto(List<Pedido> pedidos);
	
	public Pedido mapPedidoRequestDtoToPedido(PedidoRequestDto pedidoDto);
	
	public Pedido mapToPedido(Long id, PedidoRequestDto pedidoDto);
	
	public PedidoResponseDto mapPedidoRequestDtoToPedidoResponseDto(PedidoRequestDto pedidoDto);
}

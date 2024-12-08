package com.colykke.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.colykke.dto.usuario.UsuarioRequestDto;
import com.colykke.dto.usuario.UsuarioResponseDto;
import com.colykke.entity.Usuario;

@Mapper(componentModel="spring")
public interface UsuarioMapper {

	public UsuarioResponseDto mapToUsuarioDto(Usuario usuario);

	public List<UsuarioResponseDto> mapToUsuarioDto(List<Usuario> usuarios);
	
	public Usuario mapUsuarioRequestDtoToUsuario(UsuarioRequestDto usuarioDto);
	
	public Usuario mapToUsuario(Long id, UsuarioRequestDto usuarioDto);
	
	public UsuarioResponseDto mapUsuarioRequestDtoToUsuarioResponseDto(UsuarioRequestDto usuarioDto);
}

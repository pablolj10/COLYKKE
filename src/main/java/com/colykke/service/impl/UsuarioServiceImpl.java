package com.colykke.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.colykke.dto.usuario.UsuarioRequestDto;
import com.colykke.dto.usuario.UsuarioResponseDto;
import com.colykke.entity.Usuario;
import com.colykke.mapper.UsuarioMapper;
import com.colykke.repository.ClienteRepository;
import com.colykke.repository.UsuarioRepository;
import com.colykke.service.UsuarioService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	UsuarioMapper usuarioMapper;

	@Autowired
	ClienteRepository clienteRepository;
	
	 @Autowired
	 PasswordEncoder bcryptPasswordEncoder;
	
	@Override
	public UsuarioResponseDto findById(Long id) {
		
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

		if (usuarioOptional.isEmpty()) {
			log.error("No existe un usuario con ese id, id: " + id);
			throw new IllegalArgumentException("No existe un usuario con ese id");
		}
		return usuarioMapper.mapToUsuarioDto(usuarioOptional.get());
	}

	@Override
	public List<UsuarioResponseDto> findAll() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarioMapper.mapToUsuarioDto(usuarios);
	}
	
	@Override
	public List<UsuarioResponseDto> findByClienteIsNull() {
		List<Usuario> usuarios = usuarioRepository.findByClienteIsNull();
		return usuarioMapper.mapToUsuarioDto(usuarios);
	}

	@Override
	public UsuarioResponseDto add(UsuarioRequestDto dto) {
		dto.setPassword(bcryptPasswordEncoder.encode(dto.getPassword()));
		usuarioRepository.save(usuarioMapper.mapUsuarioRequestDtoToUsuario(dto));
		return usuarioMapper.mapUsuarioRequestDtoToUsuarioResponseDto(dto);
	}

	@Override
	public UsuarioResponseDto update(Long id, UsuarioRequestDto dto) {
		dto.setPassword(bcryptPasswordEncoder.encode(dto.getPassword()));
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

		if (usuarioOptional.isPresent()) {
			Usuario usuario = usuarioMapper.mapToUsuario(id, dto);

			usuarioRepository.save(usuario);

			return usuarioMapper.mapUsuarioRequestDtoToUsuarioResponseDto(dto);
		}
		log.error("No existe un usuario con ese id, id: " + id);
		throw new IllegalArgumentException("No existe un usuario con ese id");
	}

	@Override
	public void delete(Long id) {
		if (!usuarioRepository.findById(id).isPresent()) {
			log.error("No existe un usuario con ese id, id: " + id);
			throw new IllegalArgumentException("No existe un usuario con ese id");
		}
		clienteRepository.deleteById(clienteRepository.findByUsuarioId(id).getId());
		
	}
}

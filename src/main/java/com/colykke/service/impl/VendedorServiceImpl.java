package com.colykke.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colykke.dto.cliente.ClienteRequestDto;
import com.colykke.dto.cliente.ClienteSinPedidosResponseDto;
import com.colykke.dto.vendedor.VendedorRequestDto;
import com.colykke.dto.vendedor.VendedorResponseDto;
import com.colykke.entity.Cliente;
import com.colykke.entity.Usuario;
import com.colykke.entity.Vendedor;
import com.colykke.mapper.VendedorMapper;
import com.colykke.repository.UsuarioRepository;
import com.colykke.repository.VendedorRepository;
import com.colykke.service.VendedorService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VendedorServiceImpl implements VendedorService {


	@Autowired VendedorRepository vendedorRepository;

	@Autowired VendedorMapper vendedorMapper;

	@Autowired UsuarioRepository usuarioRepository;
	
	@Override
	public VendedorResponseDto findById(Long id) {
		Optional<Vendedor> vendedorOptional = vendedorRepository.findById(id);

		if (vendedorOptional.isEmpty()) {
			log.error("No existe un vendedor con el id: " + id);
			throw new IllegalArgumentException("No existe un vendedor con ese id");
		}
		return vendedorMapper.mapToVendedorDto(vendedorOptional.get());
	}

	@Override
	public List<VendedorResponseDto> findAll() {
		List<Vendedor> vendedores = vendedorRepository.findAll();
		return vendedorMapper.mapToVendedorDto(vendedores);
	}


	@Override
	public VendedorResponseDto add(VendedorRequestDto dto) {
		Usuario usuario = usuarioRepository.findById(dto.getUsuarioId()).get();
		if(usuario == null) {
			throw new IllegalArgumentException("El usuario no se encuentra en la base de datos");
		}
		
		Vendedor vendedor = new Vendedor();
		vendedor.setNombre(dto.getNombre());
		vendedor.setInfo(dto.getInfo());
		vendedor.setLogo(dto.getLogo());
		vendedor.setTelefono(vendedor.getTelefono());
		vendedor.setUsuario(usuario);
		vendedorRepository.save(vendedor);
		return vendedorMapper.mapToVendedorDto(vendedor);
	}

	@Override
	public VendedorResponseDto update(Long id, VendedorRequestDto dto) {
		Optional<Vendedor> vendedorOptional = vendedorRepository.findById(id);

		if (vendedorOptional.isPresent()) {
			Vendedor vendedor = vendedorMapper.mapToVendedor(id, dto);
			Usuario usuario = usuarioRepository.findById(dto.getUsuarioId()).get();
			if(usuario == null) {
				throw new IllegalArgumentException("El usuario no se encuentra en la base de datos");
			}
			vendedor.setNombre(dto.getNombre());
			vendedor.setInfo(dto.getInfo());
			vendedor.setLogo(dto.getLogo());
			vendedor.setTelefono(vendedor.getTelefono());
			vendedor.setUsuario(usuario);
			vendedorRepository.save(vendedor);

			return vendedorMapper.mapToVendedorDto(vendedor);
		}
		log.error("No existe un vendedor con el id: " + id);
		throw new IllegalArgumentException("No existe un vendedor con ese id");
	}

	@Override
	public void delete(Long id) {
		if (!vendedorRepository.findById(id).isPresent()) {
			log.error("No existe un vendedor con el id: " + id);
			throw new IllegalArgumentException("No existe un vendedor con ese id");
		}
		vendedorRepository.deleteById(id);
	}
	
}

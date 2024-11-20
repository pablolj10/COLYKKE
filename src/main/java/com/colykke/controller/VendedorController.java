package com.colykke.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colykke.dto.ApiResponse;
import com.colykke.dto.vendedor.VendedorRequestDto;
import com.colykke.dto.vendedor.VendedorResponseDto;
import com.colykke.service.VendedorService;
import com.colykke.util.ResponseUtil;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/vendedor")
@Slf4j
public class VendedorController {

	
	@Autowired
    private VendedorService vendedorService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<VendedorResponseDto>> findById(@PathVariable Long id) {
        log.info("Peticion para mostrar el vendedor con id: " + id);
        return ResponseUtil.response(vendedorService.findById(id), HttpStatus.OK, "Mostrando el vendedor");
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<VendedorResponseDto>>> findAll() {
        log.info("Petición para mostrar todos los vendedores");
        return ResponseUtil.response(vendedorService.findAll(), HttpStatus.OK, "Mostrando todos los vendedores");
    }

    @PostMapping
    public ResponseEntity<ApiResponse<VendedorResponseDto>> add(@RequestBody VendedorRequestDto dto) {
        log.info("Petición para añadir un vendedor");
        return ResponseUtil.response(vendedorService.add(dto), HttpStatus.CREATED, "Vendedor creado con exito");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<VendedorResponseDto>> update(@PathVariable Long id, @RequestBody VendedorRequestDto dto) {
        log.info("Petición para actualizar un vendedor con el id: " + id);
        return ResponseUtil.response(vendedorService.update(id, dto), HttpStatus.OK, "Vendedor actualizado con exito");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> delete(@PathVariable Long id) {
        log.info("Peticion para eliminar un vendedor con el id: " + id);
        vendedorService.delete(id);
        return ResponseUtil.response(null, HttpStatus.NO_CONTENT, "Vendedor eliminado con exito");
    }
	
}

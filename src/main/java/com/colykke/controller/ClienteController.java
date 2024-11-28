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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colykke.dto.ApiResponse;
import com.colykke.dto.cliente.ClienteRequestDto;
import com.colykke.dto.cliente.ClienteResponseDto;
import com.colykke.dto.cliente.ClienteSinPedidosResponseDto;
import com.colykke.service.ClienteService;
import com.colykke.util.ResponseUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/cliente")
@Slf4j
public class ClienteController {


	@Autowired private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ClienteSinPedidosResponseDto>> findById(@PathVariable Long id) {
        log.info("Peticion para mostrar el cliente con id " + id);
        return ResponseUtil.response(clienteService.findById(id), HttpStatus.OK, "Mostrando el cliente");
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ClienteSinPedidosResponseDto>>> findAll() {
        log.info("Peticion para mostrar todos los clientes");
        return ResponseUtil.response(clienteService.findAll(), HttpStatus.OK, "Mostrando todos los clientes");
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ClienteResponseDto>> add(@RequestBody ClienteRequestDto dto) {
        log.info("Peticion para añadir un cliente");
        return ResponseUtil.response(clienteService.add(dto), HttpStatus.CREATED, "Cliente creado con exito");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ClienteResponseDto>> update(@PathVariable Long id, @RequestBody ClienteRequestDto dto) {
        log.info("Peticion para actualizar un cliente con el id " + id);
        return ResponseUtil.response(clienteService.update(id, dto), HttpStatus.OK, "Cliente actualizado con exito");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> delete(@PathVariable Long id) {
        log.info("Peticion para eliminar un cliente con el id " + id);
        clienteService.delete(id);
        return ResponseUtil.response(null, HttpStatus.NO_CONTENT, "Cliente eliminado con exito");
    }
	
}

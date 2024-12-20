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
import com.colykke.dto.pedido.PedidoRequestDto;
import com.colykke.dto.pedido.PedidoResponseDto;
import com.colykke.service.PedidoService;
import com.colykke.util.ResponseUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/pedido")
@Slf4j
public class PedidoController {

	@Autowired private PedidoService service;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PedidoResponseDto>> findById(@PathVariable Long id) {
        log.info("Peticion para mostrar el pedido con id " + id);
        return ResponseUtil.response(service.findById(id), HttpStatus.OK, "Mostrando el pedido");
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<PedidoResponseDto>>> findAll() {
        log.info("Peticion para mostrar todos los pedidos");
        return ResponseUtil.response(service.findAll(), HttpStatus.OK, "Mostrando todos los pedidos");
    }
    
    @GetMapping("/usuario/{email}")
    public ResponseEntity<ApiResponse<List<PedidoResponseDto>>> findByClienteUsuarioEmail(@PathVariable String email) {
        log.info("Peticion para mostrar los pedidos del usuario con el email " + email);
        return ResponseUtil.response(service.findByClienteUsuarioEmail(email), HttpStatus.ACCEPTED, "Mostrando v");
    }
    
    @GetMapping("/producto/{idProducto}")
    public ResponseEntity<ApiResponse<List<PedidoResponseDto>>> findDistinctByContieneProductoId(@PathVariable Long idProducto) {
        log.info("Peticion para mostrar los pedidos que contengan el plato con id " + idProducto);
        return ResponseUtil.response(service.findDistinctByContieneProductoId(idProducto), HttpStatus.ACCEPTED, "Mostrando los pedidos");
    }
    
    @GetMapping("/fecha/asc")
    public ResponseEntity<ApiResponse<List<PedidoResponseDto>>> findAllByOrderByFechaRealizadoAsc() {
        log.info("Petición para mostrar todos los pedidos ordenados por fecha de manera ascendente");
        return ResponseUtil.response(service.findAllByOrderByFechaRealizadoAsc(), HttpStatus.ACCEPTED, "Mostrando todos los pedidos ordenados por fecha de manera ascendente");
    }
    
    @GetMapping("/fecha/desc")
    public ResponseEntity<ApiResponse<List<PedidoResponseDto>>> findAllByOrderByFechaRealizadoDesc() {
        log.info("Petición para mostrar todos los pedidos");
        return ResponseUtil.response(service.findAllByOrderByFechaRealizadoDesc(), HttpStatus.ACCEPTED, "Mostrando todos los pedidos ordenados por fecha de manera descendente");
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<PedidoResponseDto>> add(@RequestBody PedidoRequestDto pedidoDto) {
        log.info("PeticiOn para añadir un pedido");
        return ResponseUtil.response(service.add(pedidoDto), HttpStatus.OK, "Pedido creado con exito");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PedidoResponseDto>> update(@PathVariable Long id, @RequestBody PedidoRequestDto pedidoDto) {
        log.info("Peticion para actualizar un pedido con el id " + id);
        return ResponseUtil.response(service.update(id, pedidoDto), HttpStatus.OK, "Pedido actualizado con exito");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> delete(@PathVariable Long id) {
        log.info("Peticion para eliminar un pedido con el id " + id);
        service.delete(id);
        return ResponseUtil.response(null, HttpStatus.NO_CONTENT, "Pedido eliminado con exito");
    }
}
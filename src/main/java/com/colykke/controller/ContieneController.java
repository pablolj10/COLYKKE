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
import com.colykke.dto.contiene.ContieneRequestDto;
import com.colykke.dto.contiene.ContieneResponseDto;
import com.colykke.service.ContieneService;
import com.colykke.util.ResponseUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/contiene")
@Slf4j
public class ContieneController {

	@Autowired private ContieneService service;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ContieneResponseDto>> findById(@PathVariable Long id) {
        log.info("Peticion para mostrar el contiene con id " + id);
        return ResponseUtil.response(service.findById(id), HttpStatus.OK, "Mostrando la reseña de contiene");
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<ContieneResponseDto>>> findAll() {
        log.info("Peticion para mostrar todos los contiene");
        return ResponseUtil.response(service.findAll(), HttpStatus.OK, "Mostrando todos los contiene");
    }

//    @GetMapping("/fechaSubida/asc")
//    public ResponseEntity<ApiResponse<List<ContieneResponseDto>>> findAllOrderByFechaPublicacionAsc() {
//        log.info("Petición para mostrar todos los contiene ordenados por fecha de publicacion en orden ascendente");
//        return ResponseUtil.response(service.findAllByOrderByFechaPublicacionAsc(), HttpStatus.OK, "Mostrando todos los contiene ordenadas por fecha de publicacion en orden ascendente");
//    }
//
//    @Operation(summary = "Buscar todas las reseñas de productos ordenadas.", description = "Buscar todas las reseñas de productos de la base de datos ordenadas por su fecha de publicacion de forma descendente", tags = {"contiene", "get"})
//    @GetMapping("/fechaSubida/desc")
//    public ResponseEntity<ApiResponse<List<ContieneResponseDto>>> findAllOrderByFechaPublicacionDesc() {
//        log.info("Petición para mostrar todos los usuario_producto (resenias) ordenados por fecha de publicacion en orden descendente");
//        return ResponseUtil.response(service.findAllByOrderByFechaPublicacionDesc(), HttpStatus.ACCEPTED, "Mostrando todas las reseñas de productos ordenadas por fecha de publicacion en orden descendente");
//    }

//    @PostMapping()
//    public ResponseEntity<ApiResponse<ContieneResponseDto>> add(@RequestBody ContieneRequestDto contieneRequestDto) {
//        log.info("Peticion para añadir un contiene");
//        return ResponseUtil.response(service.add(contieneRequestDto), HttpStatus.OK, "Contiene creado con exito");
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<ApiResponse<ContieneResponseDto>> update(@PathVariable Long id,
//                                                                           @RequestBody ContieneRequestDto cafeteriaDto) {
//        log.info("Peticion para actualizar un contiene con el id" + id);
//        return ResponseUtil.response(service.update(id, cafeteriaDto), HttpStatus.OK, "Contiene actualizado con exito");
//    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> delete(@PathVariable Long id) {
        log.info("Peticion para eliminar un contiene con el id" + id);
        service.delete(id);
        return ResponseUtil.response(null, HttpStatus.NO_CONTENT, "Contiene eliminado con exito");
    }
}
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
import com.colykke.dto.producto.ProductoRequestDto;
import com.colykke.dto.producto.ProductoResponseDto;
import com.colykke.dto.producto.ProductoUpdateRequestDto;
import com.colykke.service.ProductoService;
import com.colykke.util.ResponseUtil;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/producto")
@Slf4j
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<ProductoResponseDto>> findById(@PathVariable Long id) {
		log.info("Peticion para mostrar el producto con id: " + id);
		return ResponseUtil.response(productoService.findById(id), HttpStatus.OK, "Mostrando el producto");
	}


    @GetMapping()
    public ResponseEntity<ApiResponse<List<ProductoResponseDto>>> findAll() {
        log.info("Petición para mostrar todos los productos");
        return ResponseUtil.response(productoService.findAll(), HttpStatus.OK, "Mostrando todos los productos");
    }

    @GetMapping("/asc")
    public ResponseEntity<ApiResponse<List<ProductoResponseDto>>> findAllByOrderByPrecioAsc() {
        log.info("Petición para mostrar todos los productos ordenados por precio de manera ascendente");
        return ResponseUtil.response(productoService.findAllByOrderByPrecioAsc(), HttpStatus.OK, "Mostrando todos los productos ordenados por precio de forma ascendente");
    }

    @GetMapping("/desc")
    public ResponseEntity<ApiResponse<List<ProductoResponseDto>>> findAllByOrderByPrecioDesc() {
        log.info("Petición para mostrar todos los productos ordenados por precio de manera descendente");
        return ResponseUtil.response(productoService.findAllByOrderByPrecioDesc(), HttpStatus.OK, "Mostrando todos los productos ordenados por precio de forma descendente");
    }

//    @Operation(summary = "Buscar los platos por categoria", description = "Buscar todos los platos de la base de datos pertenencientes a la categoria introducida.", tags = {"plato", "get"})
//    @GetMapping("categoria/{categoria}")
//    public ResponseEntity<ApiResponse<List<PlatoResponseDto>>> findPlatosByCategoria(@PathVariable Long categoria) {
//        log.info("Petición para mostrar los platos ordenados por la categoria " + categoria);
//        return ResponseUtil.response(service.findPlatosByCategoria(categoria), HttpStatus.ACCEPTED, "Mostrando los platos ordenados por la categoria " + categoria);
//    }

    @PostMapping()
    public ResponseEntity<ApiResponse<ProductoResponseDto>> add(@Valid @RequestBody ProductoRequestDto productoDto) {
        log.info("Petición para añadir un producto");
        return ResponseUtil.response(productoService.add(productoDto), HttpStatus.CREATED, "Producto creado con exito");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductoResponseDto>> update(@Valid @PathVariable Long id, @RequestBody ProductoUpdateRequestDto productoDto) {
        log.info("Petición para actualizar un producto con el id: " + id);
        return ResponseUtil.response(productoService.update(id, productoDto), HttpStatus.OK, "Producto actualizado con exito");
    }

	    
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<Object>> delete(@PathVariable Long id) {
	    log.info("Petición para eliminar un producto con el id: " + id);
	    productoService.delete(id);
	    return ResponseUtil.response(null, HttpStatus.NO_CONTENT, "Producto eliminado con exito");
	}
	
	
	
	
}



// dicu89_N
// 



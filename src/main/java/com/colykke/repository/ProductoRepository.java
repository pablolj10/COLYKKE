package com.colykke.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.colykke.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

//	@Query("SELECT p FROM Producto p WHERE p.color = :color")
//	List<Producto> findPlatosByCategoria(@Param("categoria") Categoria categoria);
	
	List<Producto> findAllByOrderByPrecioAsc();
	
	List<Producto> findAllByOrderByPrecioDesc();
	
}

package com.colykke.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.colykke.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

//List<Cliente> findAllByOrderByCountByPedidosAsc();
	
	 @Query("SELECT c FROM Cliente c LEFT JOIN c.pedidos p GROUP BY c.id ORDER BY COUNT(p) DESC")
	List<Cliente> findAllByOrderByCountByPedidosDesc();

	
}

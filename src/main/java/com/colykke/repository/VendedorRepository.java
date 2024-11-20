package com.colykke.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.colykke.entity.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    @Query("SELECT v FROM Vendedor v LEFT JOIN v.productos p GROUP BY v.id ORDER BY COUNT(p) ASC")
    List<Vendedor> findAllOrderByProductosCountAsc();

    @Query("SELECT v FROM Vendedor v LEFT JOIN v.productos p GROUP BY v.id ORDER BY COUNT(p) DESC")
    List<Vendedor> findAllOrderByProductosCountDesc();
}

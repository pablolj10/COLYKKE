package com.colykke.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Vendedor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	private String logo;
	private int telefono;
	private String info;

	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;
	
	@OneToMany(targetEntity=Producto.class,mappedBy="vendedor",cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Producto> productos;	
	
}

package com.colykke.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Producto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	private String descripcion;
	private String color;
	private float precio;
	private String imagen;
	
	@OneToMany(mappedBy="producto", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Contiene> contiene;
	
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="FK_VENDEDOR")
	private Vendedor vendedor;
	
}

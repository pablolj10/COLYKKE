package com.colykke.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	private int telefono;
	@Column(name="correo_electronico")
	private String correoElectronico;
	private String contrasenia;

	@OneToMany(targetEntity=Pedido.class,mappedBy="cliente",cascade = CascadeType.ALL)
	private List<Pedido> pedidos;
	
}

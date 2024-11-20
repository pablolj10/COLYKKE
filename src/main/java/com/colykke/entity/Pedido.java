package com.colykke.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String horaRealizado;
	
	
//	@OneToMany(mappedBy="pedido", cascade=CascadeType.ALL)
//	@JsonManagedReference
//	private List<Contiene> contiene;
	
	@ManyToOne
	@JoinColumn(name="FK_CLIENTE")
	private Cliente cliente;
	
}

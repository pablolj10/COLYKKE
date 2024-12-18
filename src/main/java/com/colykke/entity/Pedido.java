package com.colykke.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Pedido {

	
	public Pedido() {
		this.fechaRealizado = Calendar.getInstance().getTime();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="fecha_realizado")
	@Temporal(TemporalType.DATE)
	private Date fechaRealizado;
	
	private String direccion;
	
	
	@OneToMany(mappedBy="pedido", cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Contiene> contiene;
	
	@ManyToOne
	@JoinColumn(name="FK_CLIENTE")
	@JsonBackReference
	private Cliente cliente;
	
}

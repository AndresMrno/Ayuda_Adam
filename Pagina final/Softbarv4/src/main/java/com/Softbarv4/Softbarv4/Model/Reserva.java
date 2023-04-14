package com.Softbarv4.Softbarv4.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "reservas")

public class Reserva implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_reserva;

	@Column(name = "numero_personas", length = 2)
	private int numero_personas;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name ="hora")
	private String hora;
	
	@Column(name ="Estado")
	private String Estado;

	@OneToOne
	@JoinColumn(name = "id_cancha")
	private Cancha id_cancha;

	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario id_usuario;

	public Reserva() {
	}
	
	
	public Reserva(Long id_reserva, int numero_personas, Date fecha, String hora, String estado, Cancha id_cancha,
			Usuario id_usuario) {
		super();
		this.id_reserva = id_reserva;
		this.numero_personas = numero_personas;
		this.fecha = fecha;
		this.hora = hora;
		this.Estado = estado;
		this.id_cancha = id_cancha;
		this.id_usuario = id_usuario;
	}


	public Long getId_reserva() {
		return id_reserva;
	}


	public void setId_reserva(Long id_reserva) {
		this.id_reserva = id_reserva;
	}


	public int getNumero_personas() {
		return numero_personas;
	}


	public void setNumero_personas(int numero_personas) {
		this.numero_personas = numero_personas;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public String getEstado() {
		return Estado;
	}


	public void setEstado(String estado) {
		Estado = estado;
	}


	public Cancha getId_cancha() {
		return id_cancha;
	}


	public void setId_cancha(Cancha id_cancha) {
		this.id_cancha = id_cancha;
	}


	public Usuario getId_usuario() {
		return id_usuario;
	}


	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}
}

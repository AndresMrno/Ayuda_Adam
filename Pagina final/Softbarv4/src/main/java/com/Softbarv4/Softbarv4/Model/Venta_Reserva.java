package com.Softbarv4.Softbarv4.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="venta_Reservas")

public class Venta_Reserva implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_venta_reserva;
	
	@Column(name="valor_total")
	private int valor_total;
	
	@OneToOne
	@JoinColumn(name = "id_reserva")
	private Reserva id_reserva;
	
	@OneToOne
	@JoinColumn(name="id_forma_pago")
	private Forma_Pago id_forma_pago;

	public Venta_Reserva() {

	}

	

	public Venta_Reserva(int valor_total, Reserva id_reserva, Forma_Pago id_forma_pago) {
		super();
		this.valor_total = valor_total;
		this.id_reserva = id_reserva;
		this.id_forma_pago = id_forma_pago;
	}



	public Long getId_venta_reserva() {
		return id_venta_reserva;
	}



	public void setId_venta_reserva(Long id_venta_reserva) {
		this.id_venta_reserva = id_venta_reserva;
	}



	public int getValor_total() {
		return valor_total;
	}



	public void setValor_total(int valor_total) {
		this.valor_total = valor_total;
	}



	public Reserva getId_reserva() {
		return id_reserva;
	}



	public void setId_reserva(Reserva id_reserva) {
		this.id_reserva = id_reserva;
	}



	public Forma_Pago getId_forma_pago() {
		return id_forma_pago;
	}



	public void setId_forma_pago(Forma_Pago id_forma_pago) {
		this.id_forma_pago = id_forma_pago;
	}
}
	

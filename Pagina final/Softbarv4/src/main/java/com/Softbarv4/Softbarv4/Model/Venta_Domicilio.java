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
@Table(name = "venta_domicilios")

public class Venta_Domicilio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_venta_domicilio;

	@Column(name = "valor_total")
	private int valor_total;

	@OneToOne
	@JoinColumn(name = "id_domicilio_fk")
	private Domicilio id_domicilio_fk;

	@OneToOne
	@JoinColumn(name="id_forma_pago")
	private Forma_Pago id_forma_pago;

	public Venta_Domicilio() {
	}

	

	public Venta_Domicilio(int valor_total, Domicilio id_domicilio_fk, Forma_Pago id_forma_pago) {
		super();
		this.valor_total = valor_total;
		this.id_domicilio_fk = id_domicilio_fk;
		this.id_forma_pago = id_forma_pago;
	}



	public Long getId_venta_domicilio() {
		return id_venta_domicilio;
	}



	public void setId_venta_domicilio(Long id_venta_domicilio) {
		this.id_venta_domicilio = id_venta_domicilio;
	}



	public int getValor_total() {
		return valor_total;
	}



	public void setValor_total(int valor_total) {
		this.valor_total = valor_total;
	}



	public Domicilio getId_domicilio_fk() {
		return id_domicilio_fk;
	}



	public void setId_domicilio_fk(Domicilio id_domicilio_fk) {
		this.id_domicilio_fk = id_domicilio_fk;
	}



	public Forma_Pago getId_forma_pago() {
		return id_forma_pago;
	}



	public void setId_forma_pago(Forma_Pago id_forma_pago) {
		this.id_forma_pago = id_forma_pago;
	}
}

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
@Table(name = "usuarios")

public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;

	@Column(name = "identificacion", length = 11)
	private String identificacion;

	@Column(name = "nombre", length = 20)
	private String nombre;

	@Column(name = "apellido", length = 20)
	private String apellido;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha_nacimiento")
	private Date fecha_nacimiento;

	@Column(name = "edad")
	private int edad;

	@Column(name = "correo", length = 50)
	private String correo;

	@Column(name = "contrasena")
	private String contrasena;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "direccion", length = 100)
	private String direccion;

	@OneToOne
	@JoinColumn(name = "id_rol")
	private Rol id_rol;

	public Usuario() {
	}
	
	

	public Usuario(String identificacion, String nombre, String apellido, Date fecha_nacimiento, int edad,
			String correo, String contrasena, String telefono, String direccion, Rol id_rol) {
		super();
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.edad = edad;
		this.correo = correo;
		this.contrasena = contrasena;
		this.telefono = telefono;
		this.direccion = direccion;
		this.id_rol = id_rol;
	}



	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Rol getId_rol() {
		return id_rol;
	}

	public void setId_rol(Rol id_rol) {
		this.id_rol = id_rol;
	}

	
}

package com.Softbarv4.Softbarv4.Model;

public class JwtRequest {
	
	private String correo;
	private String contrasena;
	
	public JwtRequest() {

	}
	
	public JwtRequest(String correo, String contrasena) {
		this.correo = correo;
		this.contrasena = contrasena;
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
	
}

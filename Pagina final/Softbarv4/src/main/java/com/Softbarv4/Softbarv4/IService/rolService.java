package com.Softbarv4.Softbarv4.IService;

import java.util.List;

import com.Softbarv4.Softbarv4.Model.Rol;

public interface rolService {
	
	public List<Rol> listarRol();
	
	public Rol guardarRol(Rol rol);
	
	public Rol rolPorId(int id_rol);
	
	public Rol actualizarRol(Rol rol);
	
	public void eliminarRol(int id_rol);
	

}

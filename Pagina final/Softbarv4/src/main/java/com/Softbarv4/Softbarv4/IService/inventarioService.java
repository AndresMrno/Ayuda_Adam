package com.Softbarv4.Softbarv4.IService;

import java.util.List;

import com.Softbarv4.Softbarv4.Model.Inventario;

public interface inventarioService {
	
	public List<Inventario> listarInventario();
	
	public Inventario guardarInventario(Inventario inventario);
	
	public Inventario inventarioPorId(Long id_inventario);
	
	public Inventario actualizarInventario(Inventario inventario);
	
	public void eliminarInventario(Long id_inventario);

}

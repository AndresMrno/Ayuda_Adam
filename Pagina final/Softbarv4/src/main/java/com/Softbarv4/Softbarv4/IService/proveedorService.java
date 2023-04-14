package com.Softbarv4.Softbarv4.IService;

import java.util.List;

import com.Softbarv4.Softbarv4.Model.Proveedor;

public interface proveedorService {
	
	public List<Proveedor> listarProveedor();
	
	public Proveedor guardarProveedor(Proveedor proveedor);
	
	public Proveedor proveedorPorId(Long id_proveedor);
	
	public Proveedor actualizarProveedor(Proveedor proveedor);
	
	public void eliminarProveedor(Long id_proveedor);

}

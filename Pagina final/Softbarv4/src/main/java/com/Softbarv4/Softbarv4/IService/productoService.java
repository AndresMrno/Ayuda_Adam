package com.Softbarv4.Softbarv4.IService;

import java.util.List;
import java.util.Optional;

import com.Softbarv4.Softbarv4.Model.Producto;

public interface productoService {
	
	public List<Producto> listarProducto();
	
	public Producto guardarProducto(Producto producto);
	
	public Producto productoPorId(Long id_producto);
	
	public Producto actualizarProducto(Producto producto);
	
	public void eliminarProducto(Long id_producto);
	
	Optional<Producto> productoConSuId(Long id_producto);
	

}

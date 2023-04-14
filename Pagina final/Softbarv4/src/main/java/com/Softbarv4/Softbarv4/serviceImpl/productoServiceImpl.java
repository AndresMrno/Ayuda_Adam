package com.Softbarv4.Softbarv4.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Softbarv4.Softbarv4.IService.productoService;
import com.Softbarv4.Softbarv4.Model.Producto;
import com.Softbarv4.Softbarv4.Repository.productoRepository;

@Service
public class productoServiceImpl implements productoService {
	
	@Autowired
	private productoRepository productoRepor;

	@Override
	public List<Producto> listarProducto() {
		// TODO Auto-generated method stub
		return productoRepor.findAll();
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		// TODO Auto-generated method stub
		return productoRepor.save(producto);
	}

	@Override
	public Producto productoPorId(Long id_producto) {
		// TODO Auto-generated method stub
		return productoRepor.findById(id_producto).get();
	}

	@Override
	public Producto actualizarProducto(Producto producto) {
		// TODO Auto-generated method stub
		return productoRepor.save(producto);
	}

	@Override
	public void eliminarProducto(Long id_producto) {
		productoRepor.deleteById(id_producto);
		
	}

	public Optional<Producto> productoConSuId(Long id_producto) {
		// TODO Auto-generated method stub
		return productoRepor.findById(id_producto);
	}
	


	
	
}

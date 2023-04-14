package com.Softbarv4.Softbarv4.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Softbarv4.Softbarv4.IService.proveedorService;
import com.Softbarv4.Softbarv4.Model.Proveedor;
import com.Softbarv4.Softbarv4.Repository.proveedorRepository;

@Service
public class proveedorServiceImpl implements proveedorService {

	@Autowired
	private proveedorRepository proveedorRepor;

	@Override
	public List<Proveedor> listarProveedor() {
		// TODO Auto-generated method stub
		return proveedorRepor.findAll();
	}

	@Override
	public Proveedor guardarProveedor(Proveedor proveedor) {
		// TODO Auto-generated method stub
		return proveedorRepor.save(proveedor);
	}

	@Override
	public Proveedor proveedorPorId(Long id_proveedor) {
		// TODO Auto-generated method stub
		return proveedorRepor.findById(id_proveedor).get();
	}

	@Override
	public Proveedor actualizarProveedor(Proveedor proveedor) {
		// TODO Auto-generated method stub
		return proveedorRepor.save(proveedor);
	}

	@Override
	public void eliminarProveedor(Long id_proveedor) {
		proveedorRepor.deleteById(id_proveedor);
		
	}
	
	
}

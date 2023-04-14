package com.Softbarv4.Softbarv4.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Softbarv4.Softbarv4.IService.inventarioService;
import com.Softbarv4.Softbarv4.Model.Inventario;
import com.Softbarv4.Softbarv4.Repository.inventarioRepository;

@Service
public class inventarioServiceImpl implements inventarioService {
	
	@Autowired
	private inventarioRepository inventarioRepor;

	@Override
	public List<Inventario> listarInventario() {
		// TODO Auto-generated method stub
		return inventarioRepor.findAll();
	}

	@Override
	public Inventario guardarInventario(Inventario inventario) {
		// TODO Auto-generated method stub
		return inventarioRepor.save(inventario);
	}

	@Override
	public Inventario inventarioPorId(Long id_inventario) {
		// TODO Auto-generated method stub
		return inventarioRepor.findById(id_inventario).get();
	}

	@Override
	public Inventario actualizarInventario(Inventario inventario) {
		// TODO Auto-generated method stub
		return inventarioRepor.save(inventario);
	}

	@Override
	public void eliminarInventario(Long id_inventario) {
		inventarioRepor.deleteById(id_inventario);
		
	}
	
	
}

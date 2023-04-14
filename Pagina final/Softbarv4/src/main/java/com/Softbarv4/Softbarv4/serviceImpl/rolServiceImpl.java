package com.Softbarv4.Softbarv4.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Softbarv4.Softbarv4.IService.rolService;
import com.Softbarv4.Softbarv4.Model.Rol;
import com.Softbarv4.Softbarv4.Repository.rolRepository;

@Service
public class rolServiceImpl implements rolService {
	
	@Autowired
	private rolRepository rolRepor;

	@Override
	public List<Rol> listarRol() {
		// TODO Auto-generated method stub
		return rolRepor.findAll();
	}

	@Override
	public Rol guardarRol(Rol rol) {
		// TODO Auto-generated method stub
		return rolRepor.save(rol);
	}

	@Override
	public Rol rolPorId(int id_rol) {
		// TODO Auto-generated method stub
		return rolRepor.findById(id_rol).get();
	}

	@Override
	public Rol actualizarRol(Rol rol) {
		// TODO Auto-generated method stub
		return rolRepor.save(rol);
	}

	@Override
	public void eliminarRol(int id_rol) {
		rolRepor.deleteById(id_rol);
		
	}

	







	
	
	
}

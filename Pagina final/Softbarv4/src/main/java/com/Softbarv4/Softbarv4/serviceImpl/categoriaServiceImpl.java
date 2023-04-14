package com.Softbarv4.Softbarv4.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Softbarv4.Softbarv4.IService.categoriaService;
import com.Softbarv4.Softbarv4.Model.Categoria;
import com.Softbarv4.Softbarv4.Repository.categoriaRepository;

@Service
public class categoriaServiceImpl implements categoriaService {
	
	@Autowired
	private categoriaRepository categoriaRepor;

	@Override
	public List<Categoria> listarCategoria() {
		// TODO Auto-generated method stub
		return categoriaRepor.findAll();
	}

	@Override
	public Categoria guardarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return categoriaRepor.save(categoria);
	}

	@Override
	public Categoria categoriaPorId(Long id_categoria) {
		// TODO Auto-generated method stub
		return categoriaRepor.findById(id_categoria).get();
	}

	@Override
	public Categoria actualizarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return categoriaRepor.save(categoria);
	}

	@Override
	public void eliminarCategoria(Long id_categoria) {
		categoriaRepor.deleteById(id_categoria);
		
	}
	
	
}

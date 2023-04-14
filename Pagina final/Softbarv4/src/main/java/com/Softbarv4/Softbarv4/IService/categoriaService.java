package com.Softbarv4.Softbarv4.IService;

import java.util.List;

import com.Softbarv4.Softbarv4.Model.Categoria;

public interface categoriaService {
	
	
	public List<Categoria> listarCategoria();
	
	public Categoria guardarCategoria(Categoria categoria);
	
	public Categoria categoriaPorId(Long id_categoria);
	
	public Categoria actualizarCategoria(Categoria categoria);
	
	public void eliminarCategoria(Long id_categoria);

}

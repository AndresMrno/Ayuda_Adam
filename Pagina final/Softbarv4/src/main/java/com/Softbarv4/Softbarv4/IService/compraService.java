package com.Softbarv4.Softbarv4.IService;

import java.util.List;

import com.Softbarv4.Softbarv4.Model.Compra;

public interface compraService {
	
	public List<Compra> listarCompra();
	
	public Compra guardarCompra(Compra compra);
	
	public Compra compraPorId(Long id_compra);
	
	public Compra actualizarCompra(Compra compra);
	
	public void eliminarCompra(Long id_compra);

}

package com.Softbarv4.Softbarv4.IService;

import java.util.List;

import com.Softbarv4.Softbarv4.Model.Pedido;
import com.Softbarv4.Softbarv4.Model.Producto;

public interface pedidoService {
	
	public List<Pedido> listarPedido();
	
	public Pedido guardarPedido(Pedido pedido);
	
	public Pedido pedidoPorId(Long id_pedido);
	
	public Pedido actualizarPedido(Pedido pedido);
	
	public void eliminarPedido(Long id_pedido);
	

}

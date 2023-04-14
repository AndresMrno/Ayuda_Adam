package com.Softbarv4.Softbarv4.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Softbarv4.Softbarv4.IService.pedidoService;
import com.Softbarv4.Softbarv4.Model.Pedido;
import com.Softbarv4.Softbarv4.Repository.pedidoRepository;

@Service
public class pedidoServiceImpl implements pedidoService {
	
	@Autowired
	private pedidoRepository pedidoRepor;

	@Override
	public List<Pedido> listarPedido() {
		// TODO Auto-generated method stub
		return pedidoRepor.findAll();
	}

	@Override
	public Pedido guardarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		return pedidoRepor.save(pedido);
	}

	@Override
	public Pedido pedidoPorId(Long id_pedido) {
		// TODO Auto-generated method stub
		return pedidoRepor.findById(id_pedido).get();
	}

	@Override
	public Pedido actualizarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		return pedidoRepor.save(pedido);
	}

	@Override
	public void eliminarPedido(Long id_pedido) {
		pedidoRepor.deleteById(id_pedido);
		
	}
	
	
}

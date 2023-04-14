package com.Softbarv4.Softbarv4.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Softbarv4.Softbarv4.IService.compraService;
import com.Softbarv4.Softbarv4.Model.Compra;
import com.Softbarv4.Softbarv4.Repository.compraRepository;

@Service
public class compraServiceImpl implements compraService {

	@Autowired
	private compraRepository compraRepor;

	@Override
	public List<Compra> listarCompra() {
		// TODO Auto-generated method stub
		return compraRepor.findAll();
	}

	@Override
	public Compra guardarCompra(Compra compra) {
		// TODO Auto-generated method stub
		return compraRepor.save(compra);
	}

	@Override
	public Compra compraPorId(Long id_compra) {
		// TODO Auto-generated method stub
		return compraRepor.findById(id_compra).get();
	}

	@Override
	public Compra actualizarCompra(Compra compra) {
		// TODO Auto-generated method stub
		return compraRepor.save(compra);
	}

	@Override
	public void eliminarCompra(Long id_compra) {
		compraRepor.deleteById(id_compra);
		
	}
	
	
}

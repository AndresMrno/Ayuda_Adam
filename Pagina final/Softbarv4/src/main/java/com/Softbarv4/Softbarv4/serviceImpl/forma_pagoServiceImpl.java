package com.Softbarv4.Softbarv4.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Softbarv4.Softbarv4.IService.Forma_PagoService;
import com.Softbarv4.Softbarv4.Model.Forma_Pago;
import com.Softbarv4.Softbarv4.Repository.forma_pagoRepository;

@Service
public class forma_pagoServiceImpl implements Forma_PagoService {

	@Autowired
	private forma_pagoRepository forma_pagoRepor;

	@Override
	public List<Forma_Pago> listarForma() {
		// TODO Auto-generated method stub
		return forma_pagoRepor.findAll();
	}

	@Override
	public Forma_Pago guardarForma(Forma_Pago forma_pago) {
		// TODO Auto-generated method stub
		return forma_pagoRepor.save(forma_pago);
	}

	@Override
	public Forma_Pago formaPorId(Long id_forma_pago) {
		// TODO Auto-generated method stub
		return forma_pagoRepor.findById(id_forma_pago).get();
	}

	@Override
	public Forma_Pago actualizarForma(Forma_Pago forma_pago) {
		// TODO Auto-generated method stub
		return forma_pagoRepor.save(forma_pago);
	}

	@Override
	public void eliminarForma(Long id_forma_pago) {
		forma_pagoRepor.deleteById(id_forma_pago);
		
	}
	
	
}

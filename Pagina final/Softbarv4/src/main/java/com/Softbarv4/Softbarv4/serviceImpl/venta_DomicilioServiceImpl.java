package com.Softbarv4.Softbarv4.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Softbarv4.Softbarv4.IService.venta_DomicilioService;
import com.Softbarv4.Softbarv4.Model.Venta_Domicilio;
import com.Softbarv4.Softbarv4.Repository.venta_DomicilioRepository;

@Service
public class venta_DomicilioServiceImpl implements venta_DomicilioService {
	
	@Autowired
	private venta_DomicilioRepository venta_DomicilioRepor;

	@Override
	public List<Venta_Domicilio> listarDomicilio() {
		// TODO Auto-generated method stub
		return venta_DomicilioRepor.findAll();
	}

	@Override
	public Venta_Domicilio guardarVenta(Venta_Domicilio venta_domicilio) {
		// TODO Auto-generated method stub
		return venta_DomicilioRepor.save(venta_domicilio);
	}

	@Override
	public Venta_Domicilio ventaPorId(Long id_venta_domicilio) {
		// TODO Auto-generated method stub
		return venta_DomicilioRepor.findById(id_venta_domicilio).get();
	}

	@Override
	public Venta_Domicilio actualizarVenta(Venta_Domicilio venta_domicilio) {
		// TODO Auto-generated method stub
		return venta_DomicilioRepor.save(venta_domicilio);
	}

	@Override
	public void eliminarVenta(Long id_venta_domicilio) {
		venta_DomicilioRepor.deleteById(id_venta_domicilio);
		
	}
	
	
}

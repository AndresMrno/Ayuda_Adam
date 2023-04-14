package com.Softbarv4.Softbarv4.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Softbarv4.Softbarv4.IService.domicilioService;
import com.Softbarv4.Softbarv4.Model.Domicilio;
import com.Softbarv4.Softbarv4.Repository.domicilioRepository;

@Service
public class domicilioServiceImpl implements domicilioService {
	
	@Autowired
	private domicilioRepository domicilioRepor;

	@Override
	public List<Domicilio> listarDomicilio() {
		// TODO Auto-generated method stub
		return domicilioRepor.findAll();
	}

	@Override
	public Domicilio guardarDomicilio(Domicilio domicilio) {
		// TODO Auto-generated method stub
		return domicilioRepor.save(domicilio);
	}

	@Override
	public Domicilio domicilioPorId(Long id_domicilio) {
		// TODO Auto-generated method stub
		return domicilioRepor.findById(id_domicilio).get();
	}

	@Override
	public Domicilio actualizarDomicilio(Domicilio domicilio) {
		// TODO Auto-generated method stub
		return domicilioRepor.save(domicilio);
	}

	@Override
	public void eliminarDomicilio(Long id_domicilio) {
		domicilioRepor.deleteById(id_domicilio);
		
	}

	@Override
	public Domicilio cancelarDomicilio(Domicilio domicilio) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

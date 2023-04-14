package com.Softbarv4.Softbarv4.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Softbarv4.Softbarv4.IService.canchaService;
import com.Softbarv4.Softbarv4.Model.Cancha;
import com.Softbarv4.Softbarv4.Repository.canchaRepository;

@Service
public class canchaServiceImpl implements canchaService {

	
	@Autowired
	private canchaRepository canchaRepor;

	@Override
	public List<Cancha> listarCancha() {
		// TODO Auto-generated method stub
		return canchaRepor.findAll();
	}

	@Override
	public Cancha guardarCancha(Cancha cancha) {
		// TODO Auto-generated method stub
		return canchaRepor.save(cancha);
	}

	@Override
	public Cancha canchaPorId(Long id_cancha) {
		// TODO Auto-generated method stub
		return canchaRepor.findById(id_cancha).get();
	}

	@Override
	public Cancha actualizarCancha(Cancha cancha) {
		// TODO Auto-generated method stub
		return canchaRepor.save(cancha);
	}

	@Override
	public void eliminarCancha(Long id_cancha) {
		canchaRepor.deleteById(id_cancha);
		
	}
	
	
}

package com.Softbarv4.Softbarv4.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Softbarv4.Softbarv4.IService.reservaService;
import com.Softbarv4.Softbarv4.Model.Reserva;
import com.Softbarv4.Softbarv4.Repository.reservaRepository;

@Service
public class reservaServiceImpl implements reservaService {
	
	@Autowired
	private reservaRepository reservaRepor;

	@Override
	public List<Reserva> listarReserva() {
		// TODO Auto-generated method stub
		return reservaRepor.findAll();
	}

	@Override
	public Reserva guardarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		return reservaRepor.save(reserva);
	}

	@Override
	public Reserva reservaPorId(Long id_reserva) {
		// TODO Auto-generated method stub
		return reservaRepor.findById(id_reserva).get();
	}

	@Override
	public Reserva actualizarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		return reservaRepor.save(reserva);
	}

	@Override
	public void eliminarReserva(Long id_reserva) {
		reservaRepor.deleteById(id_reserva);
		
	}
	
	
}

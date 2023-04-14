package com.Softbarv4.Softbarv4.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Softbarv4.Softbarv4.IService.venta_ReservaService;
import com.Softbarv4.Softbarv4.Model.Venta_Reserva;
import com.Softbarv4.Softbarv4.Repository.venta_ReservaRepository;

@Service
public class venta_ReservaServiceImpl implements venta_ReservaService {
	
	@Autowired
	private venta_ReservaRepository venta_ReservaRepor;

	@Override
	public List<Venta_Reserva> listarVenta() {
		// TODO Auto-generated method stub
		return venta_ReservaRepor.findAll();
	}

	@Override
	public Venta_Reserva guardarVenta(Venta_Reserva venta_reserva) {
		// TODO Auto-generated method stub
		return venta_ReservaRepor.save(venta_reserva);
	}

	@Override
	public Venta_Reserva ventaPorId(Long id_venta_reserva) {
		// TODO Auto-generated method stub
		return venta_ReservaRepor.findById(id_venta_reserva).get();
	}

	@Override
	public Venta_Reserva actualizarVenta(Venta_Reserva venta_reserva) {
		// TODO Auto-generated method stub
		return venta_ReservaRepor.save(venta_reserva);
	}

	@Override
	public void eliminarVenta(Long id_venta_reserva) {
		venta_ReservaRepor.deleteById(id_venta_reserva);
		
	}
	
	
}

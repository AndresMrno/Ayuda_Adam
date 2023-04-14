package com.Softbarv4.Softbarv4.IService;

import java.util.List;

import com.Softbarv4.Softbarv4.Model.Reserva;

public interface reservaService {
	
	public List<Reserva> listarReserva();
	
	public Reserva guardarReserva(Reserva reserva);
	
	public Reserva reservaPorId(Long id_reserva);
	
	public Reserva actualizarReserva(Reserva reserva);
	
	public void eliminarReserva(Long id_reserva);

}

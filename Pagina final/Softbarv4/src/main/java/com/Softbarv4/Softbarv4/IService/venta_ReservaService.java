package com.Softbarv4.Softbarv4.IService;

import java.util.List;

import com.Softbarv4.Softbarv4.Model.Venta_Reserva;

public interface venta_ReservaService {

	public List<Venta_Reserva> listarVenta();
	
	public Venta_Reserva guardarVenta(Venta_Reserva venta_reserva);
	
	public Venta_Reserva ventaPorId(Long id_venta_reserva);
	
	public Venta_Reserva actualizarVenta(Venta_Reserva venta_reserva);
	
	public void eliminarVenta(Long id_venta_reserva);
}

package com.Softbarv4.Softbarv4.IService;

import java.util.List;

import com.Softbarv4.Softbarv4.Model.Venta_Domicilio;

public interface venta_DomicilioService {
	
	public List<Venta_Domicilio> listarDomicilio();
	
	public Venta_Domicilio guardarVenta(Venta_Domicilio venta_domicilio);
	
	public Venta_Domicilio ventaPorId(Long id_venta_domicilio);
	
	public Venta_Domicilio actualizarVenta(Venta_Domicilio venta_domicilio);
	
	public void eliminarVenta(Long id_venta_domicilio);

}

package com.Softbarv4.Softbarv4.IService;

import java.util.List;

import com.Softbarv4.Softbarv4.Model.Forma_Pago;

public interface Forma_PagoService {

	public List<Forma_Pago> listarForma();
	
	public Forma_Pago guardarForma(Forma_Pago forma_pago);
	
	public Forma_Pago formaPorId(Long id_forma_pago);
	
	public Forma_Pago actualizarForma(Forma_Pago forma_pago);
	
	public void eliminarForma(Long id_forma_pago);
	
}

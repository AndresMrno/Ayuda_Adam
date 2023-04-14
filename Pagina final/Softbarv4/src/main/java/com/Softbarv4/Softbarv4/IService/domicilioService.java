package com.Softbarv4.Softbarv4.IService;

import java.util.List;

import com.Softbarv4.Softbarv4.Model.Domicilio;

public interface domicilioService {
	
	public List<Domicilio> listarDomicilio();
	
	public Domicilio guardarDomicilio(Domicilio domicilio);
	
	public Domicilio domicilioPorId(Long id_domicilio);
	
	public Domicilio actualizarDomicilio(Domicilio domicilio);
	
	public Domicilio cancelarDomicilio(Domicilio domicilio);

	public void eliminarDomicilio(Long id_domicilio);
	


}

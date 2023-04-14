package com.Softbarv4.Softbarv4.IService;

import java.util.List;

import com.Softbarv4.Softbarv4.Model.Cancha;

public interface canchaService {

	public List<Cancha> listarCancha();
	
	public Cancha guardarCancha(Cancha cancha);
	
	public Cancha canchaPorId(Long id_cancha);
	
	public Cancha actualizarCancha(Cancha cancha);
	
	public void eliminarCancha(Long id_cancha);
	
}

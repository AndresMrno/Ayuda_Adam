package com.Softbarv4.Softbarv4.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Softbarv4.Softbarv4.Model.Usuario;

public interface usuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findOneByIdentificacion(String identificacion);
		
	public Usuario findByIdentificacion(String identificacion);
	
	public Usuario findByCorreo(String correo);
	
	

	




		
}

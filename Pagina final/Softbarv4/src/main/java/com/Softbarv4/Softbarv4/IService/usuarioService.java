package com.Softbarv4.Softbarv4.IService;

import java.util.List;
import java.util.Set;

import com.Softbarv4.Softbarv4.Model.Rol;
import com.Softbarv4.Softbarv4.Model.Usuario;

public interface usuarioService {
	
	public List<Usuario> listarUsuario();
	
	public Usuario registrarUsuario(Usuario usuario, Set<Rol> roles) throws Exception;
	
	public Usuario guardarUsuario(Usuario usuario) ;
	
	public Usuario usuarioPorId(Long id_usuario);
	
	public Usuario actualizarUsuario(Usuario usuario);
	
	public void eliminarUsuario(Long id_usuario);

}

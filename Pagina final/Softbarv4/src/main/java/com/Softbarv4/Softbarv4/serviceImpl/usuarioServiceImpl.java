package com.Softbarv4.Softbarv4.serviceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Softbarv4.Softbarv4.IService.usuarioService;
import com.Softbarv4.Softbarv4.Model.Rol;
import com.Softbarv4.Softbarv4.Model.Usuario;
import com.Softbarv4.Softbarv4.Repository.rolRepository;
import com.Softbarv4.Softbarv4.Repository.usuarioRepository;

@Service
public class usuarioServiceImpl implements usuarioService {
	
	@Autowired
	private usuarioRepository usuarioRepor;
	
	@Autowired
	private rolRepository rolRepor;

	@Override
	public List<Usuario> listarUsuario() {
		// TODO Auto-generated method stub
		return usuarioRepor.findAll();
	}



	@Override
	public Usuario usuarioPorId(Long id_usuario) {
		return usuarioRepor.findById(id_usuario).get();
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioRepor.save(usuario);
	}

	@Override
	public void eliminarUsuario(Long id_usuario) {
		usuarioRepor.deleteById(id_usuario);
		
	}

	@Override
	public Usuario registrarUsuario(Usuario usuario, Set<Rol> roles) throws Exception {
		Usuario usuarioLocal = usuarioRepor.findByIdentificacion(usuario.getIdentificacion());
		if(usuarioLocal !=null) {
			System.out.print("El usuario ya existe");
			throw new Exception("El usuario ya esta presente");
		}else {
			for(Rol rol: roles) {
				rolRepor.save(usuario.getId_rol());	
			}
			usuarioLocal = usuarioRepor.save(usuario);
			}
		return usuarioLocal;
	}



	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return usuarioRepor.save(usuario);
	}

}

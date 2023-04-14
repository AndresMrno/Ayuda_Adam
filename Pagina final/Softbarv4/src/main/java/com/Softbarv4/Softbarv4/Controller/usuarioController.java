package com.Softbarv4.Softbarv4.Controller;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Softbarv4.Softbarv4.IService.rolService;
import com.Softbarv4.Softbarv4.IService.usuarioService;
import com.Softbarv4.Softbarv4.Model.Rol;
import com.Softbarv4.Softbarv4.Model.Usuario;

@RestController
@RequestMapping("/usuario")
public class usuarioController {
	
	@Autowired
	private usuarioService usuarioService;
	
	@Autowired
	private rolService rolService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Usuario>> listarUsuario(){
		return new ResponseEntity<>(usuarioService.listarUsuario(),HttpStatus.OK);
	}
	
	@GetMapping("/rol")
	public ResponseEntity<List<Rol>> listarRol(){
		return new ResponseEntity<>(rolService.listarRol(),HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
		return new ResponseEntity<>(usuarioService.guardarUsuario(usuario), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id_usuario}")
	public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Long id_usuario){
		return new ResponseEntity<>(usuarioService.usuarioPorId(id_usuario), HttpStatus.OK);
	}
	
	@PutMapping("/actualizar/{id_usuario}")
	public ResponseEntity<Usuario>actualizarUsuario(@PathVariable Long id_usuario, @RequestBody Usuario usuario){
		Usuario usuarioEncontrado = usuarioService.usuarioPorId(id_usuario);
		
		if(usuarioEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		try {
			usuarioEncontrado.setIdentificacion(usuario.getIdentificacion());
			usuarioEncontrado.setNombre(usuario.getNombre());
			usuarioEncontrado.setApellido(usuario.getApellido());
			usuarioEncontrado.setFecha_nacimiento(usuario.getFecha_nacimiento());
			usuarioEncontrado.setEdad(usuario.getEdad());
			usuarioEncontrado.setCorreo(usuario.getCorreo());
			usuarioEncontrado.setContrasena(usuario.getContrasena());
			usuarioEncontrado.setTelefono(usuario.getTelefono());
			usuarioEncontrado.setDireccion(usuario.getDireccion());
			usuarioEncontrado.setId_rol(usuario.getId_rol());
			
			return new ResponseEntity<>(usuarioService.guardarUsuario(usuarioEncontrado),HttpStatus.CREATED);
		}catch(DataAccessException e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/eliminar/{id_usuario}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable Long id_usuario){
		usuarioService.eliminarUsuario(id_usuario);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/crear")
	public Usuario registrarUsuario(@RequestBody Usuario usuario) throws Exception{
		Set<Rol> roles = new HashSet<>();
		Rol rol = new Rol();
		rol.setId_rol(3);
		rol.addAll(roles);
		usuario.setId_rol(rol);
		
		return usuarioService.registrarUsuario(usuario, roles);
	}
	
	
	
	
	
	
}

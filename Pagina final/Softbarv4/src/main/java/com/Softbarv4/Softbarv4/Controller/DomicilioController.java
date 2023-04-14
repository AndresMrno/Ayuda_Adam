package com.Softbarv4.Softbarv4.Controller;

import java.util.List;

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

import com.Softbarv4.Softbarv4.IService.domicilioService;
import com.Softbarv4.Softbarv4.IService.pedidoService;
import com.Softbarv4.Softbarv4.Model.Domicilio;
import com.Softbarv4.Softbarv4.Model.Pedido;
import com.Softbarv4.Softbarv4.Model.Usuario;

@RestController
@RequestMapping("/domicilio")
public class DomicilioController {
	
	@Autowired
	private domicilioService domicilioService;
	
	@Autowired
	private pedidoService pedidoService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Domicilio>> listarDomicilio(){
		return new ResponseEntity<>(domicilioService.listarDomicilio(),HttpStatus.OK);
	}
	
	@GetMapping("/pedido")
	public ResponseEntity<List<Pedido>> listarPedido(){
		return new ResponseEntity<>(pedidoService.listarPedido(), HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<Domicilio> guardarUsuario(@RequestBody Domicilio domicilio){
		return new ResponseEntity<>(domicilioService.guardarDomicilio(domicilio), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id_domicilio}")
	public ResponseEntity<Domicilio> obtenerDomicilio(@PathVariable Long id_domicilio){
		return new ResponseEntity<>(domicilioService.domicilioPorId(id_domicilio), HttpStatus.OK);
	}
	
	@PutMapping("/actualizar/{id_domicilio}")
	public ResponseEntity<Domicilio>actualizarUsuario(@PathVariable Long id_domicilio, @RequestBody Domicilio domicilio){
		Domicilio domicilioEncontrado = domicilioService.domicilioPorId(id_domicilio);
		
		if(domicilioEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		try {
			domicilio.setFecha(domicilio.getFecha());
			domicilio.setHora(domicilio.getHora());
			domicilio.setEstado(domicilio.getEstado());
			domicilio.setId_pedido_fk(domicilio.getId_pedido_fk());
			
			return new ResponseEntity<>(domicilioService.guardarDomicilio(domicilioEncontrado), HttpStatus.CREATED);
		}catch(DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	@DeleteMapping(value="/eliminar/{id_domicilio}")
	public ResponseEntity<?> eliminarDomicilio(@PathVariable Long id_domicilio){
		Domicilio domicilio = domicilioService.domicilioPorId(id_domicilio);
		domicilio.setEstado("Cancelado");
		domicilioService.guardarDomicilio(domicilio);
		return new ResponseEntity<>(HttpStatus.OK);
	}	
}

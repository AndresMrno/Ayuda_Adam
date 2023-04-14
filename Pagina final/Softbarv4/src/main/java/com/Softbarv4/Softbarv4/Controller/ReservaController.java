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

import com.Softbarv4.Softbarv4.IService.canchaService;
import com.Softbarv4.Softbarv4.IService.reservaService;
import com.Softbarv4.Softbarv4.IService.usuarioService;
import com.Softbarv4.Softbarv4.Model.Cancha;
import com.Softbarv4.Softbarv4.Model.Reserva;
import com.Softbarv4.Softbarv4.Model.Usuario;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	private reservaService reservaService;
	
	@Autowired
	private canchaService canchaService;
	
	@Autowired
	private usuarioService usuarioService;
	
	@GetMapping("/listaReserva")
	public ResponseEntity<List<Reserva>> listarReserva(){
		return new ResponseEntity<>(reservaService.listarReserva(), HttpStatus.OK);
	}
	
	@GetMapping("/cancha")
	public ResponseEntity<List<Cancha>> listarCancha(){
		return new ResponseEntity<>(canchaService.listarCancha(), HttpStatus.OK);
	}
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> listarUsuario(){
		return new ResponseEntity<>(usuarioService.listarUsuario(), HttpStatus.OK);
	}
	
	@GetMapping("/{id_reserva}")
	public ResponseEntity<Reserva> obtenerReserva(@PathVariable Long id_reserva){
		return new ResponseEntity<>(reservaService.reservaPorId(id_reserva), HttpStatus.OK);
	}
	
	@PostMapping("/crear")
	public ResponseEntity<Reserva> guardarReserva(@RequestBody Reserva reserva){
		return new ResponseEntity<>(reservaService.guardarReserva(reserva), HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar/{id_reserva}")
	public ResponseEntity<Reserva> actualizarReserva(@PathVariable Long id_reserva, @RequestBody Reserva reserva){
		Reserva reservaEncontrada = reservaService.reservaPorId(id_reserva);
		
		if(reservaEncontrada == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
			try {
				reservaEncontrada.setNumero_personas(reserva.getNumero_personas());
				reservaEncontrada.setFecha(reserva.getFecha());
				reservaEncontrada.setHora(reserva.getHora());
				reservaEncontrada.setEstado(reserva.getEstado());
				reservaEncontrada.setId_cancha(reserva.getId_cancha());
				reservaEncontrada.setId_usuario(reserva.getId_usuario());
				
				return new ResponseEntity<>(reservaService.guardarReserva(reservaEncontrada),HttpStatus.CREATED);
			}catch(DataAccessException e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				
			
		}
	}
	
	@DeleteMapping(value="/eliminar/{id_reserva}")
	public ResponseEntity<?> eliminarReserva(@PathVariable Long id_reserva){
		Reserva reserva = reservaService.reservaPorId(id_reserva);
		reserva.setEstado("Cancelado");
		reservaService.guardarReserva(reserva);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
}

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

import com.Softbarv4.Softbarv4.IService.Forma_PagoService;
import com.Softbarv4.Softbarv4.IService.reservaService;
import com.Softbarv4.Softbarv4.IService.venta_ReservaService;
import com.Softbarv4.Softbarv4.Model.Forma_Pago;
import com.Softbarv4.Softbarv4.Model.Reserva;
import com.Softbarv4.Softbarv4.Model.Venta_Reserva;

@RestController
@RequestMapping("/ventaReserva")

public class VentaReservaController {
	
	@Autowired
	private venta_ReservaService venta_reservaService; 
	
	@Autowired
	private Forma_PagoService Forma_PagoService;
	
	@Autowired
	private reservaService reservaService ; 
	
	@GetMapping("/listar")
	public ResponseEntity<List<Venta_Reserva>>listarVentaReserva(){
		return new ResponseEntity<>(venta_reservaService.listarVenta(), HttpStatus.OK);
	}
	
	@GetMapping("/forma")
	public ResponseEntity<List<Forma_Pago>>listarFormaPago(){
		return new ResponseEntity<>(Forma_PagoService.listarForma(), HttpStatus.OK);
	}
	
	@GetMapping("/reserva")
	public ResponseEntity<List<Reserva>> listarReserva(){
		return new ResponseEntity<>(reservaService.listarReserva(), HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<Venta_Reserva>guardarVentaReserva(@RequestBody Venta_Reserva venta_reserva){
		return new ResponseEntity<>(venta_reservaService.guardarVenta(venta_reserva), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id_venta_reserva}")
	public ResponseEntity<Venta_Reserva> obtenerVenta(@PathVariable Long id_venta_reserva){
		return new ResponseEntity<>(venta_reservaService.ventaPorId(id_venta_reserva), HttpStatus.OK);
	}
	
	@PutMapping("/actualiza/{id_venta_reserva}")
	public ResponseEntity<Venta_Reserva> actualizarVenta(@PathVariable Long id_venta_reserva, @RequestBody Venta_Reserva venta_reserva){
		Venta_Reserva ventaEncontrada = venta_reservaService.ventaPorId(id_venta_reserva);
		
		if(ventaEncontrada == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		try {
			ventaEncontrada.setValor_total(venta_reserva.getValor_total());
			ventaEncontrada.setId_reserva(venta_reserva.getId_reserva());
			ventaEncontrada.setId_forma_pago(venta_reserva.getId_forma_pago());
			
			return new ResponseEntity<>(venta_reservaService.guardarVenta(ventaEncontrada), HttpStatus.CREATED);
			
			
		}catch(DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping(value="/eliminar/{id_venta_reserva}")
	public ResponseEntity<?>eliminarVena(@PathVariable Long id_venta_reserva){
		venta_reservaService.eliminarVenta(id_venta_reserva);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
}

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
import com.Softbarv4.Softbarv4.IService.domicilioService;
import com.Softbarv4.Softbarv4.IService.venta_DomicilioService;
import com.Softbarv4.Softbarv4.Model.Domicilio;
import com.Softbarv4.Softbarv4.Model.Forma_Pago;
import com.Softbarv4.Softbarv4.Model.Venta_Domicilio;

@RestController
@RequestMapping("/ventaDomicilio")
public class ventaDomicilio {
	
	
	@Autowired
	private venta_DomicilioService venta_DomicilioService;
	
	@Autowired
	private domicilioService domicilioService;
	
	@Autowired
	private Forma_PagoService forma_PagoService;
	
	
	@GetMapping("/listar")
	public ResponseEntity<List<Venta_Domicilio>> listarVentaDomicilio(){
		return new ResponseEntity<>(venta_DomicilioService.listarDomicilio(), HttpStatus.OK);
	}
	
	@GetMapping("/domicilio")
	public ResponseEntity<List<Domicilio>> listarDomicilio(){
		return new ResponseEntity<>(domicilioService.listarDomicilio(), HttpStatus.OK);
	}
	
	@GetMapping("/forma")
	public ResponseEntity<List<Forma_Pago>> listarForma(){
		return new ResponseEntity<>(forma_PagoService.listarForma(), HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<Venta_Domicilio> crearVentaDomicilio(@RequestBody Venta_Domicilio venta_domicilio){
		return new ResponseEntity<>(venta_DomicilioService.guardarVenta(venta_domicilio), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id_venta_domicilio}")
	public ResponseEntity<Venta_Domicilio> obtenerVentaDomicilio(@PathVariable Long id_venta_domicilio){
		return new ResponseEntity<>(venta_DomicilioService.ventaPorId(id_venta_domicilio), HttpStatus.OK);
	}
	
	@PutMapping("/actualizar/{}id_venta_domicilio")
	public ResponseEntity<Venta_Domicilio> actualizarVentaDomicilio(@PathVariable Long id_venta_domicilio, @RequestBody Venta_Domicilio venta_domicilio){
		Venta_Domicilio ventaDomicilioEncontrada = venta_DomicilioService.ventaPorId(id_venta_domicilio);
		
		if(ventaDomicilioEncontrada == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		try {
			ventaDomicilioEncontrada.setValor_total(venta_domicilio.getValor_total());
			ventaDomicilioEncontrada.setId_domicilio_fk(venta_domicilio.getId_domicilio_fk());
			ventaDomicilioEncontrada.setId_forma_pago(venta_domicilio.getId_forma_pago());
			
			return new ResponseEntity<>(venta_DomicilioService.guardarVenta(ventaDomicilioEncontrada), HttpStatus.CREATED);
		}catch(DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/eliminar/{id_venta_domicilio}")
	public ResponseEntity<Venta_Domicilio> eliminarDomicilio(@PathVariable Long id_venta_domicilio){
		venta_DomicilioService.eliminarVenta(id_venta_domicilio);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	

}

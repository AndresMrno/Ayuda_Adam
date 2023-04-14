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

import com.Softbarv4.Softbarv4.IService.inventarioService;
import com.Softbarv4.Softbarv4.IService.productoService;
import com.Softbarv4.Softbarv4.Model.Inventario;
import com.Softbarv4.Softbarv4.Model.Producto;

@RestController 
@RequestMapping("/inventario")
public class InventarioController {
	
	@Autowired
	private inventarioService inventarioService;
	
	@Autowired
	private productoService productoService;
	
	
	@GetMapping("/listar")
	public ResponseEntity<List<Inventario>>listarInventario(){
		return new ResponseEntity<>(inventarioService.listarInventario(), HttpStatus.OK);
	}
	
	@GetMapping("/producto")
	public ResponseEntity<List<Producto>>listarProducto(){
		return new ResponseEntity<>(productoService.listarProducto(),HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<Inventario> guardarInventario(@RequestBody Inventario inventario){
		return new ResponseEntity<>(inventarioService.guardarInventario(inventario), HttpStatus.CREATED); 
	}
	
	@GetMapping("/{id_inventario}")
	public ResponseEntity<Inventario>ObtenerInventario(@PathVariable Long id_inventario){
		return new ResponseEntity<>(inventarioService.inventarioPorId(id_inventario), HttpStatus.OK);
	}
	
	@PutMapping("/actualizar/{id_inventario}")
	public ResponseEntity<Inventario>actualizarInventario(@PathVariable Long id_inventario, @RequestBody Inventario inventario){
		Inventario inventarioEncontrado = inventarioService.inventarioPorId(id_inventario);
		
		if(inventarioEncontrado ==  null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		try {
			inventarioEncontrado.setFecha_ingreso(inventario.getFecha_ingreso());
			inventarioEncontrado.setFecha_vencimiento(inventario.getFecha_vencimiento());
			inventarioEncontrado.setCantidad_existente(inventario.getCantidad_existente());
			inventarioEncontrado.setNota(inventario.getNota());
			inventarioEncontrado.setId_producto_fk(inventario.getId_producto_fk());
			
			return new ResponseEntity<>(inventarioService.guardarInventario(inventarioEncontrado), HttpStatus.CREATED);
		}catch(DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@DeleteMapping(value="/eliminar/{id_inventario}")
	public ResponseEntity<?>eliminarInventario(@PathVariable Long id_inventario){
		Inventario inventario = inventarioService.inventarioPorId(id_inventario);
		inventario.setNota("Producto sin existencias");
		inventario.setCantidad_existente(0);
		inventarioService.guardarInventario(inventario);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

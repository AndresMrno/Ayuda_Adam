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

import com.Softbarv4.Softbarv4.IService.productoService;
import com.Softbarv4.Softbarv4.Model.Producto;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private productoService productoService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Producto>> listarProducto(){
		return new ResponseEntity<>(productoService.listarProducto(), HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto){
		return new ResponseEntity<>(productoService.guardarProducto(producto), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id_producto}")
	public ResponseEntity<Producto> obtenerProducto(@PathVariable Long id_producto){
		return new ResponseEntity<>(productoService.productoPorId(id_producto), HttpStatus.OK);
	}
	
	@PutMapping("/actualizar/{id_producto}")
	public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id_producto, @RequestBody Producto producto){
		Producto productoEncontrado = productoService.productoPorId(id_producto);
		
		if(productoEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		try {
			productoEncontrado.setNombre_producto(producto.getNombre_producto());
			productoEncontrado.setId_categoria(producto.getId_categoria());
			productoEncontrado.setPrecio(producto.getPrecio());
			productoEncontrado.setCantidad(producto.getCantidad());
			productoEncontrado.setDescripcion(producto.getDescripcion());
			
			return new ResponseEntity<>(productoService.guardarProducto(productoEncontrado), HttpStatus.CREATED);
		}catch(DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
	}
	
	@DeleteMapping(value="/eliminar/{id_producto}")
	public ResponseEntity<?> eliminarProducto(@PathVariable Long id_producto){
		productoService.eliminarProducto(id_producto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}

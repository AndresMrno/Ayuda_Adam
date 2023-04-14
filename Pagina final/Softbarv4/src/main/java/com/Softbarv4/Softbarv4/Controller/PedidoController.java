package com.Softbarv4.Softbarv4.Controller;


import java.math.BigDecimal;
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
import com.Softbarv4.Softbarv4.IService.pedidoService;
import com.Softbarv4.Softbarv4.IService.productoService;
import com.Softbarv4.Softbarv4.IService.usuarioService;
import com.Softbarv4.Softbarv4.Model.Inventario;
import com.Softbarv4.Softbarv4.Model.Pedido;
import com.Softbarv4.Softbarv4.Model.Producto;
import com.Softbarv4.Softbarv4.Model.Usuario;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private pedidoService pedidoService;
	
	@Autowired 
	private usuarioService usuarioService;
	
	@Autowired
	private productoService productoService;
	
	@Autowired
	private inventarioService inventarioService;
	
	
	@GetMapping("/listar")
	public ResponseEntity<List<Pedido>> listarPedido(){
		return new ResponseEntity<>(pedidoService.listarPedido(),HttpStatus.OK);
	}
	
	@GetMapping("/usuario")
	public ResponseEntity<List<Usuario>> listarUsuario(){
		return new ResponseEntity<>(usuarioService.listarUsuario(), HttpStatus.OK);
	}
	
	@GetMapping("/producto")
	public ResponseEntity<List<Producto>> listarProducto(){
		return new ResponseEntity<>(productoService.listarProducto(), HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<Pedido> guardarPedido(@RequestBody Pedido pedido){
		Pedido pedir = pedidoService.guardarPedido(pedido);
		Inventario inventario = inventarioService.inventarioPorId(pedido.getId_productos_fk().getId_producto());
		
		if (inventario != null) {
			int cantidad = pedido.getCantidad();
			int cantidadExistente = inventario.getCantidad_existente();
			inventario.setCantidad_existente(cantidadExistente - cantidad);
			inventarioService.actualizarInventario(inventario);
			} else {
			}
		int totales = 0;
		totales = pedir.getPrecio() * pedir.getCantidad();
		pedir.setTotal(totales);
		pedidoService.guardarPedido(pedir);
		
		return new ResponseEntity<>(pedidoService.guardarPedido(pedido), HttpStatus.CREATED);
	}
	

	
	
	@PostMapping("/{id_pedido}/producto")
	public ResponseEntity<?> agregarProductoAlPedido(@PathVariable Long id_pedido, @RequestBody List<Producto> producto){
		Pedido pedido =  pedidoService.pedidoPorId(id_pedido);
			for (Producto productos : producto) {
				Producto listproductos = new Producto();
				listproductos.setNombre_producto(productos.getNombre_producto());
				listproductos.setCantidad(productos.getCantidad());
				listproductos.setPrecio(productos.getPrecio());	
			} 
		   pedidoService.guardarPedido(pedido);
		   return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id_pedido}")
	public ResponseEntity<Pedido> obtenerPedido(@PathVariable Long id_pedido){
		return new ResponseEntity<>(pedidoService.pedidoPorId(id_pedido), HttpStatus.OK);
	}
	
	@PutMapping("/actualizar/{id_pedido}")
	public ResponseEntity<Pedido> actualizarPedido(@PathVariable Long id_pedido, @RequestBody Pedido pedido){
		Pedido pedidoEncontrado = pedidoService.pedidoPorId(id_pedido);
		
		if(pedidoEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		try {
			pedidoEncontrado.setPrecio(pedido.getPrecio());
			pedidoEncontrado.setCantidad(pedido.getCantidad());
			pedidoEncontrado.setTotal(pedido.getTotal());
			pedidoEncontrado.setId_usuario_fk(pedido.getId_usuario_fk());
			pedidoEncontrado.setId_productos_fk(pedido.getId_productos_fk());
	
			
			return new ResponseEntity<>(pedidoService.guardarPedido(pedidoEncontrado), HttpStatus.CREATED);
			
		}catch(DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	@DeleteMapping(value="/eliminar/{id_pedido}")
	public ResponseEntity<?> eliminarPedido(@PathVariable Long id_pedido){
		pedidoService.eliminarPedido(id_pedido);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
}

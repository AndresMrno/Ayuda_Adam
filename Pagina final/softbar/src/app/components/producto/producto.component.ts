import { Component, OnInit } from '@angular/core';
import { Producto } from 'src/app/models/inventario/producto';
import { ProductoService } from 'src/app/services/inventario/producto.service';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: ['./producto.component.scss']
})
export class ProductoComponent implements OnInit {

  products: Producto[] = [];

  constructor(private productoService: ProductoService) { }

  ngOnInit(): void {
    
    this.getProducto()
  }

  getProducto(){
    this.productoService.getProducto().subscribe((data)=>{
      return this.products = data;
    })
  }

  addToCart(producto:Producto){
    return this.productoService.addProduct(producto);
  }

}

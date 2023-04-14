import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, elementAt, Observable } from 'rxjs';
import { Producto } from 'src/app/models/inventario/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  url: String = 'http://localhost:8083/producto';

  //lista del carrito 

  private myList:Producto[]=[]

  //Observable del carrito 
  private mycart = new BehaviorSubject<Producto[]>([]);
  myCart$ = this.mycart.asObservable();

  constructor(private http: HttpClient) { }


  getProducto(): Observable<Producto[]>{
    return this.http.get<Producto[]> (this.url + '/listar')
  }

  addProduct(producto: Producto){

    if(this.myList.length ==0){
      producto.cantidad=1
      this.myList.push(producto)
      this.mycart.next(this.myList);
    }else{
      const productoMod = this.myList.find((element)=>{
        return element.id_producto === producto.id_producto
      })
      if(productoMod){
        productoMod.cantidad = producto.cantidad + 1;
        this.mycart.next(this.myList);
      }else{
        producto.cantidad=1;
        this.myList.push(producto)
        this.mycart.next(this.myList);
      }
    }
  }

  deleteProducto(id_producto:number){
    this.myList = this.myList.filter((producto)=>{
      return producto.id_producto != id_producto
    })
    this.mycart.next(this.myList);
}

findProductoById(id_producto){
  return this.myList.find((element)=>{
    return element.id_producto ===id_producto;
  })
}

totalCart(){
  const total = this.myList.reduce(function(acc,producto){return acc + (producto.cantidad * producto.precio);},0)
  return total
}

getMyCart(): Producto[]{
  return this.myList;
}
}

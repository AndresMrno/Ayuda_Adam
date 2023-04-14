import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Rol } from 'src/app/models/rol';
import { Usuario } from 'src/app/models/usuario';
import baserUrl from 'src/app/services/helper';
import { UsuariosService } from 'src/app/services/user/usuarios.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-empleado-crud-usuario',
  templateUrl: './empleado-crud-usuario.component.html',
  styleUrls: ['./empleado-crud-usuario.component.scss']
})
export class EmpleadoCrudUsuarioComponent {

  usuarios : Usuario[] = [];

  roles : Rol[] = [];

  urlN : String = baserUrl;

  

  constructor(private usuarioService : UsuariosService, private http: HttpClient) { }

  

  ngOnInit(): void {

    this.usuarioService.getUsuario()
    .subscribe(response => this.usuarios=response);

    this.usuarioService.getRol()
    .subscribe(response => this.roles=response);
  } 

  eliminarUsuario(id_usuario){
    this.usuarioService.eliminarUsuario(id_usuario)
    .subscribe(response =>{
      if(response===true){
        this.usuarios.pop();
      }
      Swal.fire('Usuario Eliminado','Usuario eliminado con exito','success');
    })
  }

  generarPdf(){
    this.http.get((`${this.urlN + '/reports/usuarios_rol'}`), {responseType:'blob'}).subscribe((response: Blob)=>{
     const file = new Blob([response], {type: 'application/pdf'});
     const fileURL = URL.createObjectURL(file);
     window.open(fileURL); 
    })
  }

}

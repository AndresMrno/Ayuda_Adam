import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Rol } from 'src/app/models/rol';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/models/usuario';
import { UsuariosService } from 'src/app/services/user/usuarios.service';
import Swal from 'sweetalert2';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-usuario-form',
  templateUrl: './usuario-form.component.html',
  styleUrls: ['./usuario-form.component.scss'],
})
export class UsuarioFormComponent implements OnInit {
  usuario: Usuario = new Usuario();

  roles: Rol[] = [];
  isEdit: boolean = false;
  formattedDate :string;

  constructor(
    private usuarioService: UsuariosService,
    private activatedRoute: ActivatedRoute,
    private _router: Router,
    private snack: MatSnackBar
  ) {}

  ngOnInit(): void {
    this.usuarioService
      .getRol()
      .subscribe((response) => (this.roles = response));

    this.activatedRoute.params.subscribe((params) => {
      let id_usuario: number = params['id_usuario'];
      this.isEdit = id_usuario != null;
      if (id_usuario) {
        this.usuarioService.obtenerUsuario(id_usuario).subscribe((response) => {
          let fecha = new Date(response.fecha_nacimiento);
          response.fecha_nacimiento = fecha.getFullYear() + "-" +  ((fecha.getMonth() + 1) > 9 ? (fecha.getMonth() + 1) : "0" + (fecha.getMonth() + 1)) + "-" + (fecha.getDate() > 9 ? fecha.getDate() : "0" + fecha.getDate());
          this.usuario = response;
        });
      }
    });
  }


  crearUsuario() {
    this.usuarioService.crearUsuario(this.usuario).subscribe((response) =>
      Swal.fire('Usuario creado', 'Usuario creado con exito', 'success').then(
        (result) => {
          if (result.value) {
            this._router.navigate(['/crud']);
          }
        }
      )
    );
  }

  actualizarUsuario() {
    this.usuarioService
      .actualizarUsuario(this.usuario)
      .subscribe((response) => {
        console.log(response)
        if (this.usuario.edad < 18) {
          this.snack.open('El usuario debe ser mayor de edad', 'Aceptar', {
            duration: 5000,
            verticalPosition: 'top',
            horizontalPosition: 'right',
          });
        }

        Swal.fire(
          'Usuario Actualizado',
          'Usuario actualizado con exito',
          'success'
        );
      });
  }
}



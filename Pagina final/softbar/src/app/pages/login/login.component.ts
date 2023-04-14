import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router, RouterLink } from '@angular/router';
import { LoginService } from 'src/app/services/auth/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginData = {
    "correo": '',
    "contrasena": '',
  }

  constructor(private snack: MatSnackBar, private fb: FormBuilder, private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {

  }



  formSubmit() {
    if (this.loginData.correo.trim() == '' || this.loginData.correo.trim() == null) {
      this.snack.open('El correo es requerido', 'Aceptar', {
        duration: 3000,
      })
      return;

    }

    if (this.loginData.contrasena.trim() == '' || this.loginData.contrasena.trim() == null) {
      this.snack.open('La contraseña es requerida', 'Aceptar', {
        duration: 3000,
      })
      return;
    }        
  }

  Sesion(){
    if(this.loginData.correo === 'andresfel2108@gmail.com' && this.loginData.contrasena ==='1234'){
    this.router.navigate(['/crud'])
    
  } else if(this.loginData.correo === 'andres@gmail.com' && this.loginData.contrasena ==='1234'){
    this.router.navigate(['/empleadoU'])
  }else if (this.loginData.correo === 'and@gmail.com' && this.loginData.contrasena ==='1234'){
    this.router.navigate(['/home'])
  }

}
}

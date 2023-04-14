import { LOCALE_ID,NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule} from '@angular/material/button';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SingupComponent } from './pages/singup/singup.component';
import { LoginComponent } from './pages/login/login.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { HomeComponent } from './pages/home/home.component';
import {MatCardModule} from '@angular/material/card';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { CrudUsuarioComponent } from './components/crud-usuario/crud-usuario.component';
import { UsuarioFormComponent } from './components/usuario-form/usuario-form.component';
import { ReservaFormComponent } from './components/reserva-form/reserva-form.component';
import { CrudReservaComponent } from './components/crud-reserva/crud-reserva.component';
import { CrudInventarioComponent } from './components/crud-inventario/crud-inventario.component';
import { InventarioFormComponent } from './components/inventario-form/inventario-form.component';
import { PedidoFormComponent } from './components/pedido-form/pedido-form.component';
import { CrudPedidoComponent } from './components/crud-pedido/crud-pedido.component';
import { DomicilioComponent } from './pages/domicilio/domicilio.component';
import { VentaComponent } from './pages/venta/venta.component';
import { CrudDomicilioComponent } from './components/crud-domicilio/crud-domicilio.component';
import { DomicilioFormComponent } from './components/domicilio-form/domicilio-form.component';
import { CrudVentaDomicilioComponent } from './components/crud-venta-domicilio/crud-venta-domicilio.component';
import { CartComponent } from './components/cart/cart.component';
import { ProductoComponent } from './components/producto/producto.component';
import { ReservaComponent } from './components/reserva/reserva.component';
import { FullCalendarModule } from '@fullcalendar/angular';
import localeEs from '@angular/common/locales/es';
import { registerLocaleData } from '@angular/common';
import { SendEmailComponent } from './components/send-email/send-email.component';
import { EmpleadoCrudUsuarioComponent } from './components/empleado-crud-usuario/empleado-crud-usuario.component';
import { EmpleadoCrudInventarioComponent } from './components/empleado-crud-inventario/empleado-crud-inventario.component';
import { EmpleadoCrudDomicilioComponent } from './components/empleado-crud-domicilio/empleado-crud-domicilio.component';
import { EmpleadoCrudPedidoComponent } from './components/empleado-crud-pedido/empleado-crud-pedido.component';
import { EmpleadoCrudReservaComponent } from './components/empleado-crud-reserva/empleado-crud-reserva.component';
registerLocaleData(localeEs);







@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SingupComponent,
    LoginComponent,
    HomeComponent,
    CrudUsuarioComponent,
    UsuarioFormComponent,
    ReservaFormComponent,
    CrudReservaComponent,
    CrudInventarioComponent,
    InventarioFormComponent,
    PedidoFormComponent,
    CrudPedidoComponent,
    DomicilioComponent,
    VentaComponent,
    CrudDomicilioComponent,
    DomicilioFormComponent,
    CrudVentaDomicilioComponent,
    CartComponent,
    ProductoComponent,
    ReservaComponent,
    SendEmailComponent,
    EmpleadoCrudUsuarioComponent,
    EmpleadoCrudInventarioComponent,
    EmpleadoCrudDomicilioComponent,
    EmpleadoCrudPedidoComponent,
    EmpleadoCrudReservaComponent,

  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatSnackBarModule,
    MatCardModule,
    MatToolbarModule,
    MatIconModule,
    FullCalendarModule,

  ],
  providers: [
    {
      provide: LOCALE_ID,
      useValue: 'es'
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }



import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CrudDomicilioComponent } from './components/crud-domicilio/crud-domicilio.component';
import { CrudInventarioComponent } from './components/crud-inventario/crud-inventario.component';
import { CrudPedidoComponent } from './components/crud-pedido/crud-pedido.component';
import { CrudReservaComponent } from './components/crud-reserva/crud-reserva.component';
import { CrudUsuarioComponent } from './components/crud-usuario/crud-usuario.component';
import { CrudVentaDomicilioComponent } from './components/crud-venta-domicilio/crud-venta-domicilio.component';
import { DomicilioFormComponent } from './components/domicilio-form/domicilio-form.component';
import { EmpleadoCrudDomicilioComponent } from './components/empleado-crud-domicilio/empleado-crud-domicilio.component';
import { EmpleadoCrudInventarioComponent } from './components/empleado-crud-inventario/empleado-crud-inventario.component';
import { EmpleadoCrudPedidoComponent } from './components/empleado-crud-pedido/empleado-crud-pedido.component';
import { EmpleadoCrudUsuarioComponent } from './components/empleado-crud-usuario/empleado-crud-usuario.component';
import { InventarioFormComponent } from './components/inventario-form/inventario-form.component';
import { PedidoFormComponent } from './components/pedido-form/pedido-form.component';
import { ReservaFormComponent } from './components/reserva-form/reserva-form.component';
import { ReservaComponent } from './components/reserva/reserva.component';
import { SendEmailComponent } from './components/send-email/send-email.component';
import { UsuarioFormComponent } from './components/usuario-form/usuario-form.component';
import { DomicilioComponent } from './pages/domicilio/domicilio.component';

import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { SingupComponent } from './pages/singup/singup.component';
import { VentaComponent } from './pages/venta/venta.component';

const routes: Routes = [
  {
    path : '',
    component:HomeComponent,
    pathMatch : 'full'
  },
  {
    path : 'singup',
    component:SingupComponent,
    pathMatch : 'full'
  },
  {
    path : 'login',
    component:LoginComponent,
    pathMatch : 'full'
  },

  {
    path : 'crud',
    component: CrudUsuarioComponent,
    pathMatch : 'full' 
  },

  {
    path : 'formulario',
    component: UsuarioFormComponent,
  },

  {
    path : 'formulario/:id_usuario',
    component: UsuarioFormComponent, 
  },


  {
    path : 'formularioR',
    component: ReservaFormComponent,
  },

  {
    path : 'formularioR/:id_reserva',
    component: ReservaFormComponent,
  },

  {
    path : 'crudReserva',
    component: CrudReservaComponent,
  },

  {
    path : 'formularioI',
    component: InventarioFormComponent,
  },

  {
    path : 'formularioI/:id_inventario',
    component: InventarioFormComponent,
  },

  {
    path : 'crudInventario',
    component: CrudInventarioComponent,
  },

  {
    path : 'domicilio',
    component: DomicilioComponent,
  },

  {
    path : 'venta',
    component: VentaComponent,
  },

  {
    path : 'crudDomicilio',
    component: CrudDomicilioComponent,
  },

  {
    path : 'formularioD',
    component: DomicilioFormComponent,
  },

  {
    path : 'formularioD/:id_domicilio',
    component: DomicilioFormComponent,
  },
  {
    path : 'crudPedido',
    component: CrudPedidoComponent,
  },

  {
    path : 'FormularioP/:id_pedido',
    component: PedidoFormComponent,
  },
  {
    path : 'FormularioP',
    component: PedidoFormComponent,
  },

  {
    path : 'crudVenta',
    component: CrudVentaDomicilioComponent,
  },

  {
    path : 'reserva',
    component: ReservaComponent,
  },
  {
    path : 'correo',
    component: SendEmailComponent,
  },

  {
    path : 'home',
    component: HomeComponent,
  },

  {
    path : 'empleadoU',
    component: EmpleadoCrudUsuarioComponent,
  },

  {
    path : 'empleadoI',
    component: EmpleadoCrudInventarioComponent,
  },

  {
    path : 'empleadoD',
    component: EmpleadoCrudDomicilioComponent,
  },

  {
    path : 'empleadoP',
    component: EmpleadoCrudPedidoComponent,
  },

  {
    path : 'empleadoR',
    component: EmpleadoCrudPedidoComponent,
  },


  










];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

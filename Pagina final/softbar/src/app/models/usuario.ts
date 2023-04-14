import { Rol } from "./rol";

export class Usuario {

    id_usuario : number;
    nombre : String;
    apellido : String;
    fecha_nacimiento : Date | any;
    edad : number;
    correo : String;
    contrasena : String;
    telefono : number;
    direccion : String;
    identificacion : number;
    id_rol : Rol;

    getWithFK(){
        return {
            id_usuario : this.id_usuario,
            nombre : this.nombre,
            apellido : this.apellido,
            fecha_nacimiento : this.fecha_nacimiento,
            edad : this.edad,
            correo : this.correo,
            contrasena : this.contrasena,
            telefono : this.telefono,
            direccion : this.direccion,
            identificacion : this.identificacion,
            id_rol : this.id_rol.nombre_rol
        }
    }
}



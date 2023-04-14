
const { connection,queryAsync } = require("../mysql");
const { getToken } = require("../jwtUtils");
const { hashPassword,comparePassword } = require("../bcryptUtils");
const { getLastEntityID } = require("../utils");
const { rol } = require(".");

async function login(req,res){
	const { correo, contrasena } = req.body;

	if(!correo || !contrasena){
		res.send("No se ha especificado el correo o la contraseña");
		return;
	}

	connection.query(`select * from usuarios where correo = '${correo}'`, function (err, rows) {
		if (err) throw err;

		if (rows.length <= 0) {
			res.send("Usuario no encontrado");
			return;
		}

		const user = rows[0];

		if(!comparePassword(contrasena,user.contrasena)){
			res.send("Contraseña incorrecta");
			return;
		}

		const token = getToken(user);
		res.send(token);

	});

}

async function register(req,res){

	const {
    apellido,
    contrasena,
    correo,
    direccion,
    edad,
    fecha_nacimiento,
    identificacion,
    nombre,
    telefono,
  } = req.body;

	// TODO: Validar que el correo no exista
	result = await queryAsync(`select * from usuarios where correo = '${correo}'`);
	const user = result[0];

	if(user){
		res.send("El usuario ya existe");
		return;
	}

		// TODO: Guardar el usuario en la base de datos

		const id = await getLastEntityID("id_usuario", "usuarios");

		const id_rol = 3 ;
	// TODO: Encriptar la contraseña

	const hashedPassword = hashPassword(contrasena);

	

	


	// TODO: Guardar el usuario en la base de datos
	await queryAsync(`insert into usuarios values (${id}, '${apellido}', '${hashedPassword}', '${correo}', '${direccion}', ${edad}, '${fecha_nacimiento}', '${identificacion}', '${nombre}', '${telefono}', ${id_rol || 3})`);

	rows = await queryAsync(`select * from usuarios where id_usuario = ${id}`);
	const createdUser = rows[0];

			// Obtener el nombre del rol correspondiente a id_rol
			const resultRol = await queryAsync(`select nombre_rol from roles where id_rol = ${id_rol || 3}`);
			const nombre_rol = resultRol[0].nombre_rol;

	

	
	// TODO: Enviar el token
	const token = getToken(createdUser);
	res.send(token);



	
}

module.exports = { login,register }
				
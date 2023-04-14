const { verifyToken } = require('./jwtUtils');
const { queryAsync } = require('./mysql');

async function isLogged(req,res,next){
	const token = req.headers.authorization;

	if(!token){
		res.send("No se ha especificado el token");
		return;
	}

	const decoded = verifyToken(token);

	if (!decoded) {
    res.send("Token no válido");
    return;
  }

	const rows = await queryAsync(`select * from usuarios where id_usuario = ${decoded.id}`);
	const user = rows[0];

	if(!user){
		res.send("No se ha encontrado el usuario");
		return;
	}

	res.locals.user = user;

	next();
}

function isAdmin(req,res,next){
	const user = res.locals.user;

	if(user.id_rol != 1){
		res.send("No tienes permisos para realizar esta acción");
		return;
	}

	next();
}

function isAdminOrEmpleado(req,res,next){
	const user = res.locals.user;

	if( !(user.id_rol == 1 || user.id_rol == 2) ){
		res.send("No tienes permisos para realizar esta acción");
		return;
	}

	next();
}

module.exports = { isLogged, isAdmin, isAdminOrEmpleado };
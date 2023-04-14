const auth = require('./controllers/auth');
const authUtils = require('./authUtils');
const { usuario,domicilios,inventario,reservas,venta_domocilio,venta_reserva,rol } = require('./controllers');
const { sendMasiveMails } = require('./controllers/mail');
const { generatePDF } = require('./pdfUtils');

function setRoutes(app){
	// usuarios
	app.get(
		"/usuarios", 
		usuario.getAll
	);
	app.get(
		"/usuario",
		usuario.getById
	);
	app.delete(
    "/usuarios",
    usuario.deleteById
  );
	app.put(
		"/usuarios", 
		usuario.updateById
	);	
	app.post(
		"/usuarios",
		usuario.create
	)

	// roles
	app.get(
		"/roles",
		rol.getAll
	)

	//auth
	app.post("/auth/login", auth.login)
	app.post("/auth/register", auth.register)

	// inventario
	app.get(
		"/inventarios", 
		inventario.getAll
	)
	app.post(
		"/inventario",
		inventario.create
	)
	app.put(
		"/inventario",
		inventario.updateById
	)
	app.delete(
		"/inventario",
		inventario.deleteById
	)

	// reservas
	app.get(
		"/reservas",
		reservas.getAll
	)
	app.post(
		"/reserva",
		reservas.create
	)
	app.put(
		"/reserva",
		reservas.updateById
	)
	app.delete(
		"/reserva",
		reservas.deleteById
	)

	// domicilios
	app.get(
		"/domicilios",
		domicilios.getAll
	)
	app.post(
		"/domicilio",
		domicilios.create
	)
	app.put(
		"/domicilio",
		domicilios.updateById
	)
	app.delete(
		"/domicilio",
		domicilios.deleteById
	)
	
	// venta_domicilio
	app.get(
		"/venta_domicilios",
		venta_domocilio.getAll
	)
	app.post(
		"/venta_domicilio",
		venta_domocilio.create
	)
	app.put(
		"/venta_domicilio",
		venta_domocilio.updateById
	)
	app.delete(
		"/venta_domicilio",
		venta_domocilio.deleteById
	)
		
	// venta_reserva
	app.get(
		"/venta_reservas",
		venta_reserva.getAll
	)
	app.post(
		"/venta_reserva",
		venta_reserva.create
	)
	app.put(
		"/venta_reserva",
		venta_reserva.updateById
	)
	app.delete(
		"/venta_reserva",
		venta_reserva.deleteById
	)

	// mails
	app.post(
		"/mails/sendMasiveMails",
		sendMasiveMails
	)

	// reports
	app.get(
		"/reports/usuarios_rol",
		generatePDF
	)

}

module.exports = { setRoutes };
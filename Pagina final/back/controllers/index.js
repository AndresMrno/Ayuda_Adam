const { Entity } = require('../utils');

const inventario = new Entity("inventarios", "id_inventario");
const reservas = new Entity("reservas", "id_reserva");
const domicilios = new Entity("domicilios", "id_domicilio");
const venta_domocilio = new Entity("venta_domicilios", "id_venta_domicilio");
const venta_reserva = new Entity("venta_reservas", "id_venta_reserva");
const usuario = new Entity("usuarios", "id_usuario");
const rol = new Entity("roles", "id_rol");

module.exports = {
  inventario,
  reservas,
  domicilios,
  venta_domocilio,
  venta_reserva,
  usuario,
  rol,
};
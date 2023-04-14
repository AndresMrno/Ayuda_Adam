const {queryAsync} = require('./mysql');

async function getLastEntityID(pk,entityName) {
  const rows = await queryAsync(`select max(${pk}) from ${entityName}`);
  const id = rows[0][`max(${pk})`];
  if (!id) return 0;
  return id + 1;
}

async function standartGetById(id, entityName, pkName) {
	query = "select * from " + entityName + " where " + pkName + " = " + id;
	res = await queryAsync(query);
	return res;
}

async function standartGetAll(entityName){
	query = "select * from " + entityName;

	res = await queryAsync(query);

	return res;
}

async function standartCreate(attrs, entityName, pkName){
	query = "insert into "+ entityName +" (";
	query += pkName + ",";
	query += renderKeysString(attrs, pkName);
	query += ") values (";
	query += await getLastEntityID(pkName, entityName) + ",";
	query += renderValuesString(attrs, pkName);
	query += ")";

	res = await queryAsync(query);

	return res;
}

async function standartUpdate(attrs, entityName, pkName){
  query = "update "+ entityName +" set ";
	query += renderUpdateString(attrs, pkName);
	query += " where " + pkName + " = " + attrs[pkName];

	res = await queryAsync(query);

	return res;
}

async function standartDelete(id, entityName, pkName){
	query = "delete from "+ entityName +" where " + pkName + " = " + id;
	res = await queryAsync(query);
	return res;
}

function renderUpdateString(attrs, pkName) {
	let renderString = "";
	for (const key in attrs) {
		if (attrs[key] != null && key != pkName) {
			renderString += `${key} = '${attrs[key]}',`;
		}
	}
	renderString = renderString.slice(0, -1);
	return renderString;
}

function renderKeysString(attrs, pkName) {
  let renderString = "";
  for (const key in attrs ) {
    if (attrs[key] != null && key != pkName) {
      renderString += `${key},`;
    }
  }
  renderString = renderString.slice(0, -1);
  return renderString;
}

function renderValuesString(attrs , pkName) {
	let renderString = "";
	for (const key in attrs) {
		if (attrs[key] != null && key != pkName) {
      renderString += `'${attrs[key]}',`;
    }
	}
	renderString = renderString.slice(0, -1);
	return renderString;
}

class Entity {
  constructor(entityName, pkName) {

		this.getAll = async function (req, res) {
			const rows = await standartGetAll(entityName);
			res.send(rows);
		}

		this.create = async function (req, res) {
			let result = await standartCreate(req.body, entityName, pkName);
			if (!result) {
				res.status(500).send({
					status: "error",
				});
				return;
			}
			res.status(200).send({
				status: "created",
			});
		}

		this.updateById = async function (req, res) {
			let result = await standartUpdate(req.body, entityName, pkName);
			if (!result) {
				res.status(500).send({
					status: "error",
				});
				return;
			}
			res.status(200).send({
				status: "updated",
			});
		}

		this.deleteById = async function (req, res) {
			const id = req.query.id;
			let result = await standartDelete(id, entityName, pkName);
			if (!result) {
				res.status(500).send({
					status: "error",
				});
				return;
			}
			res.status(200).send({
				status: "deleted",
			});
		}

		this.getById = async function (req, res) {
			const id = req.query.id;
			let result = await standartGetById(id, entityName, pkName);
			if (!result) {
				res.status(500).send({
					status: "error",
				});
				return;
			}
			res.status(200).send(result[0]);
		}

  }
	
}

module.exports = {
  getLastEntityID,
  Entity,
};
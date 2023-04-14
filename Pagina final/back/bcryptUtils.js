const bcrypt = require("bcrypt");

function hashPassword(password){
		const salt = bcrypt.genSaltSync(10);
		const hash = bcrypt.hashSync(password, salt);
		return hash;
}

function comparePassword(password, hash){
	const result = bcrypt.compareSync(password, hash);
	return result;
}

module.exports = { hashPassword, comparePassword };




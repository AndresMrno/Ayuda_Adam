const jwt = require("jsonwebtoken");
const secretPassword = "123"


function getToken(usr){
	const saveCreds = { id: usr.id_usuario, correo: usr.correo }
	const token = jwt.sign(saveCreds, secretPassword);
	return token;
}


function verifyToken(token){
	const decoded = jwt.verify(token, secretPassword);
	return decoded;
}

module.exports = { getToken, verifyToken };


const nodemailer = require("nodemailer");
const { queryAsync } = require("../mysql");

let transporter;
async function setup(){

  transporter = nodemailer.createTransport({
    service: "gmail",
    auth: {
      user: "appsoftbar@gmail.com",
      pass: "uwhjajfxwwrwriqm",
    },
  });

}

async function sendMasiveMails(req,res){
	const {subject,text} = req.body;

	const queryRes = await queryAsync("select correo from usuarios");

	const resivers = queryRes.map((user) => user.correo).toString();
	const mailRes = await sendMail(resivers,subject,text);
	res.status(200).send("Mails enviados");

}

async function sendMail(recivers,subject,text ){

	return await transporter.sendMail({
    from: "appsoftbar@gmail.com",
    to: recivers,
    subject,
    text,
  });

}

module.exports = { sendMail, sendMasiveMails, setup };
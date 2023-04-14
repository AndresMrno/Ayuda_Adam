const express = require("express");
const app = express();
const cors = require("cors");
const port = 8084;
const { connection } = require("./mysql");
const { setRoutes } = require("./routes");
const { setup } = require("./controllers/mail");

// cors
app.use(cors());

// body parser
app.use(express.json());

app.get("/", (req, res) => {
  res.send("Hello World!");
});

// connect DB
connection.connect(function (err) {
  if (err) throw err;
  console.log("Connected to MySQL server!");
});

// set up routes
setRoutes(app);

// start mails
setup();

app.listen(port, () => {
  console.log(`Softbar api listening in port: ${port}`);
});

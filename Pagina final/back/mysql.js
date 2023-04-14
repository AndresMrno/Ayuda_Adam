var mysql = require("mysql");
const util = require("util");

const connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  port: 3307,
  password: '',
  database: "softbarv4",
});

const queryAsync = util.promisify(connection.query).bind(connection);

module.exports = { connection, queryAsync };
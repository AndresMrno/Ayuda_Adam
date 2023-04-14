const PDFDocument = require("pdfkit");
const { queryAsync } = require("./mysql");
const ChartJSImage = require("chart.js-image");

async function generatePDF(req,res) {
  // create pdf
  const doc = new PDFDocument();

  // put title align center
  doc.fontSize(25).text("Reporte", {
    align: "center",
  });

  // get data of users
  const rols = await queryAsync("select id_rol from usuarios");

  // create chart using chart.js-image
  const line_chart = ChartJSImage()
    .chart({
      type: "pie",
      data: {
        labels: [
					"Administradores (" + rols.filter((rol) => rol.id_rol == 1).length + ")",
					"Empleados" + " (" + rols.filter((rol) => rol.id_rol == 2).length + ")",
					"Clientes (" + rols.filter((rol) => rol.id_rol == 3).length + ")",
				],
        datasets: [
          {
            backgroundColor: [
							'rgb(255, 99, 132)',
							'rgb(54, 162, 235)',
							'rgb(255, 205, 86)'
						],
						hoverOffset: 4,
            data: [
							rols.filter((rol) => rol.id_rol == 1).length,
							rols.filter((rol) => rol.id_rol == 2).length,
							rols.filter((rol) => rol.id_rol == 3).length,
						],
          },
        ],
      },
      options: {
        title: {
          display: true,
          text: "Contabilización de usuarios por rol",
        },
      },
    }) // Line chart
    .backgroundColor("white")
    .width(500) // 500px
    .height(300); // 300px
  const buffer = await line_chart.toBuffer();

	// add chart to pdf
	doc.image(buffer, 50, 100, { width: 500 });


  filename = "data.pdf";
  // Setting response to 'attachment' (download).
  // If you use 'inline' here it will automatically open the PDF
  res.setHeader(
    "Content-disposition",
    'attachment; filename="' + filename + '"'
  );
  res.setHeader("Content-type", "application/pdf");
  doc.pipe(res);
  doc.end();
}

module.exports = { generatePDF }

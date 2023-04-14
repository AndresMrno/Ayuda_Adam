var app = {
	table : null,
	dataType : 'json',
	backend: 'http://localhost:8083/softbar',
	init: function(){
		app.initDatatable('#id_tablaU')
		
	},
	initDatatable : function(id){
		var table = $(id).DataTable({
			ajax: { 
				url: app.backend + '/usuario',
				dataSource : function(json){
					return json;
				}
				
			},
			ajaxDataProp: "",
			order: [[ 0, 'asc' ]],
			dom : "Bfrtip",
			columns : [
				{data: "nombre"},
					  { data: "apellido" },
					  { data: "fecha_nacimiento" },
					  {data: "correo" },
					  { data: "contrasena" },
					  { data: "telefono" },
					  { data: "direccion" },
					  { data: "identificacion" },
					  { data: "id_rol.nombre_rol"}
			],
			
			     buttons: [
                {
                    text : 'Editar',
                    action : function(e, dt, node, config) {
                        var data = dt.rows('.table-active').data()[0];
                        app.saveUsuario(data);
                        $('#usuarioModal').modal();
                    }
                }
            ],
        });;
        
        
        $('#id_tablaU  tbody').on('click', 'tr', function(){
            if ($(this).hasClass('table-active')) {
                $(this).removeClass('table-active');
            } else {
                app.table.$('tr.table-active').removeClass('table-active');
                $(this).addClass('table-active');
            }
        });
    },
    
    
    
        setDataToModal : function(data) {
	    
        
    },

	save : function(data) {
        $.ajax({
            url: app.backend + '/save',
            data : JSON.stringify(data),
            method: 'POST',
            contentType: 'application/json',
            success : function(json) {
                $("#msg").text('Se guardó la persona correctamente');
                $("#msg").show();
                $('#usuarioModal').modal('hide');
                app.table.ajax.reload();
            },
            error : function(error) {

            }
        })
    } 
	};
	
	function saveUsuario(){
		
		var usuario ={
		id_usuario : $('#id_usuario').val(data.id_usuario),	
        nombre :  $('#nombre').val(data.nombre),
        apellido :$('#apellido').val(data.apellido),
        fecha_nacimiento :$('#fecha_nacimiento').val(data.fecha_nacimiento),
        correo :$('#correo').val(data.correo),
        contrasena : $('#contrasena').val(data.contrasena),
        telefono :$('#telefono').val(data.telefono),
        direccion :$('#direccion').val(data.direccion),
        identificacion :$('#identificacion').val(data.identificacion),
        id_rol :$('#id_rol.nombre_rol').val(data.id_rol.nombre_rol),
		};
		
		$.ajax({
			url : url+"/save",
			type: "POST",
			contentType : 'application/json',
			data: JSON.stringify(usuario),
			success: function(data){
				console.log("@@@@@@"+data.status);
				console.log("@@@@@@" + data.mensaje);
				if(data.status =="OK"){
					alert(data.mensaje);
					init();	
					$('#usuarioModal').hide();
				}else{
					
					$('#usuarioModal').hide();
				}
			}
		})
		
	}

$(document).ready(function(){
	app.init();
});

					  

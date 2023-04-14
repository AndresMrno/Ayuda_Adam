conexion.connect(function(error){
    if(error){
      throw error;
    }else{
      console.log('Conectado a la base de datos')
    }
  
  });
  
  conexion.end();

  
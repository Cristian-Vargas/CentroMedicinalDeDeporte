<%-- 
    Document   : altaInscripcion
    Created on : 31-oct-2019, 11:55:16
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <%-- TEXTO DE LA PESTAÑA --%>
        <title>Inscripcion</title>
        <%-- BOOTSTARP --%>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    
        <%-- ENCABEZADO --%>
   

        <div >
            <div class="p-1 mb-1 bg-info text-white"><h4 style="margin-left: 15px">
                                INSCRIPCION
        
        <%-- BOLITAS DE COLORES --%>                    
                    <div class="spinner-grow text-primary" role="status">
                        <span class="sr-only">Loading...</span>
                    </div>
                    <div class="spinner-grow text-secondary" role="status">
                        <span class="sr-only">Loading...</span>
                    </div>
                    <div class="spinner-grow text-success" role="status">
                        <span class="sr-only">Loading...</span>
                    </div>
                    <div class="spinner-grow text-danger" role="status">
                        <span class="sr-only">Loading...</span>
                    </div>
                    <div class="spinner-grow text-warning" role="status">
                        <span class="sr-only">Loading...</span>
                    </div>
                    <div class="spinner-grow text-light" role="status">
                        <span class="sr-only">Loading...</span>
                    </div>
                    <div class="spinner-grow text-dark" role="status">
                    <span class="sr-only">Loading...</span>
                    </div>
                    </h4>
            
            </div><br>
        </div>
 
    </head>
    <body>

        <%-- FORMULARIO --%>
       
        
        
        <form style="margin-left: 15px" method="POST" action="/centroMedicinalDeDeporte/servletInscripcion" onsubmit="return validar();">
            
            <div class="form-group row">
                <label for="inputNroOrden" class="col-sm-1 col-form-label">Nro. Orden</label>
                    <div class="col-sm-2">            
                        <input class="form-control" id="inputNroOrden" placeholder="NroOrden" type="text" name="txtNroOrden" value="${idOrdenMedica}" readonly="readonly">
                        
                    </div>
                    
            </div>
            
            <%-- TXT PAciente --%>
            <div class="form-group row">
                <label for="inputPaciente" class="col-sm-1 col-form-label">Paciente</label>
                    <div class="col-sm-2">            
                        <input class="form-control" id="inputNombre" placeholder="Paciente" type="text" name="txtPaciente" value="${nombre}" readonly="readonly">
                    </div>
            </div>

            
            

            <%-- TXT DISCIPLINA --%>
            <div class="form-group row">
                <label for="inputDisciplina" class="col-sm-1 col-form-label">Disciplina</label>
                    <div class="col-sm-2">            
                        <input class="form-control" id="inputDni" placeholder="Disciplina" type="text" name="txtDisciplina" value="${disciplina}" readonly="readonly">
                    </div>
            </div>
            

            <%-- BUTTON --%>
            <div class="form-group row">
                <div class="col-sm-10">
                    <button type="submit" class="btn btn-info btn-lg">Inscribir</button>
                </div>
            </div>
        </form>
       
                  
            
    </body>
        
    <%-- FRANJA DE ABAJO --%>
   <div class="p-2 mb-1 bg-info text-info"><p1>Complete el formulario para ingresar un nuevo cliente.</p1></div>
</html>

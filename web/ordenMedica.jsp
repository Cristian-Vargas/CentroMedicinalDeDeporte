<%-- 
    Document   : ordenMedica
    Created on : 31-oct-2019, 9:57:12
    Author     : Dell
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    
    <title>Album example · Bootstrap</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/album/">

    <!-- Bootstrap core CSS -->
<link href="/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="album.css" rel="stylesheet">
  </head>
    
  <body>
    
    <header>
            <%--BOTONES DE LA BARRA SUPERIOR--%>
           
  <nav class="navbar navbar-expand-md navbar-dark fixed-top btn-info">
     
      
    <a class="navbar-brand" href="/centroMedicinalDeDeporte/index.jsp">C.M.D</a>
        <a  class="btn btn-info btn-lg" href="/centroMedicinalDeDeporte/index.jsp">Inicio</a>
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="btn btn-info btn-lg" href="/centroMedicinalDeDeporte/servletListaDisciplinas">Disciplinas</a>
        </li>
        <li class="nav-item">
          <a class="btn btn-info btn-lg" href="/centroMedicinalDeDeporte/servletListaSedes">Sedes</a>
        </li>
         
        <c:choose>
            <c:when test="${usuario == 'administrador'}">
            
        <%--MOSTRAR SI ES administrador--%>
            
                      <div >
                          <li class="nav-item  dropdown">
                            <a class="nav-item dropdown-toggle btn btn-info btn-lg" href="#" id="navPaciente" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              Pacientes
                            </a>
                            <div class="dropdown-menu " aria-labelledby="navClientes">
                              <a class="dropdown-item " href="/centroMedicinalDeDeporte/servletAltaPaciente">Alta Paciente</a>
                              <a class="dropdown-item " href="/centroMedicinalDeDeporte/servletListaPaciente">Listado</a>
                            </div>
                         </div> 
                        <div >
                          <li class="nav-item dropdown">
                            <a class="nav-item dropdown-toggle btn btn-info btn-lg" href="#" id="navProfesional" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              Profesionales
                            </a>
                            <div class="dropdown-menu " aria-labelledby="navClientes">
                              <a class="dropdown-item " href="/centroMedicinalDeDeporte/servletAltaProfesional">Alta Profesional</a>
                              <a class="dropdown-item " href="/centroMedicinalDeDeporte/servletListaProfesionales">Listado</a>
                            </div>
                         </div>        
                         <div >
                          <li class="nav-item dropdown">
                            <a class="nav-item dropdown-toggle btn btn-info btn-lg" href="#" id="navProfesional" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              otros
                            </a>
                            <div class="dropdown-menu " aria-labelledby="navClientes">
                              <a class="dropdown-item " href="/centroMedicinalDeDeporte/servletListaOrdenMedica">O.M - Inscripcion</a>
                              <a class="dropdown-item " href="/centroMedicinalDeDeporte/servletListaInscripciones">Listado Inscripcion</a>
                              <a class="dropdown-item " href="/centroMedicinalDeDeporte/servletAsistencia">Asistencia</a>
                              <a class="dropdown-item " href="/centroMedicinalDeDeporte/servletReportes">Reportes</a>
                            </div>
                         </div> 
        
                        
            </c:when>
        </c:choose>
     
      </ul> 
                    
                    
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
                   
    </div>
                    <%--BOTON INICIAR SESION--%>
      <form class="form-inline mt-2 mt-md-0">
           <a class="btn btn-info btn-lg" href="/centroMedicinalDeDeporte/servletInicioSesion">Iniciar Sesion</a>
      </form>
        
        
  </nav>
      
</header>
    <body>
<br><br><br>
        <%-- FORMULARIO --%>
       
        <div style="margin-left: 15px"><p1 class="text-secondary"> Datos del paciente:  </p1> </div><br>
        
        <form style="margin-left: 15px" method="POST" action="/centroMedicinalDeDeporte/servletOrdenMedica" onsubmit="return validar();">
            
            <div class="form-group row">
                <label for="inputNroPaciente" class="col-sm-1 col-form-label">Nro. Paciente</label>
                    <div class="col-sm-2">            
                        <input  class="form-control" id="inputNroPaciente" placeholder="NroPaciente" type="text" name="txtNroPaciente" value="${idPaciente}" readonly="readonly">
                        
                    </div>
                    <%--  <div>
                        <button type="submit" class="btn btn-info">Buscar</button>
                    </div> --%>
            </div>
            
            <%-- TXT PAciente --%>
            <div class="form-group row">
                <label for="inputPaciente" class="col-sm-1 col-form-label">Paciente</label>
                    <div class="col-sm-2">            
                        <input class="form-control" id="inputNombre" placeholder="Paciente" type="text" name="txtPaciente" value="${nombre}" readonly="readonly">
                    </div>
            </div>

            
            <%-- TXT DNI paciente --%>
            <div class="form-group row">
                <label for="inputDni" class="col-sm-1 col-form-label">DNI</label>
                    <div class="col-sm-2">            
                        <input class="form-control" id="inputDni" placeholder="DNI" type="text" name="txtDni" value="${dni}" readonly="readonly">
                    </div>
            </div>

            
            <div><p1 class="text-secondary"> Realizado por el medico:  </p1> </div><br>
 
            <div class="form-group row">
                <label for="inputProfesional" class="col-sm-1 col-form-label">Profesional</label>
            <div class="col-sm-2">
                    <select name="ProfesionalId">
				<c:forEach items="${listaProfesional}" var="p">
					<option value="${p.legajo}" ${ProfesionalId eq p.legajo?'selected':''}>${p.toString()}</option>
				</c:forEach>
			</select>
            </div>
            </div>
           
            
            
            <div><p1 class="text-secondary"> Practicas solicitadas:  </p1> </div><br>
            
            <%-- COMBO BOX DISCIPLINAS --%>
            
            <div class="form-group row">
                <label for="inputDisciplina" class="col-sm-1 col-form-label">Disciplina</label>
            <div class="col-sm-2">
                    <select name="listaDisciplinaid">
				<c:forEach items="${listaDisciplina}" var="d">
					<option value="${d.idDisciplina}" ${listaDisciplinaid eq d.idDisciplina?'selected':''}>${d.disciplina}</option>
				</c:forEach>
			</select>
            </div>
            </div>
            

            <%-- TXT CANTIDAD DE SESIONES --%>
            <div class="form-group row">
                <label for="inputCantidadSesiones" class="col-sm-1 col-form-label">Cant. Sesiones</label>
                    <div class="col-sm-2">            
                        <input class="form-control" id="inputCantidadSesiones" placeholder="Cant. Sesiones" type="text" name="txtCantidadSesiones" value="${cantidadSesiones}">
                    </div>
            </div>
            
            <%-- TXT MINUTOS X SESION  --%>
            <div class="form-group row">
                <label for="inputMinutosXSesionMensual" class="col-sm-1 col-form-label">Min. Sesion (Mensual)</label>
                    <div class="col-sm-2">            
                        <input class="form-control" id="inputMinutosXSesionMensual" placeholder="Min. Sesion" type="text" name="txtMinutosXSesionMensual" value="${minXSesion}">
                    </div>
            </div>
            
            <%-- TXT DIAGNOSTICO--%>
            <div class="form-group row">
                <label for="inputDiagnostico" class="col-sm-1 col-form-label">Diagnostico</label>
                                
                        <textarea rows="4" cols="20" class="form-control" id="inputDiagnostico" placeholder="Diagnostico" name="txtDiagnostico" value="${diagnostico}"></textarea>
                    
            </div>
            

            <%-- BUTTON --%>
            <div class="form-group row">
                <div class="col-sm-10">
                    <button type="submit" class="btn btn-info btn-lg">Cargar</button>
                </div>
            </div>
        </form>
       
                  
            
    </body>
        
    <%-- FRANJA DE ABAJO --%>
   <div class="p-2 mb-1 bg-info text-info"><p1>Complete el formulario para ingresar un nuevo cliente.</p1></div>
</html>

<%-- 
    Document   : altaProfesional
    Created on : 30-oct-2019, 16:39:56
    Author     : Dell
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.tipoProfesional"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Controlador.conexionBD"%>
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
<br><br><br>

        <%-- FORMULARIO --%>
       
        <form style="margin-left: 15px" method="POST" action="/centroMedicinalDeDeporte/servletAltaProfesional" onsubmit="return validar();" >
            
            <input type="text" name="txtId" hidden="" value="${legajo}"/>
            
            <%-- TXT NOMBRE--%>
            <div class="form-group row">
                <label for="inputNombre" class="col-sm-1 col-form-label">Nombre</label>
                    <div class="col-sm-2">            
                        <input class="form-control" id="inputNombre" placeholder="Nombre" type="text" name="txtNombre" value="${nombre}">
                    </div>
            </div>
            
            <%-- TXT APELLIDO--%>
            <div class="form-group row">
                <label for="inputApellido" class="col-sm-1 col-form-label">Apellido</label>
                    <div class="col-sm-2">            
                        <input class="form-control" id="inputApellido" placeholder="Apellido" type="text" name="txtApellido" value="${apellido}">
                    </div>
            </div>
            
            <%-- TXT DNI--%>
            <div class="form-group row">
                <label for="inputDni" class="col-sm-1 col-form-label">DNI</label>
                    <div class="col-sm-2">            
                        <input class="form-control" id="inputDni" placeholder="DNI" type="text" name="txtDni" value="${dni}">
                    </div>
            </div>

            <%-- RADIO BUTTON SEXO --%>
            
            <fieldset class="form-group">
                <div class="row">
                    <legend class="col-form-label col-sm-1 pt-0">Sexo</legend>
                        <div class="col-sm-1">
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="rbtSexo" id="inputSexo1" value="Masculino" checked>
                                    <label class="form-check-label" for="gridRadios1">
                                        Masculino
                                    </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="rbtSexo" id="inputSexo2" value="Femenino">
                                    <label class="form-check-label" for="gridRadios2">
                                        Femenino
                                    </label>
                            </div> 
                        </div>
                </div>
            </fieldset>
            
            <%-- COMBO BOX --%>
            
            <div class="form-group row">
                <label for="inputProfesional" class="col-sm-1 col-form-label">Profesional</label>
            <div class="col-sm-2">
                        <select name="tipoProfesionalId">
				<c:forEach items="${listaTipoProfesional}" var="tp">
					<option value="${tp.idTipoProfesional}" ${tipoProfesionalId eq tp.idTipoProfesional?'selected':''}>${tp.tipoProfesional}</option>
				</c:forEach>
			</select>
            </div>
            </div>
            

            <%-- TXT TELEFONO--%>
            <div class="form-group row">
                <label for="inputTelefono" class="col-sm-1 col-form-label">Telefono</label>
                    <div class="col-sm-2">            
                        <input class="form-control" id="inputTelefono" placeholder="Telefono" type="text" name="txtTelefono" value="${telefono}">
                    </div>
            </div>
            
            <%-- TXT DOMICILIO--%>
            <div class="form-group row">
                <label for="inputDomicilio" class="col-sm-1 col-form-label">Domicilio</label>
                    <div class="col-sm-2">            
                        <input class="form-control" id="inputDomicilio" placeholder="Domicilio" type="text" name="txtDomicilio" value="${domicilio}">
                    </div>
            </div>
            
            <%-- TXT E-MAIL--%>
            <div class="form-group row">
                <label for="inputEmail" class="col-sm-1 col-form-label">E-mail</label>
                    <div class="col-sm-2">            
                        <input class="form-control" id="inputEmail" placeholder="E-mail" type="text" name="txtEmail" value="${email}">
                    </div>
            </div>
            
            <%-- BUTTON --%>
            <div class="form-group row">
                <div class="col-sm-10">
                    <button type="submit" class="btn btn-info btn-lg">Cargar</button>
                </div>
            </div>
        </form>
       
                  
            
    </body>
   <script>
		function validar() {
			
                        
                        var txtNom = document.getElementById('inputNombre');
			if (txtNom.value === '') {
				alert('El nombre no debe estar vacio');
				return false;
			}

			var txtApellido = document.getElementById('inputApellido');
			if (txtApellido.value === '') {
				alert('El apellido no debe estar vacio');
				return false;
			}


                        var txtDni = document.getElementById('inputDni').value;
			if (isNaN(txtDni) || txtDni==='') {
				alert('El dni debe completarse con numeros');
				return false;

			}
                        
                        var txtTelef = document.getElementById('inputTelefono').value;
			if (isNaN(txtTelef) || txtTelef==='') {
				alert('El telefono debe completarse con numeros');
				return false;

			}

                         var txtDom = document.getElementById('inputDomicilio');
			if (txtDom.value === '') {
				alert('El domicilio no debe estar vacio');
				return false;
			}

                        var txtEmail = document.getElementById('inputEmail');
			if (txtEmail.value === '') {
				alert('El email no debe estar vacio');
				return false;
			}

			return true;
                        
                        
		}	
                        
			
	</script>
</html>

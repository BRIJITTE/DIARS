<%-- 
    Document   : Inicio
    Created on : 29/05/2019, 05:00:13 PM
    Author     : Dayana
"navbar navbar-default"
"navbar navbar-expand-lg navbar-dark " style="background-color: #FFBF00;"
--%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"   %>
<%@taglib  prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title >MISTER FINESS GYM</title>
        <link rel = "stylesheet" href = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body background="image/fondo1.jpg" style="background-size:cover;">
        
        
        <div class="container">
            <div class="row">
                <h1 align="center" style="color: #FDD835;"><b>BIENVENIDO A MISTER FITNESS!</b></h1>
                <p align="Right">
                    <a href="<c:url value="Login.htm" />" class= "btn btn-warning" >
                        <span aria-hidden="true"></span>Ingresar</a>
                    <a href="<c:url value="Registro.htm" />" class= "btn btn-warning" >
                        <span aria-hidden="true" ></span>Registrarse</a>
                </p>
                <nav class="navbar navbar-expand-lg navbar-dark " style="background-color: #FFD600;" >
                    <div class="navbar-header"><a class="navbar-brand" href="#" style="color: black;">Mister Fitness</a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li class="active" ><a href="IniPaquetes.htm" style="color: black;">Paquetes</a></li>
                        <li><a href="IniClass.htm" style="color: black;">Clases</a></li>
                        <li><a href="IniPromo.htm" style="color: black;">Promociones</a></li>
                    </ul>
                </nav>
                 <table><tr><td><form method="get" action="IniPaquetes.htm">
            <input name="boton1" type="image" src="image/PaqueteGym.jpg  " width="390" height="440">
            </form></td>
            <td><form method="get" action="IniClass.htm">
            <input name="boton2" type="image" src="image/ClasesAdicionales.jpg" width="390" height="440">
            </form></td>
            <td><form method="get" action="IniPromo.htm">
            <input name="boton4" type="image" src="image/Promociones.jpg" width="390" height="440">
            </form> 
            </td>
            </tr></table>
                
             
                
            </div>
        </div>
    </body>
</html>

<%-- 
    Document   : IniClass
    Created on : 06/06/2019, 05:42:46 AM
    Author     : Dayana
--%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"   %>
<%@taglib  prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>MISTER FINESS GYM</title>
        <link rel = "stylesheet" href = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body background="image/logo2.png" background-size=cover>
        <div class="container">
            <div class="row">
                <h1 align="center">BIENVENIDO A MISTER FITNESS!</h1>
                <p align="Right">
                    <a href="<c:url value="Login.htm" />" class= "btn btn-warning" >
                        <span aria-hidden="true"></span>Ingresar</a>
                    <a href="<c:url value="Registro.htm" />" class= "btn btn-warning" >
                        <span aria-hidden="true" ></span>Registrarse</a>
                </p>
                <nav class="navbar navbar-expand-lg navbar-dark " style="background-color: #D5D5D5;" >
                    <div class="navbar-header"><a class="navbar-brand" href="Inicio.htm">Mister Fitness</a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li class="active" ><a href="IniPaquetes.htm">Paquetes</a></li>
                        <li><a href="#">Clases</a></li>
                        <li><a href="IniPromo.htm">Promociones</a></li>
                    </ul>
                </nav>
   
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th> ID </th>
                            <th> Nombre </th>
                            <th> Descripcion </th>
                            <th> Precio </th>
                            <th> Trainer </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${Datos}" var="Dato">
                            <tr>
                            <td><c:out value="${Dato.IdClass}"/></td>
                            <td><c:out value="${Dato.NombreClass}"/></td>
                            <td><c:out value="${Dato.DescripClass}"/></td>
                            <td><c:out value="${Dato.PrecioClass}"/></td>
                            <td><c:out value="${Dato.Nombre}"/></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>

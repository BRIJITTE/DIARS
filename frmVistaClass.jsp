<%-- 
    Document   : frmVistaClass
    Created on : 04/06/2019, 01:15:15 PM
    Author     : Dayana
--%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"   %>
<%@taglib  prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1 align="center">BIENVENIDO A MISTER FITNESS!</h1>
                <br><p>
                    <a href="<c:url value="#" />" class= "btn btn-success">
                        <span class= "glyphicon glyphicon-plus" aria-hidden="true"></span>Ingresar</a>
                </p><p>
                    <a href="<c:url value="#" />" class= "btn btn-success">
                        <span class= "glyphicon glyphicon-plus" aria-hidden="true"></span>Registrarse</a>
                </p>
                <br>
                
                
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

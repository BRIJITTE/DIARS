<%-- 
    Document   : AdmiPaqueHome
    Created on : 14/06/2019, 10:36:40 PM
    Author     : Dayana
--%>

<%@page import="modelos.Operaciones"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador</title>
        <link rel = "stylesheet" href = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body background="image/logo2.png" background-size=cover>
        <div class="container">
            <div class="row">
        <%
            HttpSession sesion=request.getSession();
            String UsuDni;
            String pass;
            String nom;
            Operaciones op=new Operaciones();
            if(sesion.getAttribute("user")!=null && sesion.getAttribute("pass")!=null){
                UsuDni=sesion.getAttribute("user").toString();
                pass=sesion.getAttribute("pass").toString();
                nom=op.NombreUsuario(UsuDni, pass);
                out.print("<h5 align=right>Administrador "+nom+"<a href='Login.htm?cerrar=true'> Cerrar Session</h5></a>");
                
                
            }else{
                out.print("<script>location.replace('Login.htm');</script>");
            }
        %>
        <hr>
        <h1 align="center">Mantenimiento de Paquetes</h1>
                <br>
                <nav class="navbar navbar-expand-lg navbar-dark " style="background-color: #D5D5D5;" >
                    <div class="navbar-header"><a class="navbar-brand" href="IndexAdmi.htm">Mister Fitness</a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li class="active" ><a href="#">Paquetes</a></li>
                        <li><a href="AdmiClassHome.htm">Clases</a></li>
                        <li><a href="AdmiPromoHome.htm">Promociones</a></li>
                        <li><a href="frmHome.htm">Usuarios</a></li>
                        <li><a href="Inscripcion.htm">Inscripciones</a></li>
                    </ul>
                </nav>
                <p>
                    <a href="<c:url value="AdmiPaqueAdd.htm" />" class= "btn btn-success">
                        <span class= "glyphicon glyphicon-plus" aria-hidden="true"></span>Agregar Paquete</a>
                </p>
                <br>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th> ID </th>
                            <th> Nombre </th>
                            <th> Descripcion </th>
                            <th> Precio </th>
                            <th> Accion </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${Datos}" var="Dato">
                            <tr>
                            <td><c:out value="${Dato.IdPaque}"/></td>
                            <td><c:out value="${Dato.NombrePaque}"/></td>
                            <td><c:out value="${Dato.DescripPaque}"/></td>
                            <td><c:out value="${Dato.PrecioPaque}"/></td>
                            <td>
                                <a href="<c:url value="AdmiPaqueEdit.htm?IdPaque=${Dato.IdPaque}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                <a href="<c:url value="AdmiPaqueDelete.htm?IdPaque=${Dato.IdPaque}" />"> <span class = "glyphicon glyphicon-trash" aria-hidden = "true"> </span> </a>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>

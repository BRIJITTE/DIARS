<%-- 
    Document   : Incripcion
    Created on : 06/06/2019, 06:36:07 AM
    Author     : Dayana
--%>
<%@page import="modelos.Operaciones"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType = "text/html" pageEncoding = "UTF-8"%>

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
                <h1 align = "center"> Mantenimiento de Inscripciones </h1>
                <br>
                <nav class="navbar navbar-expand-lg navbar-dark " style="background-color: #D5D5D5;" >
                    <div class="navbar-header"><a class="navbar-brand" href="IndexAdmi.htm">Mister Fitness</a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li class="active" ><a href="#">Paquetes</a></li>
                        <li><a href="AdmiClassHome">Clases</a></li>
                        <li><a href="#">Promociones</a></li>
                        <li><a href="frmHome.htm">Usuarios</a></li>
                        <li><a href="#">Inscripciones</a></li>
                    </ul>
                </nav>
                <p>
                    <a href = "<c:url value="#" />" class = "btn btn-success"> 
                        <span class = "glyphicon glyphicon-plus" aria-hidden = "true"> </span> Agregar Inscripcion </a>    
                    </p>
                <br>
                <table class = "table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th> ID </th>
                            <th> DNI </th>
                            <th> Nombre </th>
                            <th> Apellido </th>
                            <th> Paquete </th>
                            <th> Clase </th>
                            <th> Trainer </th>
                            <th> Precio </th>
                            <th> Acción </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items = "${Datos}" var = "Dato">
                            <tr>
                                <td> <c:out value = "${Dato.IdInscrip}" /> </td>
                                <td> <c:out value = "${Dato.DNI}" /> </td>
                                <td> <c:out value = "${Dato.NombreCliente}" /> </td>
                                <td> <c:out value = "${Dato.Apellido}" /> </td>
                                <td> <c:out value = "${Dato.NombrePaque}" /> </td>
                                <td> <c:out value = "${Dato.NombreClass}" /> </td>
                                <td> <c:out value = "${Dato.Nombre}" /> </td>
                                <td> <c:out value = "${Dato.PrecioInscrip}" /> </td>
                                <td>
                                    </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>

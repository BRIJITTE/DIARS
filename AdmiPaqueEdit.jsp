<%-- 
    Document   : AdmiPaqueEdit
    Created on : 15/06/2019, 12:13:33 AM
    Author     : Dayana
--%>

<%@page import="modelos.Operaciones"%>
<%@taglib  prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset = "UTF-8"/>
        <title>Listado de Paquetes </title>
        <link rel = "stylesheet" href = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
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
        <hr><h1 align="center">Mantenimiento de Paquetes</h1>
                <br>
                <nav class="navbar navbar-expand-lg navbar-dark " style="background-color: #D5D5D5;" >
                    <div class="navbar-header"><a class="navbar-brand" href="IndexAdmi.htm">Mister Fitness</a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li class="active" ><a href="AdmiPaqueHome.htm">Paquetes</a></li>
                        <li><a href="AdmiClassHome.htm">Clases</a></li>
                        <li><a href="AdmiPromoHome.htm">Promociones</a></li>
                        <li><a href="frmHome.htm">Usuarios</a></li>
                        <li><a href="Inscripcion.htm">Inscripciones</a></li>
                    </ul>
                </nav>
        <div class="panel panel-primary">
                    <div class="panel-heading">Editar</div>
                    <div class="panel-body">
                        <form:form method="post" commandName="Paquete">
                           <h1>Complete el formulario</h1> 
                           <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                           <p>
                               <form:label path="NombrePaque">Nombre del paquete: </form:label>
                               <form:input path="NombrePaque" cssClass="form-control"/>
                           </p>
                           <p>
                               <form:label path="DescripPaque">Descripcion: </form:label>
                               <form:input path="DescripPaque" cssClass="form-control"/>
                           </p>
                           <p>
                               <form:label path="PrecioPaque">Precio: </form:label>
                               <form:input path="PrecioPaque" cssClass="form-control"/>
                           </p>
                           <hr/>
                           <input type="submit" value="Enviar" class="btn btn-danger"/>
                        </form:form>
                    </div>
                </div>
    
            </div>
        </div>
    </body>
</html>

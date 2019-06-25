<%-- 
    Document   : AdmiPromoAdd
    Created on : 18/06/2019, 08:44:43 AM
    Author     : Dayana
--%>

<%@page import="modelos.Operaciones"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset = "UTF-8"/>
        <title>Ingreso de Promociones </title>
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
        <hr><h1 align="center">Mantenimiento de Promociones</h1>
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
                    <div class="panel-heading">Formulario de Ingreso a Promociones</div>
                    <div class="panel-body">
                        <form:form method="post" commandName="Promocion">
                           <h1>Complete los Datos del formulario</h1> 
                           <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                           <p>
                               <form:label path="NombrePromo">Nombre de la promocion: </form:label>
                               <form:input path="NombrePromo" cssClass="form-control"/>
                           </p>
                           <p>
                               <form:label path="DescripPromo">Descripcion: </form:label>
                               <form:input path="DescripPromo" cssClass="form-control"/>
                           </p>
                           <p>
                               <form:label path="Descuento">Descuento: </form:label>
                               <form:input path="Descuento" cssClass="form-control"/>
                           </p>
                            <hr />
                            <input type = "submit" value = "Enviar" class = "btn btn-danger" />
                        </form:form>
                    </div>
                </div>
    
            </div>
        </div>
    </body>
</html>

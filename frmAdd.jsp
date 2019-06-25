<%-- 
    Document   : frmAdd
    Created on : 26/05/2019, 07:29:30 PM
    Author     : Dayana
--%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset = "utf-8" />
        <title>Ingreso de Usuarios</title>
        <link rel = "stylesheet" href = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/frmHome.htm"/>">Listado de Usuarios</a></li>
                <li class="active">Agregar Usuario</li>
            </ol>
                <div class="panel panel-primary">
                    <div class="panel-heading">Formulario de Ingreso de Usuarios</div>
                    <div class="panel-body">
                        
                        <form:form method="post" commandName="Usuarios" style="width:auto;" align="center">
                            <h1>Complete los Datos del Formulario</h1>
                            <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                            <p>
                               <form:label path="DNI">DNI: </form:label>
                               <form:input path="DNI" cssClass="form-control"/>
                           </p>
                           <p>
                               <form:label path="Nombre">Nombre: </form:label>
                               <form:input path="Nombre" cssClass="form-control"/>
                           </p>
                           <p>
                               <form:label path="Apellido">Apellido: </form:label>
                               <form:input path="Apellido" cssClass="form-control"/>
                           </p>
                           <p>
                               <form:label path="Celular">Celular: </form:label>
                               <form:input path="Celular" cssClass="form-control"/>
                           </p>
                           <p>
                               <form:label path="Email">Email: </form:label>
                               <form:input path="Email" cssClass="form-control"/>
                           </p>
                           <p>
                               <form:label path="Contra">Contraseña: </form:label>
                               <form:input path="Contra" cssClass="form-control"/>
                           </p>
                           <p>
                               <form:label path="Nivel">Nivel: </form:label>
                               <form:input path="Nivel" cssClass="form-control"/>
                           </p>
                           <hr/>
                           <input type="submit" value="Enviar" class="btn btn-danger"/>
                        </form:form>
                           
                    </div>
                </div>
        </div>
        
    </body>
</html>

<%-- 
    Document   : crearPublicacion
    Created on : 05-jun-2025, 12:14:34
    Author     : Jose
--%>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Publicacion</title>
    <link rel="stylesheet" href="<c:url value="/css/estilo.css"/>">

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="container login">
        <h2>Publicacion</h2>
            <s:form action="CrearPublicacionAction" method="post" cssClass="needs-validation ">
                <p>Comentar</p>
                <div class="form-group">
                    <s:textarea name="comentario" cssClass="form-control  w-100" rows="6" cols="150"/>
                </div>
                <s:submit  value="Enviar Formulario" cssClass="btn btn-primary mt-3" />
            </s:form>
        </div>
    </body>
</html>

<%--
    Document   : inicio
    Created on : 02-jun-2025, 20:34:52
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="<c:url value="/css/estilo.css"/>">
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    </head>
<body>

    <!-- Menú de navegación -->
    <jsp:include page="navbar.jsp" />

    <h1 class="titulo text-center">Umi</h1>

    <div class="container mt-5 login">
        <h2 class="mb-4 text-center">Iniciar sesión</h2>

        <!-- Formulario Struts -->
        <s:form action="loginUsuario" method="post" cssClass="w-100 mx-auto">
            <div class="form-group">
                <s:textfield name="correo" label="Email" cssClass="form-control mb-2" placeholder="nombre@ejemplo.com" required="true" />
            </div>
            <div class="form-group">
                <s:password name="contrasena" label="Contraseña" placeholder="Contraseña" required="true" />
            </div>
            <div class="form-group">
                <s:submit value="Entrar" cssClass="btn btn-primary w-100 d-block mx-auto" />
            </div>
        </s:form>
    </div>

</body>
</html>

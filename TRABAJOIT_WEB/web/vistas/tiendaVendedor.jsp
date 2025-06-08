<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value='/css/estilo.css'/>">
    <title>Inicio</title>
</head>
<body>
    <!-- Menu navegación -->
    <jsp:include page="navbar.jsp"/>

    <div class="container-fluid banner">
        <h1 class="text-center pt-5"><s:property value="nombreTienda"/></h1>
    </div>

    <div class="container-fluid">
        <div class="row">
            <!-- Mostrar menú lateral solo si el usuario es vendedor -->
            <s:if test="#session.usuario.vendedor != null">
                <div class="col-12 col-md-3 position-fixed top-0 start-0 mt-5 pt-5 bg-white bg-opacity-75 vh-100 overflow-auto">
                    <ul class="nav flex-column px-3">
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="registrarProducto.jsp">Registrar producto</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="#">Eliminar producto</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="#">Editar producto</a>
                        </li>
                        <li class="nav-link"><a href="<s:url action="navEditarProducto"/>"> Editar  producto </a></li>

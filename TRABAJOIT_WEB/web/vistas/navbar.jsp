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
        <link rel="stylesheet" href="<c:url value='/css/estilo.css?v=2'/>">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
        <title>Inicio</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm mx-auto barraNavegacion">
            <div class="container-fluid bs-info-bg-subtle">
                <a class="navbar-brand ms-2" href="<s:url action=""/>">
                <img class="imagenLogo" src="<c:url value="/imagenes/umiLOGO.png"/>">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#elementosNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span> </button>
            <div class="collapse navbar-collapse" id="elementosNav"> 
                <ul class="navbar-nav">
                    <s:if test="#session.usuario==null">
                        <li class="nav-item">
                            <a class="nav-link" href="<s:url action="navRegistro"/>">Registrarse</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<s:url action="navLogin"/>">Iniciar sesión</a>
                        </li>
                    </s:if>
                    <s:if test="#session.usuario!=null">
                        <li class="nav-item">
                            <a class="nav-link" href="<s:url action="verDetalleUsuario"/>"><s:property value="%{#session.usuario.usuario}"/></a>
                        </li>
                    </s:if>
                    <li class="nav-item dropdown">      
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Tiendas</a>

                        <ul class="dropdown-menu" aria-labelledby="dropdownTiendas">
                            <li><a class="dropdown-item" href="tiendaUsuario.jsp">Tienda 1</a></li>
                            <li><a class="dropdown-item" href="tiendaUsuario.jsp">Tienda 2</a></li>
                            <li><a class="dropdown-item" href="tiendaUsuario.jsp">Tienda 3</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#"><i class="bi bi-cart"></i></a>
                    </li>
                    <s:if test="#session.usuario.vendedor!=null">
                        <li class="nav-item ms-auto">
                            <a class="nav-link" href="<s:url action="navTiendaVendedor"/>"><s:property value="%{#session.usuario.vendedor.nombreTienda}"/></a>
                        </li>
                    </s:if>
                </ul>
                
                <form class="d-flex ms-auto barraBuscar" role="search"> <input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Search"/>
                    <button class="btn btn-outline-success" type="submit">Buscar</button>
                </form>
            </div>
        </nav>
        <div class="container-fluid">
             <h1 class="titulo">Umi</h1>
        </div>
    </body>
</html>

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
        <title>Inicio</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm mx-auto barraNavegacion">
            <div class="container-fluid bs-info-bg-subtle">
            <a class="navbar-brand ms-2" href="inicio.html">
                <img class="imagenLogo" src="<c:url value="/imagenes/umiLOGO.png"/>">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#elementosNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span> </button>
            <div class="collapse navbar-collapse" id="elementosNav"> <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="login.html">Iniciar sesión</a>
                    </li>
                    <li class="nav-item dropdown">      <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Tiendas</a>

                        <ul class="dropdown-menu" aria-labelledby="dropdownTiendas">
                            <li><a class="dropdown-item" href="tiendaUsuario.html">Tienda 1</a></li>
                            <li><a class="dropdown-item" href="tiendaUsuario.html">Tienda 2</a></li>
                            <li><a class="dropdown-item" href="tiendaUsuario.html">Tienda 3</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#"><i class="bi bi-cart"></i></a>
                    </li>
                </ul>
                <form class="d-flex ms-auto barraBuscar" role="search"> <input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Search"/>
                    <button class="btn btn-outline-success" type="submit">Buscar</button>
                </form>
            </div>
        </nav>
        <div class="container-fluid">
             <h1 class="titulo">Umi</h1>
        </div>

        <div class="container containerGeneral">
            <div class="row justify-content-center">
                <div class="col-12 col-sm-6 col-lg-3 col-xl-2 producto-item">
                    <div class="card h-100">
                        <img src="<c:url value="/imagenes/camiseta.png"/>" class="card-img-top" alt="Nombre del producto">
                        <div class="card-body d-flex flex-column">
                            <h5 class="card-title"><a href="producto.html">Nombre del Producto</a></h5>
                            <p class="card-text text-muted mb-3"> <a href="tienda.html">Nombre de la tienda</a></p>
                        </div>
                    </div>
                </div>

                <div class="col-12 col-sm-6 col-lg-3 producto-item">
                    patampiasd
                </div>
                <div class="col-12 col-sm-6 col-lg-3 producto-item">
                    patampiasd
                </div>
                <div class="col-12 col-sm-6 col-lg-3 producto-item">
                    patampiasd
                </div>
            </div>
        </div>     
                        <s:form action="navRegistro">
                            <s:submit value="Registrarse"/>
                        </s:form>                
    </body>
</html>
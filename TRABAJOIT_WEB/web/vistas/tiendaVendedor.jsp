<%-- 
    Document   : tiendaVendedor
    Created on : 03-jun-2025, 8:54:33
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="<c:url value="/css/estilo.css"/>">

        <title>Inicio</title>
    </head>
    <body class="a">
        <!--Menu navegacion-->
        <nav class="navbar navbar-expand-sm mx-auto barraNavegacion">
            <div class="container-fluid bs-info-bg-subtle">
            <a class="navbar-brand ms-2" href="inicio.html">Umi</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#elementosNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span> <!-- boton para cuando se ponga la pantalla muy pequeña-->
            </button>
            <div class="collapse navbar-collapse" id="elementosNav"> <!-- se pone collapse indicando que puede ser ocultable-->
                <ul class="navbar-nav">
                    <!--despleglable de tiendas-->
                    <li class="nav-item dropdown">      <!--toggle es alternar, cambiar de un estado a otro-->
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Tiendas</a>
                        <ul class="dropdown-menu" aria-labelledby="dropdownTiendas">
                            <li><a class="dropdown-item" href="tienda.html">Tienda 1</a></li>
                            <li><a class="dropdown-item" href="tienda.html">Tienda 2</a></li>
                            <li><a class="dropdown-item" href="tienda.html">Tienda 3</a></li>
                        </ul>
                    </li>
                </ul>
                 <form class="d-flex ms-auto barraBuscar" role="search"> <!--display-flex para que boton e input esten horizontales-->
                    <input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Search"/>
                    <button class="btn btn-outline-success" type="submit">Buscar</button>
                </form>
            </nav>
                </div>
        <div class="container-fluid banner">
            <h1 class="text-center pt-5">TIENDA TAL</h1>
        </div>

        <div class="container-fluid containerGeneral">
            <div class="row">
                <div class="col-3 col-md-3">
                    <ul class="navbar-var">
                        <li class="nav-link"><a href="registrarProducto.jsp">Registrar producto</a></li>
                        <li class="nav-link">Eliminar producto</li>
                        <li class="nav-link">Editar  producto</li>
                    </ul>
                </div>
                <div class="col-12 col-md-6 col-lg-3 producto-item">
                    <div class="card h-100">
                        <img src="camiseta.png" class="card-img-top" alt="Nombre del producto">
                        <div class="card-body d-flex flex-column">
                            <h5 class="card-title"><a href="producto.html">Nombre del Producto</a></h5>
                        </div>
                    </div>
                </div>

                <div class="col-12 col-md-6 col-lg-3 producto-item">
                    patampiasd
                </div>
                <div class="col-12 col-md-6 col-lg-3 producto-item">
                    patampiasd
                </div>
                <div class="col-12 col-md-6 col-lg-3 producto-item">
                    patampiasd
                </div>
            </div>
        </div>

    </body>
    </html>

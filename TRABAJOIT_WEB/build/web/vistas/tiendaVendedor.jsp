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
        <link rel="stylesheet" href="<c:url value="/css/estilo.css"/>">

        <title>Inicio</title>
    </head>
    <body>
        <!--Menu navegacion-->
        <jsp:include page="navbar.jsp"/>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
    </html>

<%-- 
    Document   : tiendaVendedor
    Created on : 03-jun-2025, 8:54:33
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
        <link rel="stylesheet" href="<c:url value="/css/estilo.css"/>">

        <title>Inicio</title>
    </head>
    <body>
        <!--Menu navegacion-->
        <jsp:include page="navbar.jsp"/>
                </div>
        <div class="container-fluid banner">
            <h1 class="text-center pt-5">TIENDA <s:property value="nombreTienda"/></h1>
        </div>

        <div class="container containerPrincipal">
            <div class="row">
                <div class="col-3 col-md-3 me-auto">
                    <ul class="navbar-var">
                        <li class="nav-link"><a href="registrarProducto.jsp">Registrar producto</a></li>
                        <li class="nav-link">Eliminar producto</li>
                        <li class="nav-link">Editar  producto</li>
                    </ul>
                </div>
                <div class="col-6 col-md-9">
                    <s:iterator value="listaProdTienda" id="prod">
                        <div class="col-12 col-sm-6 col-lg-3 col-xl-2 producto-item">
                            <div class="card h-100">
                                <img src="<c:url value='#prod.urlImagen'/>" class="card-img-top" alt="Nombre del producto">
                                <div class="card-body d-flex flex-column">
                                    <h5 class="card-title"><a href="<s:url action="navProducto"><s:param name="id" value="%{#prod.nombre}"/></s:url>"><s:property value="#prod.nombre"/></a></h5>
                                    <p class="card-text text-muted mb-3"> 
                                            <s:property value="#prod.dni.nombreTienda"/></a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </s:iterator>
                </div>
            </div>
        </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
    </html>

<%-- 
    Document   : carrito
    Created on : 04-jun-2025, 20:04:30
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="<c:url value='/css/estilo.css?v=2'/>">
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
         <title>Carrito</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>

        <div class="container containerPrincipal mt-5"> <%-- Agregué mt-5 para espacio superior --%>
            <div class="row">
                <div class="col-xl-8">
                    <s:if test="%{#session.listaProductos != null && #session.listaProductos.size > 0}">
                        <s:set var="firstProduct" value="%{#session.listaProductos[0]}"/>
                        <div class="row">
                            <div class="col-md-6">
                                <img src="<c:url value='${firstProduct.urlImagen}'/>" class="img-fluid product-image-container" alt="${firstProduct.nombre}">
                            </div>
                            <div class="col-md-6 detalleProducto">
                                <h1 class="product-title"><s:property value="#firstProduct.nombre"/></h1>
                                <p class="product-price">
                                    <s:property value="#firstProduct.precio"/>€
                                </p>
                                <p class="vendor-info">
                                    Vendido por <a href="#"><s:property value="#firstProduct.idTienda.nombreTienda"/></a>
                                </p>
                                <p class="mt-3"><s:property value="#firstProduct.descripcion"/></p>
                            </div>
                        </div>
                    </s:if>
                    <s:else>
                        <p>No hay productos disponibles en la sesión.</p>
                    </s:else>
                </div>

                <div class="col-xl-4 mt-4 mt-xl-0"> <%-- mt-4 para móviles, mt-xl-0 para desktop --%>
                    <div class="resumen-pedido-card">
                        <h5>Resumen Del Pedido</h5>
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <span>Precio Estimado:</span>
                            <span class="price">0,00€</span>
                        </div>
                        <button class="btn btn-comprar">Comprar ahora</button>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-Ycp5qRzN6/d5t2UuL+D/0L7T0c7/b/B/b/g/p/p/v/k/d/r/r/w/n/g/z/j/l/x/y/y/a/m/n/b/c/d/e/f/g/h/i/j/k/l/m/n/o/p/q/r/s/t/u/v/w/x/y/z/A/B/C/D/E/F/G/H/I/J/K/L/M/N/O/P/Q/R/S/T/U/V/W/X/Y/Z=" crossorigin="anonymous"></script>
    </body>
</html>

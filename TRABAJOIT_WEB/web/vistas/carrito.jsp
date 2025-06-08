<%--
    Document   : carrito
    Created on : 04-jun-2025, 20:04:30
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- Added for c:url --%>

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
                        <%-- Iterate over each product in the session list --%>
                        <s:iterator value="#session.usuario.carrito" id="product">
                            <div class="row mb-4 border-bottom pb-4"> <%-- Added mb-4 and border-bottom for separation between products --%>
                                <div class="col-md-6">
                                    <img src="<c:url value='#product.urlImagen'/>" class="img-fluid product-image-container" alt="#product.urlImagen">
                                </div>
                                <div class="col-md-6 detalleProducto">
                                    <h1 class="product-title"><s:property value="#product.nombre"/></h1>
                                    <p class="product-price">
                                        <s:property value="#product.precio"/>€
                                    </p>
                                    <p class="vendor-info">
                                        Vendido por <a href="#"><s:property value="#product.idTienda.nombreTienda"/></a>
                                    </p>
                                    <p class="mt-3"><s:property value="#product.descripcion"/></p>
                                    <%-- Optional: Add controls for quantity or removal here --%>
                                    <s:form action="eliminarProductoDelCarrito" method="post" cssClass="mt-3">
                                        <s:hidden name="productId" value="%{#product.idProducto}"/>
                                        <button type="submit" class="btn btn-danger btn-sm">Eliminar del Carrito</button>
                                    </s:form>
                                </div>
                            </div>
                        </s:iterator>
                    </s:if>
                    <s:else>
                        <p>No hay productos en el carrito.</p>
                    </s:else>
                </div>

                <div class="col-xl-4 mt-4 mt-xl-0"> <%-- mt-4 para móviles, mt-xl-0 para desktop --%>
                    <div class="resumen-pedido-card">
                        <h5>Resumen Del Pedido</h5>
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <span>Precio Estimado:</span>
                            <%-- You'll need to calculate the total price in your action/bean --%>
                            <span class="price"><s:property value="totalPrice"/>€</span> <%-- Assuming you have a 'totalPrice' property in your action --%>
                        </div>
                        <button class="btn btn-comprar">Comprar ahora</button>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
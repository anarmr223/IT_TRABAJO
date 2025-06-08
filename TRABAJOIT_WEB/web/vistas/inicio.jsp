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
        <jsp:include page="navbar.jsp"/>
        <div class="container containerPrincipal">
            <div class="row justify-content-center">
                <s:iterator value="#session.listaProductos" id="prod">
                    <div class="col-12 col-sm-6 col-lg-3 col-xl-2 producto-item">
                        <div class="card h-100">
                            <img src="<c:url value='#prod.urlImagen'/>" class="card-img-top" alt="Nombre del producto">
                            <div class="card-body d-flex flex-column">
                                <h5 class="card-title"><a href="<s:url action="navProducto"><s:param name="id" value="%{#prod.id}"/></s:url>"><s:property value="#prod.nombre"/></a></h5>
                                <p class="card-text text-muted mb-3"> 
                                    <a href="<s:url action="navTienda"><s:param name="idTienda" value="%{#prod.idTienda}"/></s:url>">
                                        <s:property value="#prod.dni.nombreTienda"/></a>
                                </p>
                            </div>
                        </div>
                    </div>
                </s:iterator>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>

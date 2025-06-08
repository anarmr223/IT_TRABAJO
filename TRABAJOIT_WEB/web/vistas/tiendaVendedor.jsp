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

        <<<<<<< HEAD
        <div class="container-fluid">
            <div class="row">
                <!-- Mostrar menú lateral solo si el usuario es vendedor -->
                <s:if test="#session.usuario.vendedor != null">
                    <div class="col-12 col-md-3 position-fixed top-0 start-0 mt-5 pt-5 bg-white bg-opacity-75 vh-100 overflow-auto">
                        <ul class="nav flex-column px-3">
                            <li class="nav-item">
                                <a class="nav-link text-dark" href="<s:url action="registrarProductoAction"/>">Registrar producto</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-dark" href="#">Eliminar producto</a>
                            </li>
                            <li class="nav-item">
                                <a href="<s:url action="navEditarProducto"/>"> Editar  producto </a>
                            </li>
                        </s:if>
                </div>

                <!-- Productos -->
                <div class="<s:if test='#session.usuario.vendedor != null'>offset-md-3</s:if> col-12 col-md-9 mt-4">
                        <div class="row g-3">
                        <s:iterator value="listaProdTienda" id="prod">
                            <div class="col-6 col-md-4 col-lg-3 col-xl-2">
                                <div class="card h-100">
                                    <img src="<c:url value='#prod.urlImagen'/>" class="card-img-top" alt="Foto del producto">
                                    <div class="card-body d-flex flex-column">
                                        <h5 class="card-title">
                                            <a href="<s:url action='navProducto'><s:param name='id' value='%{#prod.nombre}'/></s:url>">
                                                <s:property value="#prod.nombre"/>
                                            </a>
                                        </h5>
                                        <!-- boton eliminar prod para el vendedor -->
                                        <s:if test="#session.usuario.vendedor != null">
                                            <form action="<s:url action='eliminarProducto'/>" method="post" class="mt-auto">
                                                <input type="hidden" name="id" value="<s:property value='#prod.idProducto'/>" />
                                                <button type="submit" class="btn btn-danger btn-sm w-100 mt-2">
                                                    Eliminar
                                                </button>
                                            </form>
                                        </s:if>
                                    </div>
                                </div>
                            </div>
                        </s:iterator>

                    </div>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>


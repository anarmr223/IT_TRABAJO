    <%-- 
        Document   : registrarProducto
        Created on : 03-jun-2025, 8:56:52
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

            <title>JSP Page</title>
        </head>
        <body>
            <!--Menu navegacion-->
            <nav class="navbar navbar-expand-sm mx-auto">
                <div class="container-fluid bs-info-bg-subtle">
                <a class="navbar-brand ms-2" href="#">Umi</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#elementosNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span> <!-- boton para cuando se ponga la pantalla muy pequeña-->
                </button>
                <div class="collapse navbar-collapse" id="elementosNav"> <!-- se pone collapse indicando que puede ser ocultable-->
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="inicio.html">Inicio</a>
                        </li>
                        <!--despleglable de tiendas-->
                        <li class="nav-item dropdown">      <!--toggle es alternar, cambiar de un estado a otro-->
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Tiendas</a>

                            <ul class="dropdown-menu" aria-labelledby="dropdownTiendas">
                                <li><a class="dropdown-item" href="#">Tienda 1</a></li>
                                <li><a class="dropdown-item" href="#">Tienda 2</a></li>
                                <li><a class="dropdown-item" href="#">Tienda 3</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">demonio</a>
                        </li>
                    </ul>
                </div>
            </nav>

            <h1 class="titulo text-center">Umi</h1>

            <!--login-->

            <div class="container-fluid registrarProducto"> <!--mt es margin top-->
                <h2 class="mb-4 text-center">Registrar producto</h2>
                <s:form action="guardarProducto" method="post" enctype="multipart/form-data">
                <div class="d-flex">
                    <div class="col-md-6 col-sm-12 productoForm">
                        <!--AQUI COL IZQ-->
                        <s:textfield name="nombre" label="Nombre" cssClass="form-control" placeholder="Camiseta azul" required="true" />
                        <s:textfield name="descripcion" label="Descripcion" cssClass="form-control" placeholder="Camiseta azul" required="true" />
                        <s:textfield name="precio" label="Precio" cssClass="form-control" placeholder="19.99" required="true" />
                        <s:file name="imagen" label="Subir foto del producto" accept="image/*" required="true" />
                    </div>
                            
                    <div class="col-md-6 tablaProductoForm">
                        <!--COL DCHA-->
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">TALLAS</th>
                                    <th scope="col">Cantidad</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row">TALLA</th>
                                    <td>
                                        <s:textfield name="cantidad" placeholder="Cantidad" />
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                </div>
                </div>
                <div class="text-center">
                    <s:submit value="Enviar" cssClass="btn btn-primary w-50 d-block mx-auto botonRegistrarProd" />
                </div>
                </s:form>
            
            </div>
        </body>
    </html>
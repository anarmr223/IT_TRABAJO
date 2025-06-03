<%-- 
    Document   : producto
    Created on : 03-jun-2025, 15:38:58
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
        <link rel="stylesheet" href="<c:url value='/css/estilo.css?v=2'/>">

        <title>Producto</title>
    </head>
    <body>
        <!--Menu navegacion-->
        <jsp:include page="navbar.jsp"/>
        
        <!--PRODUCTO FOTO MAS AÑADIR-->
        <div class="container containerGeneral">
            <div class="row especificacionProducto">
                <div class="col-6 columna">
                    <img class="fotoProducto" src="../imagenes/camiseta.png" alt="Nombre del producto">
                </div>

                <div class="col-6 columna">
                    <h1>Nombre producto</h1>
                    <p class="mt-5">Precio</p>
                    <p>Especificaciones</p>
                    <div class="d-flex justify-content-center">
                            <!--ESTARIA BIEN QUE EL PRODUCTO TUVIERA ETIQUETAS Y QUE LO QUE SE MOSTRARA ABAJO FUERAN COSAS QUE TUVIERAN LA MISMA ETIQUETA-->
                        <div class="w-75">
                            <s:select list="{'M','L'}" label="Seleccione una talla" id="talla" headerKey="" headerValue="Seleccione la talla" cssClass="form-control"/>
                        </div>
                        <div class="w-75">
                            <s:textfield name="cantidad" label="Cantidad" cssClass="form-control" type="number" htmlType="number" min="1" max="50"/>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary w-100 d-block mx-auto Boton">Añadir a carrito</button>
                </div>
            </div>
            <h3>Productos que te podrían interesar:</h3>
             <div class="row justify-content-center">
                <div class="col-12 col-md-6 col-lg-3 producto-item">
                    <div class="card h-100">
                        <img src="camiseta.png" class="card-img-top" alt="Nombre del producto">
                        <div class="card-body d-flex flex-column">
                            <h5 class="card-title"><a href="producto.html">Nombre del Producto</a></h5>
                            <p class="card-text text-muted mb-3"> <a href="tienda.html">Nombre de la tienda</a></p>
                        </div>
                    </div>
                </div> 
            </div>
        </div>
    </body>
</html>
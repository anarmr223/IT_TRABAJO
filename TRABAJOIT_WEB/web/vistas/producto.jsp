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
        <link rel="stylesheet" href="<c:url value='/css/estilo.css?v=2'/>">

        <title>Producto</title>
    </head>
    <body>
        <!--Menu navegacion-->
        <jsp:include page="navbar.jsp"/>

        <!--PRODUCTO FOTO MAS AÑADIR-->
        <div class="container detalleProducto">
            <div class="row especificacionProducto">
                <div class="col-6 columna">
                    <img class="fotoProducto" src="<s:property value="producto.uRLImagen"/>" alt="Foto del producto">
                </div>

                <div class="col-6 columna">
                    <h1><s:property value="producto.nombre"/></h1>
                    <p class="mt-5">Precio: <s:property value="producto.precio"/></p>
                    <p>Especificaciones: <s:property value="producto.descripcion"/></p>
                    <div class="d-flex justify-content-center">
                        <!--ESTARIA BIEN QUE EL PRODUCTO TUVIERA ETIQUETAS Y QUE LO QUE SE MOSTRARA ABAJO FUERAN COSAS QUE TUVIERAN LA MISMA ETIQUETA-->
                        <s:if test="producto.tallaCollection!=null">
                            <div class="w-75">
                                <s:select name="talla" list="%{#producto.tallaCollection}" label="Seleccione una talla" id="talla" value="talla" key="talla" headerKey="" headerValue="Seleccione la talla" cssClass="form-control"/>
                            </div>
                            <div class="w-75">
                                <s:textfield name="cantidad" label="Cantidad" cssClass="form-control" type="number" htmlType="number" min="1" max="50"/>
                            </div>


                        </div>
                        <s:form action="aniadirCarritoAction">
                            <s:hidden name="producto" value="%{producto}"/>
                            <s:submit value="Añadir a carrito" cssClass="btn btn-primary w-100 d-block mx-auto Boton"/>
                        </s:form>
                    </s:if>
                    <s:else>
                        No hay productos disponibles
                    </s:else>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

    </body>
</html>
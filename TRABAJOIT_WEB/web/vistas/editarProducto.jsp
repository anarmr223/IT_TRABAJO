<%-- 
    Document   : editarProducto
    Created on : 08-jun-2025, 11:09:58
    Author     : Usuario
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

            <title>Editar producto</title>
        </head>
        <body>
            <jsp:include page="navbar.jsp"/>

            <!--login-->

            <div class="container-fluid registrarProducto"> <!--mt es margin top-->
                <h2 class="mb-4 text-center">Editar producto</h2>
                <s:form action="editarProducto" theme="simple" method="post" enctype="multipart/form-data">
                <div class="d-flex">
                    <div class="col-md-6 col-sm-12 productoForm">
                        <!--AQUI COL IZQ-->
                        
                        <label for="nombre">ID PRODUCTO</label>
                        <s:textfield name="idProducto" id="idProducto" cssClass="form-control" placeholder="idProducto" required="true" />
                        
                        <label for="nombre">Nombre</label>
                        <s:textfield name="nombre" id="nombre" cssClass="form-control" placeholder="Nombre" required="true" />

                        <label for="descripcion">Descripción</label>
                        <s:textfield name="descripcion" id="descripcion" cssClass="form-control" placeholder="Descripcion" required="true" />

                        <label for="precio">Precio</label>
                        <s:textfield name="precio" id="precio" cssClass="form-control" placeholder="Por ejemplo: 19.99" required="true" />

                        <label class="mt-5" for="imagen">Subir foto del producto</label>
                        <s:file name="imagen" id="imagen" accept="image/*" required="true" />
                    </div>
                    
                            
                    <div class="col-md-6 tablaProductoForm ms-5">
                        <!--COL DCHA-->
                        <table class="thead-dark">
                            <thead>
                                <tr>
                                    <th scope="col">TALLAS</th>
                                    <th scope="col">Cantidad</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row">XS</th>
                                    <td>
                                        <s:textfield name="cantidadXS" cssClass="form-control" placeholder="Cantidad" />
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">S</th>
                                    <td>
                                        <s:textfield name="cantidadS" cssClass="form-control" placeholder="Cantidad" />
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">M</th>
                                    <td>
                                        <s:textfield name="cantidadM" cssClass="form-control" placeholder="Cantidad" />
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">L</th>
                                    <td>
                                        <s:textfield name="cantidadL" cssClass="form-control" placeholder="Cantidad" />
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">XL</th>
                                    <td>
                                        <s:textfield name="cantidadXL" cssClass="form-control" placeholder="Cantidad" />
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">2XL</th>
                                    <td>
                                        <s:textfield name="cantidad2XL" cssClass="form-control" placeholder="Cantidad" />
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
             <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        </body>
    </html>
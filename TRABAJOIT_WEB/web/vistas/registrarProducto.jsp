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
            <link rel="stylesheet" href="<c:url value="/css/estilo.css"/>">

            <title>JSP Page</title>
        </head>
        <body>
        <jsp:include page="navbar.jsp"/>
            <div class="container-fluid registrarProducto"> <!--mt es margin top-->
                <h2 class="mb-4 text-center">Registrar producto</h2>
                <s:form action="registrarProductoAction" theme="simple" method="post" enctype="multipart/form-data">
                <div class="d-flex">
                    <div class="col-md-6 col-sm-12 me-2 productoForm">
                        <!--AQUI COL IZQ-->
                        <label for="nombre">Nombre</label>
                        <s:textfield name="nombre" id="nombre" cssClass="form-control" placeholder="Camiseta azul" required="true" />

                        <label for="descripcion">Descripción</label>
                        <s:textfield name="descripcion" id="descripcion" cssClass="form-control" placeholder="Camiseta azul" required="true" />

                        <label for="precio">Precio</label>
                        <s:textfield name="precio" id="precio" cssClass="form-control" placeholder="19.99" required="true" />

                        <label class="mt-2" for="imagen">Subir fotos del producto</label>
                        <s:file name="imagen1" id="imagen" cssClass="form-control mb-2" accept="image/*" required="true" />
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
                                        <s:textfield name="cantidad2XL" cssClass="form-control"  placeholder="Cantidad" />
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
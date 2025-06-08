<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
        <link rel="stylesheet" href="<c:url value='/css/estilo.css'/>">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
        <title>Inicio</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>

        <div class="container-fluid banner">
            <h1 class="text-center pt-5"><s:property value="nombreTienda"/></h1>
        </div>

        <div class="container-fluid">
            <div class="row">
                <div class="col-12 text-end mt-3 mb-3">
                    <s:if test="#session.usuario.vendedor==null">
                        <s:form cssClass="d-inline-block">
                            <button class="btn btn-primary">Suscribirse</button>
                        </s:form>
                    </s:if>
                </div>

                <div class="col-12 mt-4"> <div class="row g-3"> <s:if test='#session.usuario.vendedor != null'>
                            <div class="col-6 col-md-4 col-lg-3 col-xl-2">
                                <div class="card h-100">
                                    <s:form action="navRegistrarProducto" cssClass="h-100" method="post">
                                        <button type="submit" class="btn btn-light w-100 h-100 d-flex flex-column justify-content-center align-items-center">
                                            <i class="fas fa-plus fa-2x mb-2"></i>
                                            <span>Añadir</span>
                                        </button>
                                    </s:form>
                                </div>
                            </div>
                        </s:if>

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
                                            <s:if test="#session.usuario.vendedor != null">
                                            <div class="d-flex justify-content-between gap-2 mt-auto">
                                                <s:form action="<s:url action='editarProducto'/>" cssClass="flex-grow-1" method="post">
                                                    <s:hidden name="id" value="#prod.idProducto"/>
                                                    <button type="submit" class="btn btn-primary btn-sm w-100">
                                                        <i class="fas fa-edit"></i>
                                                    </button>
                                                </s:form>
                                                <s:form action="<s:url action='eliminarProducto'/>" cssClass="flex-grow-1" method="post">
                                                    <s:hidden name="id" value="#prod.idProducto"/>
                                                    <button type="submit" class="btn btn-danger btn-sm w-100">
                                                        <i class="fas fa-trash"></i>
                                                    </button>
                                                </s:form>
                                            </div>
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

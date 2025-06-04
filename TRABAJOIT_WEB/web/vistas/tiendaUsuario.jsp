<%-- 
    Document   : tiendaUsuario
    Created on : 04-jun-2025, 17:39:18
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="estilo.css">

        <title>Inicio</title>
    </head>
    <body>
        <!--Menu navegacion-->
        <jsp:include page="navbar.jsp"/>
        <div class="container-fluid banner mt-5">
            <h1 class="text-center pt-5">TIENDA TAL</h1>
        </div>

        <div class="container containerGeneral">
            <div class="row justify-content-center">
                <div class="col-12 col-md-6 col-lg-3 producto-item">
                    <div class="card h-100">
                        <img src="camiseta.png" class="card-img-top" alt="Nombre del producto">
                        <div class="card-body d-flex flex-column">
                            <h5 class="card-title"><a href="producto.html">Nombre del Producto</a></h5>
                        </div>
                    </div>
                </div>

                <div class="col-12 col-md-6 col-lg-3 producto-item">
                    patampiasd
                </div>
                <div class="col-12 col-md-6 col-lg-3 producto-item">
                    patampiasd
                </div>
                <div class="col-12 col-md-6 col-lg-3 producto-item">
                    patampiasd
                </div>
            </div>
        </div>

    </body>
    </html>
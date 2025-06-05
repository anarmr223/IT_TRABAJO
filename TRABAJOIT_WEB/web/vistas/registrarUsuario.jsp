<%-- 
    Document   : registrarUsuario
    Created on : 03-jun-2025, 10:16:55
    Author     : Asus
--%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario con Inputs Desplegables</title>
    <link rel="stylesheet" href="<c:url value="/css/estilo.css"/>">

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
    <jsp:include  page="navbar.jsp"/>
    
    <div class="container login">
        <h2>Registrar Usuario</h2>
        <s:form action="registrarUsuarioAction" method="post" cssClass="needs-validation ">
            <div class="form-group">
                <s:textfield name="usuario" label="Nombre Usuario" cssClass="form-control  w-100" />
            </div>

            <div class="form-group w-100">
                <s:textfield name="correo" label="Correo" cssClass="form-control w-100" />
            </div>

            <div class="form-group w-100">
                <s:password name="contrasenia" label="Contraseña" cssClass="form-control w-100"/>
            </div>
            
            <div class="form-group">
                <s:password name="repetirContrasenia" label="Repite la contraseña" cssClass="form-control"/>
            </div>

            <div id="inputsAdicionales" style="display: none;">
                <p class="mt-3">Por favor, rellena la siguiente información adicional para registrarte como vendedor:</p>

                
                <div class="form-group">
                    <label for="Nombre">Nombre Completo: </label>
                    <s:textfield name="nombre" id="nombre" label="Nombre Completo" theme="simple" cssClass="form-control" />
                </div>
                
                
                <div class="form-group">
                    <label for="cuenta">Numero de cuenta: </label>
                    <s:textfield name="cuenta" label="Número de Cuenta Bancaria" theme="simple" cssClass="form-control"/>
                </div>

                <div class="form-group">
                    <label for="DNI">DNI: </label>
                    <s:textfield name="dni" id="dni" label="DNI" theme="simple" cssClass="form-control" />
                </div>

                <div class="form-group">
                    <label for="tlf">Telefono</label>
                    <s:textfield name="telefono" id="tlf" theme="simple" cssClass="form-control"></s:textfield>
                </div>
                
                <div class="form-group">
                    <label for="nombreTienda">Nombre Tienda</label>
                    <s:textfield name="nombreTienda" id="nombreTienda" theme="simple" cssClass="form-control"></s:textfield>
                </div>
            </div>

            <div class="form-group form-check">
                <s:checkbox name="mostrarInputsVendedor" label="¿Eres vendedor?" id="mostrarInputsVendedor" cssClass="form-check-input" />
            </div>
            
            <s:submit  value="Enviar Formulario" cssClass="btn btn-primary mt-3" />

        </s:form>
    </div>
    

<script>
    
    $(document).ready(function() {
        // Seleccionamos el checkbox por su ID
        const checkbox = $('#mostrarInputsVendedor');
        // Seleccionamos el div que contiene los inputs adicionales
        const inputsAdicionales = $('#inputsAdicionales');

        // Función para manejar el cambio del checkbox
        checkbox.on('change', function() {
            if ($(this).is(':checked')) {
                // Si el checkbox está marcado, mostramos el div
                inputsAdicionales.slideDown(); // slideDown para un efecto suave
            } else {
                // Si el checkbox no está marcado, ocultamos el div
                inputsAdicionales.slideUp(); // slideUp para un efecto suave
            }
        });

        // Opcional: Si quieres que al cargar la página el estado inicial sea consistente
        // Si el checkbox ya está marcado (por ejemplo, por un valor precargado de Struts),
        // asegúrate de que los inputs adicionales se muestren.
        if (checkbox.is(':checked')) {
            inputsAdicionales.show();
        }
    });
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
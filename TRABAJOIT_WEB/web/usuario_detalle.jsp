<%-- 
    Document   : usuario_detalle
    Created on : 03-jun-2025, 15:18:50
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Perfil de <s:property value="%{#session.usuario.usuario}"/></h1>                 
            <s:form action="actualizarUsuario">
                <s:if test="#session.usuario.vendedor==null">
                    <h2>Detalles Usuario</h2>
                </s:if>
                <s:else>
                    <h2>Detalles Vendedor</h2>
                </s:else>
                <s:textfield name="usuario" label="Usuario" placeholder="%{#session.usuario.usuario}"/>
                <s:textfield name="correo" label="Correo" placeholder="%{#session.usuario.correo}"/>
                <s:password label="Contraseña actual" name="oldPassword"/>
                <s:password label="Nueva contraseña" name="newPassword"/>
                <s:if test="#session.usuario.vendedor!=null">
                    <s:textfield name="nombre" label="Nombre" placeholder="%{#session.usuario.vendedor.nombre}"/>
                    <s:textfield name="nCuenta" label="Numero de cuenta bancaria" placeholder="%{#session.usuario.vendedor.nCuentaBancaria}"/>
                    <s:textfield name="nombreTienda" label="nombreTienda" placeholder="%{#session.usuario.vendedor.nombreTienda}"/>
                    <s:textfield name="telefono" label="Télefono" placeholder="%{#session.usuario.vendedor.telefono}"/>
                </s:if>
                <s:submit value="Actualizar"/>

            </s:form>
        
        
        <s:form action="logOut">
            <s:submit value="logout"/>
        </s:form>   
        
    </body>
</html>

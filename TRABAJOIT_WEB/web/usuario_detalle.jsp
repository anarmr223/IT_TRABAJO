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
        <h1>Detalles de Usuario</h1>
            
        USUARIO: <s:property value="%{#session.usuario.usuario}"/>
        
        
            <s:form action="actualizarUsuario">
                <s:if test="#session.usuario.vendedor==null">
                    <p>Detalles Usuario</p>
                </s:if>
                <s:else>
                    <p>Detalles Vendedor</p>
                </s:else>
                <br>
                <s:textfield name="usuario" label="Usuario" placeholder="%{#session.usuario.usuario}"/>
                <s:textfield name="correo" label="Correo" placeholder="%{#session.usuario.correo}"/>
                <s:password label="Introduzca su Contraseña" name="oldPassword"/>
                <s:password label="Introduzca la nueva Contraseña" name="newPassword"/>
                <s:if test="#session.usuario.vendedor!=null">
                    <s:textfield name="nombre" label="Nombre" placeholder="%{#session.usuario.vendedor.nombre}"/>
                    <s:textfield name="nCuenta" label="Numero de cuenta bancaria" placeholder="%{#session.usuario.vendedor.nCuentaBancaria}"/>
                    <s:textfield name="nombreTienda" label="nombreTienda" placeholder="%{#session.usuario.vendedor.nombreTienda}"/>
                    <s:textfield name="telefono" label="Télefono" placeholder="%{#session.usuario.vendedor.telefono}"/>
                </s:if>
                <s:submit value="Actualizar Usuario"/>

            </s:form>
        
        
        <s:form action="logOut">
            <s:submit value="logout"/>
        </s:form>   
        
    </body>
</html>

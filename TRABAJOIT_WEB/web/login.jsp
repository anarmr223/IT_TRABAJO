<%-- 
    Document   : login
    Created on : 01-jun-2025, 10:00:28
    Author     : Asus
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
        <h1>Iniciar session</h1>
        
        <s:form action="loginAction">
            <s:textfield name="usuario" label="usuario"/>
            <br/>
            <s:textfield name="contrasenia" label="contraseña"/>
            <br/>
            <s:submit name="Iniciar sesion"/>
        </s:form>
    </body>
</html>

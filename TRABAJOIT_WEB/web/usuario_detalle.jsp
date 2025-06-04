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
            
        <s:property value="%{#session.usuario.usuario}"/>
        
        <s:form action="logOut">
            <s:submit value="logout"/>
        </s:form>   
        
    </body>
</html>

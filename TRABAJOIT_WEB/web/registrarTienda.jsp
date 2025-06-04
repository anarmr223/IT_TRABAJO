<%-- 
    Document   : registrarTienda
    Created on : 03-jun-2025, 17:57:04
    Author     : Jose
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
        <h1>Registrar tienda</h1>
        <s:form action="registroTiendaAction">
            <s:textfield name="nombreTienda" label="nombre"/>
            <s:submit/>
        </s:form>
        
    </body>
</html>

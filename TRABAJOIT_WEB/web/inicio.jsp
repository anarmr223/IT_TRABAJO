<%-- 
    Document   : login
    Created on : 31-may-2025, 21:04:50
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
        <h1>Inicio</h1>
        
        <s:form action="navLogin">
            <s:submit value="Iniciar sesion"/>
        </s:form>
    </body>
</html>

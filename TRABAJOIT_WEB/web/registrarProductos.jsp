<%-- 
    Document   : registrarProductos
    Created on : 04-jun-2025, 13:13:59
    Author     : Jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registrar producto</h1>
        
        <s:form action="" enctype="multipart/form-data">
            <s:textfield name="nombre"/>
            <s:file name="miImagen"/>
            <s:textfield name="stock"/>
            <s:textfield name="precio"/>
            <s:textfield name="descripcion"/>
        </s:form>
    </body>
</html>

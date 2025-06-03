<%-- 
    Document   : subirImagenTest
    Created on : 03-jun-2025, 21:11:26
    Author     : Jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Subir imagen test</h1>
        
        <s:form action="subirFicheroPrueba" enctype="multipart/form-data">
            <s:textfield name="usuario" type="text" label="Usuario: "/>
            <br/>
             <s:file name="miArchivo1" label="Selecciona un archivo"/>
             <br/>
             <s:file name="miArchivo2" label="Selecciona un archivo"/>
             <br/>
             <s:file name="miArchivo3" label="Selecciona un archivo"/>
             <br/>
             <s:file name="miArchivo4" label="Selecciona un archivo"/>
             <br/>
             <br/>
             <s:submit value="Enviar"/>
        </s:form>
    </body>
</html>

<%-- 
    Document   : detalleUsuario
    Created on : 07-jun-2025, 10:44:39
    Author     : byste
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

        <jsp:include  page="navbar.jsp"/>

        <div class="container login">
            <h2>Detalles de usuario</h2>
            <s:form action="actualizarUsuario" method="post" cssClass="needs-validation ">
                <div class="form-group">
                    <s:textfield name="usuario" label="Nombre Usuario" cssClass="form-control  w-100" />
                </div>

                <div class="form-group">
                    <s:textfield name="correo" label="Correo" cssClass="form-control w-100" />
                </div>

                <div class="form-group">
                    <s:password name="oldPassword" label="Contraseña actual" cssClass="form-control w-100"/>
                </div>

                <div class="form-group">
                    <s:password name="newPassword" label="Nueva contraseña" cssClass="form-control"/>
                </div>
                <s:if test="#session.usuario.vendedor!=null">
                    <div class="form-group">
                        <s:textfield name="nombre" label="Nombre" placeholder="%{#session.usuario.vendedor.nombre}" cssClass="form-control  w-100"/>
                    </div>
                    <div class="form-group">
                        <s:textfield name="nCuenta" label="Numero de cuenta bancaria" placeholder="%{#session.usuario.vendedor.nCuentaBancaria}" cssClass="form-control  w-100"/>
                    </div>
                    <div class="form-group">
                        <s:textfield name="nombreTienda" label="nombreTienda" placeholder="%{#session.usuario.vendedor.nombreTienda}" cssClass="form-control  w-100"/>
                    </div>
                    <div class="form-group">
                        <s:textfield name="telefono" label="Télefono" placeholder="%{#session.usuario.vendedor.telefono}" cssClass="form-control  w-100"/>
                    </div>
                </s:if>

                <s:submit  value="Actualizar" cssClass="btn btn-primary mt-3" />

            </s:form>
            
            <s:form action="logOut">
                <div class="form-group detalleLogout" >
                <s:submit value="logout" cssClass="form-control  w-100"/>
                </div>
            </s:form>   
        </div>
    </body>
</html>

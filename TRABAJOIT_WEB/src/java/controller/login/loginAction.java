/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.login;

import WS.CuentaWS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import wsModel.Cuenta;
import controller.util.GestorContrasenias;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Jose
 */
public class loginAction extends ActionSupport {
    
    private String usuario;
    private String contrasenia;
    
    public loginAction() {
    }
    
    @Override
    public String execute() throws Exception {
        CuentaWS servicio= new CuentaWS();
        GenericType<Cuenta> genericType = new GenericType<Cuenta>() {
        };
        Cuenta c=servicio.getCuentaByUsuario(genericType, usuario);
        GestorContrasenias gc = new GestorContrasenias();
        
        if(c.getContraseniaHash().equals(contrasenia)){
            return SUCCESS;
        }
        
        return ERROR;
    }

    public String getUsuario() {
        return usuario;
    }

    @RequiredStringValidator(message = "Tiene que rellenar el nombre de usuario")
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    @RequiredStringValidator(message ="Debe rellenar la contraseña")
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
}

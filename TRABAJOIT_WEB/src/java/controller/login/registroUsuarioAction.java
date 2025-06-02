/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.login;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

/**
 *
 * @author Jose
 */
public class registroUsuarioAction extends ActionSupport {
    
    private String usuario;
    private String contrasenia;
    private String correo;
    
    public registroUsuarioAction() {
    }
    
    @Override
    public String execute() throws Exception {
        return SUCCESS;
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
    @StringLengthFieldValidator(minLength = "8", message = "La contraseña debe tener almenos 8 carácteres")
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreo() {
        return correo;
    }
    

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    @Override
    public void validate(){
        if(!correo.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
            addFieldError("correo", "No es un correo válido");
        }
        
        if(!usuario.matches("\"^[a-zA-Z0-9_-]{3,20}$\"")){
            addFieldError("usuario","El nombre de usuario solo puede contener: letras, numeros, -, _");
        }
        
        //validar si el nombre de usuario o el correo ya está cogido 
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.login;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

/**
 *
 * @author Jose
 */
public class registroVendedorAction extends ActionSupport {
    
    private String usuario;
    private String contrasenia;
    private String correo;
    private String nombre;
    private String dni;
    private String telefono;
    private String nCuentaBancaria;
    
    public registroVendedorAction() {
    }
    
    @Override
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
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
    
    @RequiredStringValidator(message="Debe rellenar la contraseña")
    @StringLengthFieldValidator(minLength = "8", message = "La contraseña debe tener almenos 8 carácteres")
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public String getCorreo() {
        return correo;
    }

    @RequiredStringValidator(message = "Debe rellenar el correo")
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }
    
    @RequiredStringValidator(message = "Debe rellenar el nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }
    
    @RequiredStringValidator(message = "Debe rellenar el dni")
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    @RequiredStringValidator(message = "Debe rellenar el telefono")
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getnCuentaBancaria() {
        return nCuentaBancaria;
    }

    @RequiredStringValidator(message = "Debe rellenar la cuenta bancaria")
    public void setnCuentaBancaria(String nCuentaBancaria) {
        this.nCuentaBancaria = nCuentaBancaria;
    }
    
    @Override
    public void validate(){
        if(!correo.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
            addFieldError("correo", "No es un correo válido");
        }
        
        if(!usuario.matches("\"^[a-zA-Z0-9_-]{3,20}$\"")){
            addFieldError("usuario","El nombre de usuario solo puede contener: letras, numeros, -, _");
        }
        
        if(!telefono.matches("^\\d{9}$")){
            addFieldError("telefono", "telefono introducido es incorrecto");
        }
        
        if(!dni.matches("^\\d{8}[TRWAGMYFPDXBNJZSQVHLCKE]$")){
            addFieldError("dni", "El dni introducido es incorrecto");
        }
        //validar si el nombre de usuario o el correo ya está cogido 
        //validar cuenta bancaria
        
        
    }
    
}

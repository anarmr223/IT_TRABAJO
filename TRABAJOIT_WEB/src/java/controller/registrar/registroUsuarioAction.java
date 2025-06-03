/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.registrar;

import WS.CuentaWS;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import controller.util.GestorContrasenias;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import org.apache.struts2.interceptor.SessionAware;
import wsModel.Cuenta;
import wsModel.Usuario;

/**
 *
 * @author Jose
 */
public class registroUsuarioAction extends ActionSupport implements SessionAware{
    
    private String usuario;
    private String contrasenia;
    private String correo;
    private String repetirContrasenia;
    private Map<String, Object> session;
    
    public registroUsuarioAction() {
    }
    
    @Override
    public String execute() throws Exception {
        CuentaWS servicio= new CuentaWS();
        Cuenta c= new Cuenta();
        c.setUsuario(usuario);
        c.setCorreo(correo);
        GestorContrasenias gc= new GestorContrasenias();
        String[] passparam=gc.generarPasswordHash(contrasenia);
        c.setContraseniaHash(passparam[0]);
        c.setSalt(passparam[1]);
        Usuario u=new Usuario();
        c.setUsuarioCollection(u);
        servicio.create_XML(c);
        session.put("usuario", c);
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
    
    @RequiredStringValidator(message ="Debe rellenar el correo")
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRepetirContrasenia() {
        return repetirContrasenia;
    }

    public void setRepetirContrasenia(String repetirContrasenia) {
        this.repetirContrasenia = repetirContrasenia;
    }
    
    
    
    @Override
    public void validate(){
        if(!correo.isEmpty()&&!correo.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
            addFieldError("correo", "No es un correo válido");
        }
        
        if(!usuario.isEmpty()&&!usuario.matches("^[a-zA-Z0-9_-]{0,20}$")){
            addFieldError("usuario","El nombre de usuario solo puede contener: letras, numeros, -, _");
        }
        
        CuentaWS servicio= new CuentaWS();
        
        GenericType<Cuenta> genericType = new GenericType<Cuenta>() {
        };
        
        Cuenta c=null;
        
        if(!usuario.isEmpty()){
            c=servicio.getCuentaByUsuario(genericType, usuario);
        }
        
        if(c!=null){
            addFieldError("usuario", "El nombre de usuario ya está registrado.");
        }
        
        if(!correo.isEmpty()){
            c=servicio.getCuentaByCorreo(genericType, correo);
        }
        
        if(c!=null){
            addFieldError("correo", "El correo ya está registrado");
        }
        
        if(!contrasenia.equals(repetirContrasenia)){
            addFieldError("contrasenia", "Las contraseñas no son iguales");
        }
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session=session;
    }
}

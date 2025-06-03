/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.registrar;

import WS.CuentaWS;
import WS.UsuarioWS;
import WS.VendedorWS;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import controller.util.GestorContrasenias;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import wsModel.Cuenta;
import wsModel.Usuario;
import wsModel.Vendedor;

/**
 *
 * @author Jose
 */
public class registroCuentaAction extends ActionSupport implements SessionAware, ServletResponseAware{
    
    private String usuario;
    private String contrasenia;
    private String correo;
    private String repetirContrasenia;
    private String nombre;
    private String dni;
    private String telefono;
    private String cuenta;
    private boolean mostrarInputsVendedor;
    private Map<String, Object> session;
    private HttpServletResponse response;
    
    
    public registroCuentaAction() {
    }
    
    @Override
    public String execute() throws Exception {
        //creacion de los servicios web
            CuentaWS servicioC= new CuentaWS();
            
            //insertar valores en la cuenta
            Cuenta c= new Cuenta();
            c.setUsuario(usuario);
            c.setCorreo(correo);
            GestorContrasenias gc= new GestorContrasenias();
            String[] passparam=gc.generarPasswordHash(contrasenia);
            c.setContraseniaHash(passparam[0]);
            c.setSalt(passparam[1]);
            //creamos la cuenta en la base de datos
            servicioC.create_XML(c);
            //obtenemos la cuenta con el id generado
            GenericType<Cuenta> genericType = new GenericType<Cuenta>() {
            };
            c=servicioC.getCuentaByUsuario(genericType, usuario);
        if(!mostrarInputsVendedor){
            UsuarioWS servicioU= new UsuarioWS();
            //asociamos la cuenta con el usuario y lo registramos en la base de datos
            Usuario u=new Usuario();
            u.setIdCuenta(c);
            servicioU.create_XML(u);
            Cookie cookie=new Cookie("usuario", c.getUsuario());
            cookie.setMaxAge(60*60*24);
            response.addCookie(cookie);
            session.put("usuario", c);
            return SUCCESS;
        }else{
            VendedorWS servicioV= new VendedorWS();
            Vendedor v=new Vendedor();
            v.setIdCuenta(c);
            v.setDni(dni);
            v.setNCuentaBancaria(cuenta);
            v.setNombre(nombre);
            v.setTelefono(telefono);
            servicioV.create_XML(v);
        }
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isMostrarInputsVendedor() {
        return mostrarInputsVendedor;
    }

    public void setMostrarInputsVendedor(boolean mostrarInputsVendedor) {
        this.mostrarInputsVendedor = mostrarInputsVendedor;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
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
        
        if(mostrarInputsVendedor){
            
            if(telefono.isEmpty()){
                addFieldError("telefono", "Debe rellenar este campo");
            }
            
            if(nombre.isEmpty()){
                addFieldError("nombre", "Debe rellenar este campo");
            }
            
            if(dni.isEmpty()){
                addFieldError("nombre", "Debe rellenar este campo");
            }
            
            if(cuenta.isEmpty()){
                addFieldError("nCuentaBancaria", "Debe rellenar este campo");
            }
            
            if(!telefono.isEmpty()&&!telefono.matches("^\\d{9}$")){
                addFieldError("telefono", "telefono introducido es incorrecto");
            }
        
            if(!dni.isEmpty()&&!dni.matches("^\\d{8}[TRWAGMYFPDXBNJZSQVHLCKE]$")){
                addFieldError("dni", "El dni introducido es incorrecto");
            }
        }
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session=session;
    }

    @Override
    public void setServletResponse(HttpServletResponse hsr) {
        this.response=hsr;
    }
}

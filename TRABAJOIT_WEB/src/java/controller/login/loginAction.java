 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.login;

import WS.CuentaWS;
import WS.PublicacionWS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import controller.util.GestorContrasenias;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import model.Cuenta;
import model.Publicacion;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Jose
 */

public class loginAction extends ActionSupport implements SessionAware, ServletResponseAware{
    
    private String usuario;
    private String contrasenia;
    private Map<String, Object> session;
    private HttpServletResponse response;
    private List<Publicacion> publicaciones;
    public loginAction() {
    }
    
    @Override
    public String execute() throws Exception {
        CuentaWS servicio= new CuentaWS();
        GenericType<Cuenta> genericType = new GenericType<Cuenta>() {
        };
        Cuenta c=servicio.findCuentaByUsuario(genericType, usuario);
        GestorContrasenias gc = new GestorContrasenias();
        
        if(c!=null&&gc.verificarContrasenia(contrasenia, c.getContraseniaHash(), c.getSalt())){
            Cookie cookie=new Cookie("usuario", c.getUsuario());
            cookie.setMaxAge(60*60*24);
            response.addCookie(cookie);
            session.put("usuario", c);
        }
        else{
            addFieldError("contrasenia", "Contraseña incorrecta");
            return INPUT;
        }
        if(session.get("usuario")!=null){
            PublicacionWS servicioPublicacion=new PublicacionWS();
            GenericType<List<Publicacion>> gn= new GenericType<List<Publicacion>>(){};
            session.put("publicaciones",servicioPublicacion.getPublicacionesExcludingCuenta(gn, c.getIdCuenta()));
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
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session=session;
    }

    @Override
    public void setServletResponse(HttpServletResponse hsr) {
        this.response=hsr;
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }
    
    
    
    @Override
    public void validate(){
        CuentaWS servicio= new CuentaWS();
        GenericType<Cuenta> genericType = new GenericType<Cuenta>() {
        };
        try{
           servicio.findCuentaByUsuario(genericType, usuario); 
        }catch(Exception ex){
            addFieldError("usuario", "No existe ese usuario en la base de datos");
        }
    }
    
    
}

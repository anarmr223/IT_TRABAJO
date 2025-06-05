/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.detalle;

import WS.CuentaWS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import controller.util.GestorContrasenias;
import java.util.Map;
import model.Cuenta;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Usuario
 */

public class actualizarUsuarioAction extends ActionSupport implements SessionAware{
    
    private String usuario;
    private String correo;
    private String nombre;
    private String nCuenta;
    private String nombreTienda;
    private String telefono;
    private String oldPassword;
    private String newPassword;
    private Map<String,Object> session;
    
    
    public actualizarUsuarioAction() {
    }
    
    public String execute() throws Exception {
            
        
            GestorContrasenias gc = new GestorContrasenias();
            Cuenta c = (Cuenta)session.get("usuario");
            
            if(gc.verificarContrasenia(oldPassword,c.getContraseniaHash(),c.getSalt())){
                
                    String[] newPasswordHash = gc.generarPasswordHash(newPassword);
                    
                    c.setContraseniaHash(newPasswordHash[0]);
                    c.setSalt(newPasswordHash[1]);
                
                    session.put("usuario",c);
                
                    CuentaWS cws = new CuentaWS();
                    
                    cws.actualizarCuenta(c);
                    
                    
            }
        
        
        
        return SUCCESS;
        
        
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getnCuenta() {
        return nCuenta;
    }

    public void setnCuenta(String nCuenta) {
        this.nCuenta = nCuenta;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    

    @Override
    public void setSession(Map<String, Object> map) {
        
        this.session = map;
        
    }
    
    
    
    
}

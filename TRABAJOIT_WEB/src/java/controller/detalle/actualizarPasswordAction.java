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
import org.apache.struts2.interceptor.SessionAware;
import wsModel.Cuenta;

/**
 *
 * @author Usuario
 */
public class actualizarPasswordAction extends ActionSupport implements SessionAware{
    
    private String oldPassword;
    private String newPassword;
    private Map<String,Object> session;
    
    
    public actualizarPasswordAction() {
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
                    
                    cws.actualizarPassword(c);
                    
                    
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

    @Override
    public void setSession(Map<String, Object> map) {
        
        this.session = map;
        
    }
    
    
    
    
}

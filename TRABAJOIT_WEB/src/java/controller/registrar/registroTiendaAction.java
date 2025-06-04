/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.registrar;

import WS.TiendaWs;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import wsModel.Cuenta;
import wsModel.Tienda;

/**
 *
 * @author Jose
 */
public class registroTiendaAction extends ActionSupport implements SessionAware{
    
    private Map<String, Object> session;
    
    private String nomTienda;
    public registroTiendaAction() {
    }
    
    @Override
    public String execute() throws Exception {
        Cuenta c=(Cuenta)session.get("usuario");
        if(c==null||c.getVendedor()==null){
            return ERROR;
        }
        Tienda t= new Tienda();
        t.setIdVendedor(c.getVendedor());
        t.setNombreTienda(nomTienda);
        
        TiendaWs tiendaS= new TiendaWs();
        
        tiendaS.create_XML(t);
        
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }

    public String getNomTienda() {
        return nomTienda;
    }

    public void setNomTienda(String nomTienda) {
        this.nomTienda = nomTienda;
    }
    
}

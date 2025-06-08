
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.login;

import WS.CuentaWS;
import WS.ProductoWS;
import WS.PublicacionWS;
import WS.VendedorWS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.GenericType;
import model.Cuenta;
import model.Producto;
import model.Publicacion;
import model.Vendedor;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Jose
 */

public class autoLoginAction extends ActionSupport implements ServletRequestAware, SessionAware{
    
    private HttpServletRequest request;
    private Map<String,Object> session;
    private List<Vendedor> tiendas;
    
    public autoLoginAction() {
    }
    
    @Override
    public String execute() throws Exception {
        Cookie[] cookies=request.getCookies();
        boolean enc=false;
        int i=0;
         
            VendedorWS client= new VendedorWS();
            GenericType<List<Vendedor>> gn= new GenericType<List<Vendedor>>(){};
            try{
                tiendas = client.findAll_XML(gn);
                session.put("tiendas",tiendas);
            }catch(Exception ex){
                tiendas=null;
            }
        
        
        
        while(!enc && ( cookies!=null && i<cookies.length  )){
            enc=cookies[i].getName().equals("usuario");
            i++;
        }
        
        if(enc){
            CuentaWS servicioC=new CuentaWS();
            GenericType<Cuenta> genericType= new GenericType<Cuenta>(){};
            Cuenta c=servicioC.findCuentaByUsuario(genericType, cookies[i].getValue());
            session.put("usuario", c);
        }
        
        if(session.get("listaProductos")==null){
            List<Producto> listaProd;
            ProductoWS prod= new ProductoWS();
            GenericType<List<Producto>> genericType= new GenericType<List<Producto>>(){};
            try{
                listaProd = prod.findAll_XML(genericType);
            }catch(Exception ex){
                listaProd=null;
            }
            
            session.put("listaProductos", listaProd);
        }
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request=hsr;
    }

    @Override
    public void setSession(Map<String, Object> map) {
       this.session=map;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public List<Vendedor> getTiendas() {
        return tiendas;
    }

    public void setTiendas(List<Vendedor> tiendas) {
        this.tiendas = tiendas;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }
    
    
    
    
}

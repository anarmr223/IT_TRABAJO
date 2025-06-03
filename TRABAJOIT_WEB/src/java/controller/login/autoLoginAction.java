
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.login;

import WS.CuentaWS;
import WS.ProductoWS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.GenericType;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import wsModel.Cuenta;
import wsModel.Producto;

/**
 *
 * @author Jose
 */
public class autoLoginAction extends ActionSupport implements ServletRequestAware, SessionAware{
    
    private HttpServletRequest request;
    private Map<String,Object> session;
    private List<ProductoWS> listaProductos;
    
    public autoLoginAction() {
    }
    
    @Override
    public String execute() throws Exception {
        Cookie[] cookies=request.getCookies();
        boolean enc=false;
        int i=0;
        while(!enc&& i<cookies.length){
            enc=cookies[i].getName().equals("usuario");
            i++;
        }
        
        if(enc){
            CuentaWS servicioC=new CuentaWS();
            GenericType<Cuenta> genericType= new GenericType<Cuenta>(){};
            Cuenta c=servicioC.getCuentaByUsuario(genericType, cookies[i].getValue());
            session.put("usuario", c);
        }
        
        if(session.get("listaProductos")==null){
            List<Producto> listaProd;
            ProductoWS prod= new ProductoWS();
            GenericType<List<Producto>> genericType= new GenericType<List<Producto>>(){};
            listaProd = prod.findAll_XML(genericType);
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

    public List<ProductoWS> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<ProductoWS> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
    
    
    
}

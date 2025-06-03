
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.login;

import WS.CuentaWS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.GenericType;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import wsModel.Cuenta;

/**
 *
 * @author Jose
 */
public class autoLoginAction extends ActionSupport implements ServletRequestAware, SessionAware{
    
    private HttpServletRequest request;
    private Map<String,Object> session;
    
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
        
        
        
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request=hsr;
    }

    @Override
    public void setSession(Map<String, Object> map) {
       this.session=session;
    }
    
}

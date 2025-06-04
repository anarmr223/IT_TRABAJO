/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.login;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Jose
 */
public class logOutAction extends ActionSupport implements SessionAware, ServletResponseAware{
    
    private Map<String,Object> session;
    private HttpServletResponse response;
    
    public logOutAction() {
    }
    
    @Override
    public String execute() throws Exception {
        Cookie c=new Cookie("usuario", "");
        c.setMaxAge(-1);
        response.addCookie(c);
        session.put("usuario", null);
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session=map;
    }

    @Override
    public void setServletResponse(HttpServletResponse hsr) {
        response=hsr;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.registrar;

import WS.PublicacionWS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.Map;
import model.Cuenta;
import model.Publicacion;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Jose
 */
public class crearPublicacionAction extends ActionSupport implements SessionAware {
    
    private String comentario;
    private Map<String,Object> session;
    
    public crearPublicacionAction() {
    }
    
    @Override
    public String execute() throws Exception {
        Cuenta c=(Cuenta)session.get("usuario");
        Publicacion p=new Publicacion();
        p.setContenido(comentario);
        p.setFechaPublicacion(new Date());
        p.setIdCuenta(c);
        PublicacionWS pservicio= new PublicacionWS();
        pservicio.create_XML(p);
        return SUCCESS;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }
    
    
}

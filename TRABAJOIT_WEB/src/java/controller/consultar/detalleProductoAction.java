/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.consultar;

import com.opensymphony.xwork2.ActionSupport;
import javax.ws.rs.core.GenericType;


/**
 *
 * @author Asus
 */

public class detalleProductoAction extends ActionSupport {
    private int id;
    public detalleProductoAction() {
    }
    
    @Override
    public String execute() throws Exception {
        /*ProductoWS prod= new ProductoWS();
        GenericType<Producto> genericType = new GenericType<Producto>() {};
        Producto p =prod.findById(genericType, id);*/
        return SUCCESS;
    }
    
}

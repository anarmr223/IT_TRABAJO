/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.borrar;

import WS.ProductoWS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class borrarProductoAction extends ActionSupport {
    
    private int idProducto;
    
    
    
    public borrarProductoAction() {
    }
    
    public String execute() throws Exception {
        
        
           ProductoWS client = new ProductoWS();
           
           
           client.eliminarProductoPorId(idProducto);
        
        
           return SUCCESS;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }
    
    
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.consultar;

import WS.ProductoWS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import java.util.List;
import model.Producto;

/**
 *
 * @author Usuario
 */
public class productosBusquedaAction extends ActionSupport {
    
    private List<Producto> productos;
    private String nombreTienda;
    
    
    public productosBusquedaAction() {
    }
    
    public String execute() throws Exception {
        
        ProductoWS client = new ProductoWS();
        
        this.productos = client.findByNombre(nombreTienda);
        
        return SUCCESS;
        
        
        
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }
    
    

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }
    
    
    
    
}

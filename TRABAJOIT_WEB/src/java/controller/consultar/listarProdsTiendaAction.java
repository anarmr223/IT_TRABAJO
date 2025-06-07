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
import javax.ws.rs.core.GenericType;
import model.Producto;

/**
 *
 * @author Asus
 */
public class listarProdsTiendaAction extends ActionSupport {
    
    private List<Producto> listaProdTienda;
    private String nombreTienda;
    
    public listarProdsTiendaAction() {
    }
    
    public String execute() throws Exception {
        
        ProductoWS p = new ProductoWS();
        
       this.listaProdTienda = p.findAll_XML(new GenericType<List<Producto>>(){});
        
        
       
        
        return SUCCESS;
    }

    public List<Producto> getListaProdTienda() {
        return listaProdTienda;
    }

    public void setListaProdTienda(List<Producto> listaProdTienda) {
        this.listaProdTienda = listaProdTienda;
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

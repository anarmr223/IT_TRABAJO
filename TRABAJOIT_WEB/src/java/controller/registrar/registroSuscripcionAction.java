/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.registrar;

import WS.VendedorWS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import java.util.List;
import model.Vendedor;

/**
 *
 * @author Usuario
 */
public class registroSuscripcionAction extends ActionSupport {
    
    private int idCuenta;
    private String nombreTienda;
    
    
    public registroSuscripcionAction() {
    }
    
    public String execute() throws Exception {
        
        /*VendedorWS client = new VendedorWS();
        
        Vendedor vendedor = client.findByNombreTienda(nombreTienda).get(0);
        
        client.addSuscripcion(vendedor.getVendedorPK().getDni(),vendedor.getVendedorPK().getIdCuenta(), idCuenta);
       */         
        return SUCCESS;
        
        
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
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

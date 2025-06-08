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
import java.util.Map;
import javax.ws.rs.core.GenericType;
import model.Cuenta;
import model.Producto;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Asus
 */
public class listarProdsTiendaAction extends ActionSupport implements SessionAware{
    
    private List<Producto> listaProdTienda;
    private String nombreTienda;
    private String dni;
    private int idCuenta;
    private Map<String, Object> session;
    
    public listarProdsTiendaAction() {
    }
    
    @Override
    public String execute() throws Exception {
        
        ProductoWS p = new ProductoWS();
        Cuenta c = (Cuenta) session.get("usuario");
        
        if(dni==null && c.getVendedor()!=null){
            this.nombreTienda= c.getVendedor().getNombreTienda();
            this.dni= c.getVendedor().getVendedorPK().getDni();
            this.idCuenta= c.getVendedor().getVendedorPK().getIdCuenta();
        }
        
       this.listaProdTienda = p.findProductosByVendedor_XML(new GenericType<List<Producto>>(){},dni,idCuenta);
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }
    
    
    
    
}

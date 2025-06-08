/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.carrito;

import WS.CarritoWS;
import WS.CuentaWS;
import WS.LineaProductoWS;
import WS.ProductoWS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import model.Carrito;
import model.Cuenta;
import model.Lineaproducto;
import model.Producto;
import model.Talla;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author josem
 */
public class aniadirCarritoAction extends ActionSupport implements SessionAware {
    
    private Producto producto;
    private int cantidad;
    private String talla;
    private Map<String,Object> session;
    
    public aniadirCarritoAction() {
    }
    
    @Override
    public String execute() throws Exception {
        
        if(producto==null){
            return ERROR;
        }
        
        List<Talla> tallas= (List<Talla>) producto.getTallaCollection();
        
        boolean enc=false;
        int i=0;
        while(!enc||i<tallas.size()){
            if(tallas.get(i).getTalla().equals(talla)){
                enc=true;
            }
            i++;
        }
        
        Talla t= tallas.get(i);
        
        if(cantidad>t.getCantidad()){
            addFieldError("cantidad", "La cantidad solicitada excede el numero de disponibles");
            return INPUT;
        }
        
        t.setCantidad(t.getCantidad()-cantidad);
        
        Lineaproducto lp=new Lineaproducto();
        lp.setIdProducto(producto);
        lp.setCantidad(cantidad);
        
        Cuenta c=(Cuenta) session.get("usuario");
        Carrito carrito=c.getCarrito();
        if(carrito==null){
            carrito=new Carrito();
            carrito.setCuenta(c);
            
            c.setCarrito(carrito);
            
            CuentaWS servicioCuenta= new CuentaWS();
            
            CarritoWS cServicio= new CarritoWS();
            
            cServicio.create_XML(carrito);
            
            servicioCuenta.actualizarCuenta(c);
        }
        
        Collection<Lineaproducto> coleccionLp=carrito.getLineaproductoCollection();
        
        coleccionLp.add(lp);
        
        LineaProductoWS lpServicio= new LineaProductoWS();
        
        lpServicio.create_XML(lp);
        
        CarritoWS servicioCarrito= new CarritoWS();
        
        servicioCarrito.actualizarCarrito(carrito);
        return SUCCESS;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }
    
    
    
    public void validate(){
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }
}

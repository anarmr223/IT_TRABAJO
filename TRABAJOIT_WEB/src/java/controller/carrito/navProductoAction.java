/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.carrito;

import WS.ProductoWS;
import com.opensymphony.xwork2.ActionSupport;
import model.Producto;

/**
 *
 * @author josem
 */
public class navProductoAction extends ActionSupport {
    
    private int id;
    private Producto producto;
    
    public navProductoAction() {
    }
    
    @Override
    public String execute() throws Exception {
        ProductoWS pServicio= new ProductoWS();
        
        producto=pServicio.find(id);
        return SUCCESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}

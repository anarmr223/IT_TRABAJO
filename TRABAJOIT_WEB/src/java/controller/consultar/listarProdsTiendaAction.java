/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.consultar;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import model.Producto;

/**
 *
 * @author Asus
 */
public class listarProdsTiendaAction extends ActionSupport {
    
    private List<Producto> listaProdTienda;
    
    public listarProdsTiendaAction() {
    }
    
    public String execute() throws Exception {
        
        return SUCCESS;
    }

    public List<Producto> getListaProdTienda() {
        return listaProdTienda;
    }

    public void setListaProdTienda(List<Producto> listaProdTienda) {
        this.listaProdTienda = listaProdTienda;
    }
    
    
    
}

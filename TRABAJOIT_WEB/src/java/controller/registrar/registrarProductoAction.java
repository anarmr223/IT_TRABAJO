/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.registrar;

import com.opensymphony.xwork2.ActionSupport;
import controller.util.cargadorDeImagenes;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import wsModel.Producto;

/**
 *
 * @author Jose
 */
public class registrarProductoAction extends ActionSupport {
    
    private String nombre;
    private int stock;
    private double precio;
    private String descripcion;
    private int idTienda;
    private File miArchivo;
    private String miArchivoContentType;
    private String miArchivoFileName;
    
    public registrarProductoAction() {
    }
    
    @Override
    public String execute() throws Exception {
        List<File> misArchivos=new ArrayList();
        List<String> misArchivosContentType= new ArrayList();
        
        misArchivos.add(miArchivo);
        misArchivosContentType.add(miArchivoContentType);
        
        Producto p= new Producto();
        p.setDescripcion(descripcion);
        //p.setIdTienda(idTienda);
        p.setNombre(nombre);
        p.setPrecio(precio);
        p.setStock(stock);
        
        //String url=cargadorDeImagenes.subirImagenProducto(misArchivos, misArchivosContentType, );
        
       return SUCCESS; 
    }

    public File getMiArchivo() {
        return miArchivo;
    }

    public void setMiArchivo(File miArchivo) {
        this.miArchivo = miArchivo;
    }

    public String getMiArchivoContentType() {
        return miArchivoContentType;
    }

    public void setMiArchivoContentType(String miArchivoContentType) {
        this.miArchivoContentType = miArchivoContentType;
    }

    public String getMiArchivoFileName() {
        return miArchivoFileName;
    }

    public void setMiArchivoFileName(String miArchivoFileName) {
        this.miArchivoFileName = miArchivoFileName;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    
    
    
}

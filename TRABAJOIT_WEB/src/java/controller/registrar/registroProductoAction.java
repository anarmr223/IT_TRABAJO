/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package controller.registrar;

import WS.ProductoWS;
import com.opensymphony.xwork2.ActionSupport;
import controller.util.cargadorDeImagenes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.ws.rs.core.GenericType;
import model.Cuenta;
import model.Producto;
import model.Talla;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Jose
 */

public class registroProductoAction extends ActionSupport implements SessionAware{
    
    private String nombre;
    private String descripcion;
    private double precio;

    private File imagen;
    private String imagenContentType;
    private String imagenFileName;

    private int cantidadXS;
    private int cantidadS;
    private int cantidadM;
    private int cantidadL;
    private int cantidadXL;
    private int cantidad2XL;
    
    private Map<String, Object> session;
    
    public registroProductoAction() {
    }
    
    @Override
    public String execute() throws Exception {
       // Guardar imagen en una ruta del servidor (puedes personalizar la ruta)
            // 1. Guardar imagen en carpeta imgsProd
            String url= cargadorDeImagenes.subirImagenProducto(imagen, imagenContentType, nombre + String.valueOf(System.currentTimeMillis()));

            // 2. Crear producto
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPrecio(precio);
            producto.setStock(0);
            producto.setURLImagen(url);
            Cuenta c = (Cuenta) session.get("usuario");
            producto.setDni(c.getVendedor());
            ProductoWS em= new ProductoWS();
            em.create_XML(producto);

            // Creamos tallas y asociarlas al producto
            String[] tallas = {"XS", "S", "M", "L", "XL", "2XL"};
            int[] cantidades = {cantidadXS, cantidadS, cantidadM, cantidadL, cantidadXL, cantidad2XL};
            int stock=0;
            /*
            List<Talla> tallaList = new ArrayList<>();
            for (int i = 0; i < tallas.length; i++) {
                stock+=cantidades[i];
                Talla talla = new Talla();
                talla.setTalla(tallas[i]);
                talla.setCantidad(cantidades[i]);
                talla.setIdProducto(producto); // relación inversa
                tallaList.add(talla);
            }
            producto.setStock(stock);
            producto.setTallaCollection(tallaList);
*/

           
           // Guardar producto en base de datos
           em.create_XML(producto);
           return SUCCESS;
        }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public File getImagen() {
        return imagen;
    }

    public void setImagen(File imagen) {
        this.imagen = imagen;
    }

    public String getImagenContentType() {
        return imagenContentType;
    }

    public void setImagenContentType(String imagenContentType) {
        this.imagenContentType = imagenContentType;
    }

    public String getImagenFileName() {
        return imagenFileName;
    }

    public void setImagenFileName(String imagenFileName) {
        this.imagenFileName = imagenFileName;
    }

    public int getCantidadXS() {
        return cantidadXS;
    }

    public void setCantidadXS(int cantidadXS) {
        this.cantidadXS = cantidadXS;
    }

    public int getCantidadS() {
        return cantidadS;
    }

    public void setCantidadS(int cantidadS) {
        this.cantidadS = cantidadS;
    }

    public int getCantidadM() {
        return cantidadM;
    }

    public void setCantidadM(int cantidadM) {
        this.cantidadM = cantidadM;
    }

    public int getCantidadL() {
        return cantidadL;
    }

    public void setCantidadL(int cantidadL) {
        this.cantidadL = cantidadL;
    }

    public int getCantidadXL() {
        return cantidadXL;
    }

    public void setCantidadXL(int cantidadXL) {
        this.cantidadXL = cantidadXL;
    }

    public int getCantidad2XL() {
        return cantidad2XL;
    }

    public void setCantidad2XL(int cantidad2XL) {
        this.cantidad2XL = cantidad2XL;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }
    
}
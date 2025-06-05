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
import javax.ws.rs.core.GenericType;
import model.Producto;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Jose
 */

public class registroProductoAction extends ActionSupport {
    
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
    
    public registroProductoAction() {
    }
    
    @Override
    public String execute() throws Exception {
       // Guardar imagen en una ruta del servidor (puedes personalizar la ruta)
        String path = ServletActionContext.getServletContext().getRealPath("/uploads");
        File dir = new File(path);
        if (!dir.exists()) dir.mkdirs();

        File destFile = new File(dir, imagenFileName);
        try (InputStream in = new FileInputStream(imagen);
             OutputStream out = new FileOutputStream(destFile)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        }

        // Crear el producto
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setURLImagen("uploads/" + imagenFileName); // o guardar en base64 o blob según tu modelo

        // Asignar cantidades por talla

        
        ProductoWS em= new ProductoWS();
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
    
}
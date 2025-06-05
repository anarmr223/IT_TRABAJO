/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package controller.registrar;

import com.opensymphony.xwork2.ActionSupport;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import controller.util.cargadorDeImagenes;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;
import model.Producto;

/**
 *
 * @author Jose
 */

public class registroProductoAction extends ActionSupport {
    
      private String nombre;
    private String descripcion;
    private int precio;

    // Imagen subida
    private File imagen1;
    private String imagen1FileName; // Struts automáticamente mapea esto
    private String imagen1ContentType;

    // Cantidades por talla
    private int cantidadXS;
    private int cantidadS;
    private int cantidadM;
    private int cantidadL;
    private int cantidadXL;
    private int cantidad2XL;

    // Aquí va tu lógica para registrar el producto
    @Override
    public String execute() {
        try {
            // 1. Validar datos (puedes usar validate() también si prefieres)
            

            // 2. Guardar la imagen (ejemplo: en disco)
            //String path = request.getServletContext().getRealPath("/imagenes");
           // File destino = new File(path, imagen1FileName);
           // imagen1.renameTo(destino);

            // 3. Crear objeto Producto (ejemplo)
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPrecio(precio);
            producto.setURLImagen("/imagenes/" + imagen1FileName);

            // 4. Guardar en base de datos (esto depende de tu capa DAO o JPA)
            // productoDAO.save(producto);

            // 5. Guardar tallas si es necesario (puedes usar una lista/mapa)

            return SUCCESS;

        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Error al registrar el producto: " + e.getMessage());
            return ERROR;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.registrar;

import WS.ProductoWS;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import model.Producto;
import model.Talla;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Usuario
 */
public class editarProductoAction extends ActionSupport {
    
    private int idProducto;
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
    
    
    public editarProductoAction() {
    }
    
    public String execute() throws Exception {
        
        
         String folderRelativo = "imgsProd";
            ServletContext context = ServletActionContext.getServletContext();
            String pathAbsoluto = context.getRealPath("/" + folderRelativo);

            File folder = new File(pathAbsoluto);
            if (!folder.exists()) folder.mkdirs();

            // Nombre único (para evitar sobrescribir)
            String nombreImagenUnico = UUID.randomUUID().toString() + "_" + imagenFileName;
            File destino = new File(folder, nombreImagenUnico);

            
            
            try (InputStream in = new FileInputStream(imagen);
                 OutputStream out = new FileOutputStream(destino)) {
                byte[] buffer = new byte[1024];
                int len;
                while ((len = in.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
            }
            
            

            // 2. Crear producto
            
            ProductoWS em= new ProductoWS();
            
            Producto producto = em.find(idProducto);
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setPrecio(precio);
            producto.setURLImagen(folderRelativo + "/" + nombreImagenUnico);

            // Creamos tallas y asociarlas al producto
            String[] tallas = {"XS", "S", "M", "L", "XL", "2XL"};
            int[] cantidades = {cantidadXS, cantidadS, cantidadM, cantidadL, cantidadXL, cantidad2XL};

            List<Talla> tallaList = new ArrayList<>();
            for (int i = 0; i < tallas.length; i++) {
                Talla talla = new Talla();
                talla.setTalla(tallas[i]);
                talla.setCantidad(cantidades[i]);
                talla.setIdProducto(producto); // relación inversa
                tallaList.add(talla);
            }

            producto.setTallaCollection(tallaList);

           
           // Guardar producto en base de datos
           em.edit_XML(idProducto, producto);
           return SUCCESS;
        
        
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }
    
    
    
    
    
}

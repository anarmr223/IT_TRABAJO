/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.util;

import static com.opensymphony.xwork2.Action.INPUT;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Jose
 */

/*
Propiedades para el archivo subido (input type="file" con name="miArchivo")
private File miArchivo; // Representa el archivo temporal subido
    private String miArchivoContentType; // Tipo MIME del archivo (ej. image/jpeg)
    private String miArchivoFileName; // Nombre original del archivo*/
public class cargadorDeImagenes {
    public static String subirImagenProducto(File archivo,String contentType,String idProducto){
        if(archivo==null){
            return null;
        }
        
        try{
            ServletContext servletContext = ServletActionContext.getServletContext();
            // Construir la ruta de la carpeta "imagenes" dentro del contexto web
            String directorioImagenesWeb = servletContext.getRealPath("/imagenes/productos"); // La '/' al inicio indica la raíz del contexto web
            directorioImagenesWeb=directorioImagenesWeb+"/"+idProducto;
            
            
            
            File uploadDir= new File(directorioImagenesWeb);
            
            
            if(uploadDir.exists()){
                for(File f: uploadDir.listFiles()){
                    f.delete();
                }
                uploadDir.delete();
            }
            
            uploadDir.mkdirs();
            
            String extension="."+contentType.split("/")[1];
            File archivoDestino=new File(directorioImagenesWeb, "producto"+extension);
            org.apache.commons.io.FileUtils.copyFile(archivo, archivoDestino);
            
            
            return "/web/imagenes/productos/" +idProducto+extension;
        }catch(  IOException ex){
            return null;
        }
    }
    
    
}

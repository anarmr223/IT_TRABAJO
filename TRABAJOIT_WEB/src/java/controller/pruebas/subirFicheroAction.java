/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.pruebas;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jose
 */
public class subirFicheroAction extends ActionSupport {

    private String usuario;

    // Propiedades para miArchivo1
    private File miArchivo1;
    private String miArchivo1ContentType;
    private String miArchivo1FileName; // ¡Añadida esta propiedad!

    // Propiedades para miArchivo2
    private File miArchivo2;
    private String miArchivo2ContentType;
    private String miArchivo2FileName; // ¡Añadida esta propiedad!

    // Propiedades para miArchivo3
    private File miArchivo3;
    private String miArchivo3ContentType;
    private String miArchivo3FileName; // ¡Añadida esta propiedad!

    // Propiedades para miArchivo4
    private File miArchivo4;
    private String miArchivo4ContentType;
    private String miArchivo4FileName; // ¡Añadida esta propiedad!

    public subirFicheroAction() {
    }

    @Override
    public String execute() throws Exception {
        // Creamos las listas para los archivos, sus tipos de contenido y sus nombres
        List<File> misArchivos = new ArrayList<>();
        List<String> misArchivosContentType = new ArrayList<>();
        List<String> misArchivosFileName = new ArrayList<>(); // ¡Nueva lista para los nombres de archivo!

        // Añadimos los archivos y sus metadatos si no son nulos (si se seleccionó un archivo en el formulario)
        if (miArchivo1 != null) {
            misArchivos.add(miArchivo1);
            misArchivosContentType.add(miArchivo1ContentType);
            misArchivosFileName.add(miArchivo1FileName);
        }
        if (miArchivo2 != null) {
            misArchivos.add(miArchivo2);
            misArchivosContentType.add(miArchivo2ContentType);
            misArchivosFileName.add(miArchivo2FileName);
        }
        if (miArchivo3 != null) {
            misArchivos.add(miArchivo3);
            misArchivosContentType.add(miArchivo3ContentType);
            misArchivosFileName.add(miArchivo3FileName);
        }
        if (miArchivo4 != null) {
            misArchivos.add(miArchivo4);
            misArchivosContentType.add(miArchivo4ContentType);
            misArchivosFileName.add(miArchivo4FileName);
        }
        
        // Llamamos a tu método utilitario, pasando también la lista de nombres de archivo
        // Necesitarás adaptar el método subirImagenProducto para aceptar este nuevo parámetro
        controller.util.cargadorDeImagenes.subirImagenProducto(misArchivos, misArchivosContentType, usuario);
        
        addActionMessage("Archivos procesados exitosamente!");
        return SUCCESS;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    // Getters y Setters para miArchivo1
    public File getMiArchivo1() {
        return miArchivo1;
    }

    public void setMiArchivo1(File miArchivo1) { // Cambiado a miArchivo1 para consistencia
        this.miArchivo1 = miArchivo1;
    }

    public String getMiArchivo1ContentType() {
        return miArchivo1ContentType;
    }

    public void setMiArchivo1ContentType(String miArchivo1ContentType) {
        this.miArchivo1ContentType = miArchivo1ContentType;
    }

    public String getMiArchivo1FileName() { // Getter para el nombre de archivo
        return miArchivo1FileName;
    }

    public void setMiArchivo1FileName(String miArchivo1FileName) { // Setter para el nombre de archivo
        this.miArchivo1FileName = miArchivo1FileName;
    }

    // Getters y Setters para miArchivo2
    public File getMiArchivo2() {
        return miArchivo2;
    }

    public void setMiArchivo2(File miArchivo2) {
        this.miArchivo2 = miArchivo2;
    }

    public String getMiArchivo2ContentType() {
        return miArchivo2ContentType;
    }

    public void setMiArchivo2ContentType(String miArchivo2ContentType) {
        this.miArchivo2ContentType = miArchivo2ContentType;
    }

    public String getMiArchivo2FileName() { // Getter para el nombre de archivo
        return miArchivo2FileName;
    }

    public void setMiArchivo2FileName(String miArchivo2FileName) { // Setter para el nombre de archivo
        this.miArchivo2FileName = miArchivo2FileName;
    }

    // Getters y Setters para miArchivo3
    public File getMiArchivo3() {
        return miArchivo3;
    }

    public void setMiArchivo3(File miArchivo3) {
        this.miArchivo3 = miArchivo3;
    }

    public String getMiArchivo3ContentType() {
        return miArchivo3ContentType;
    }

    public void setMiArchivo3ContentType(String miArchivo3ContentType) {
        this.miArchivo3ContentType = miArchivo3ContentType;
    }

    public String getMiArchivo3FileName() { // Getter para el nombre de archivo
        return miArchivo3FileName;
    }

    public void setMiArchivo3FileName(String miArchivo3FileName) { // Setter para el nombre de archivo
        this.miArchivo3FileName = miArchivo3FileName;
    }

    // Getters y Setters para miArchivo4
    public File getMiArchivo4() {
        return miArchivo4;
    }

    public void setMiArchivo4(File miArchivo4) {
        this.miArchivo4 = miArchivo4;
    }

    public String getMiArchivo4ContentType() {
        return miArchivo4ContentType;
    }

    public void setMiArchivo4ContentType(String miArchivo4ContentType) {
        this.miArchivo4ContentType = miArchivo4ContentType;
    }

    public String getMiArchivo4FileName() { // Getter para el nombre de archivo
        return miArchivo4FileName;
    }

    public void setMiArchivo4FileName(String miArchivo4FileName) { // Setter para el nombre de archivo
        this.miArchivo4FileName = miArchivo4FileName;
    }
}
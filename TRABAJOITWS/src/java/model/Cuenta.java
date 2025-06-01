/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jose
 */
@XmlRootElement
public class Cuenta {
    
    private Integer id;
    private String usuario;
    private String contraseniaHash;
    private String salt;
    private String correo;

    public Cuenta() {
    }

    public Cuenta(Integer id, String usuario, String contraseniaHash, String salt, String correo) {
        this.id = id;
        this.usuario = usuario;
        this.contraseniaHash = contraseniaHash;
        this.salt = salt;
        this.correo = correo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseniaHash() {
        return contraseniaHash;
    }

    public void setContraseniaHash(String contraseniaHash) {
        this.contraseniaHash = contraseniaHash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
}

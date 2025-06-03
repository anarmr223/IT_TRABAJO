/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jose
 */
@Entity
@Table(name = "talla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Talla.findAll", query = "SELECT t FROM Talla t")
    , @NamedQuery(name = "Talla.findById", query = "SELECT t FROM Talla t WHERE t.id = :id")
    , @NamedQuery(name = "Talla.findByXs", query = "SELECT t FROM Talla t WHERE t.xs = :xs")
    , @NamedQuery(name = "Talla.findByS", query = "SELECT t FROM Talla t WHERE t.s = :s")
    , @NamedQuery(name = "Talla.findByM", query = "SELECT t FROM Talla t WHERE t.m = :m")
    , @NamedQuery(name = "Talla.findByL", query = "SELECT t FROM Talla t WHERE t.l = :l")
    , @NamedQuery(name = "Talla.findByXl", query = "SELECT t FROM Talla t WHERE t.xl = :xl")
    , @NamedQuery(name = "Talla.findByXl1", query = "SELECT t FROM Talla t WHERE t.xl1 = :xl1")
    , @NamedQuery(name = "Talla.findByIdProducto", query = "SELECT t FROM Talla t WHERE t.idProducto = :idProducto")})
public class Talla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "XS")
    private int xs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "S")
    private int s;
    @Basic(optional = false)
    @NotNull
    @Column(name = "M")
    private int m;
    @Basic(optional = false)
    @NotNull
    @Column(name = "L")
    private int l;
    @Basic(optional = false)
    @NotNull
    @Column(name = "XL")
    private int xl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "2XL")
    private int xl1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProducto")
    private int idProducto;

    public Talla() {
    }

    public Talla(String id) {
        this.id = id;
    }

    public Talla(String id, int xs, int s, int m, int l, int xl, int xl1, int idProducto) {
        this.id = id;
        this.xs = xs;
        this.s = s;
        this.m = m;
        this.l = l;
        this.xl = xl;
        this.xl1 = xl1;
        this.idProducto = idProducto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getXs() {
        return xs;
    }

    public void setXs(int xs) {
        this.xs = xs;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getXl() {
        return xl;
    }

    public void setXl(int xl) {
        this.xl = xl;
    }

    public int getXl1() {
        return xl1;
    }

    public void setXl1(int xl1) {
        this.xl1 = xl1;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Talla)) {
            return false;
        }
        Talla other = (Talla) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Talla[ id=" + id + " ]";
    }
    
}

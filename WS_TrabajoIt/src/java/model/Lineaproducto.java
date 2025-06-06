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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "lineaproducto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineaproducto.findAll", query = "SELECT l FROM Lineaproducto l")
    , @NamedQuery(name = "Lineaproducto.findByIdLinea", query = "SELECT l FROM Lineaproducto l WHERE l.idLinea = :idLinea")
    , @NamedQuery(name = "Lineaproducto.findByCantidad", query = "SELECT l FROM Lineaproducto l WHERE l.cantidad = :cantidad")})
public class Lineaproducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLinea")
    private Integer idLinea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @ManyToOne(optional = false)
    @JoinColumns({ // <--- ¡Añade esta anotación en plural!
        @JoinColumn(name = "idCarrito", referencedColumnName = "idCarrito", insertable = false, updatable = false),
        @JoinColumn(name = "idCuenta", referencedColumnName = "idCuenta", insertable = false, updatable = false)
    })
    private Carrito idCarrito;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false)
    private Producto idProducto;

    public Lineaproducto() {
    }

    public Lineaproducto(Integer idLinea) {
        this.idLinea = idLinea;
    }

    public Lineaproducto(Integer idLinea, int cantidad) {
        this.idLinea = idLinea;
        this.cantidad = cantidad;
    }

    public Integer getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(Integer idLinea) {
        this.idLinea = idLinea;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Carrito getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Carrito idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLinea != null ? idLinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineaproducto)) {
            return false;
        }
        Lineaproducto other = (Lineaproducto) object;
        if ((this.idLinea == null && other.idLinea != null) || (this.idLinea != null && !this.idLinea.equals(other.idLinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Lineaproducto[ idLinea=" + idLinea + " ]";
    }
    
}

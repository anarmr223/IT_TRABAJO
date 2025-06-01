/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jose
 */
@Entity
@Table(name = "lineaproducto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineaproducto.findAll", query = "SELECT l FROM Lineaproducto l")
    , @NamedQuery(name = "Lineaproducto.findById", query = "SELECT l FROM Lineaproducto l WHERE l.id = :id")
    , @NamedQuery(name = "Lineaproducto.findByCantidad", query = "SELECT l FROM Lineaproducto l WHERE l.cantidad = :cantidad")})
public class Lineaproducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "idCarrito", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Carrito idCarrito;
    @JoinColumn(name = "idProducto", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Producto idProducto;

    public Lineaproducto() {
    }

    public Lineaproducto(Integer id) {
        this.id = id;
    }

    public Lineaproducto(Integer id, int cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineaproducto)) {
            return false;
        }
        Lineaproducto other = (Lineaproducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ws.Lineaproducto[ id=" + id + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "carrito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carrito.findAll", query = "SELECT c FROM Carrito c")
    , @NamedQuery(name = "Carrito.findByIdCarrito", query = "SELECT c FROM Carrito c WHERE c.carritoPK.idCarrito = :idCarrito")
    , @NamedQuery(name = "Carrito.findByIdCuenta", query = "SELECT c FROM Carrito c WHERE c.carritoPK.idCuenta = :idCuenta")})
public class Carrito implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CarritoPK carritoPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCarrito")
    private Collection<Venta> ventaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCarrito")
    private Collection<Lineaproducto> lineaproductoCollection;
    @JoinColumn(name = "idCuenta", referencedColumnName = "idCuenta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cuenta cuenta;

    public Carrito() {
    }

    public Carrito(CarritoPK carritoPK) {
        this.carritoPK = carritoPK;
    }

    public Carrito(int idCarrito, int idCuenta) {
        this.carritoPK = new CarritoPK(idCarrito, idCuenta);
    }

    public CarritoPK getCarritoPK() {
        return carritoPK;
    }

    public void setCarritoPK(CarritoPK carritoPK) {
        this.carritoPK = carritoPK;
    }

    @XmlTransient
    public Collection<Venta> getVentaCollection() {
        return ventaCollection;
    }

    public void setVentaCollection(Collection<Venta> ventaCollection) {
        this.ventaCollection = ventaCollection;
    }

    @XmlTransient
    public Collection<Lineaproducto> getLineaproductoCollection() {
        return lineaproductoCollection;
    }

    public void setLineaproductoCollection(Collection<Lineaproducto> lineaproductoCollection) {
        this.lineaproductoCollection = lineaproductoCollection;
    }
    
    @XmlTransient
    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carritoPK != null ? carritoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrito)) {
            return false;
        }
        Carrito other = (Carrito) object;
        if ((this.carritoPK == null && other.carritoPK != null) || (this.carritoPK != null && !this.carritoPK.equals(other.carritoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Carrito[ carritoPK=" + carritoPK + " ]";
    }
    
}

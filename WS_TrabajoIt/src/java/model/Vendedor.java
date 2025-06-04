/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "vendedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v")
    , @NamedQuery(name = "Vendedor.findByDni", query = "SELECT v FROM Vendedor v WHERE v.vendedorPK.dni = :dni")
    , @NamedQuery(name = "Vendedor.findByIdCuenta", query = "SELECT v FROM Vendedor v WHERE v.vendedorPK.idCuenta = :idCuenta")
    , @NamedQuery(name = "Vendedor.findByNombre", query = "SELECT v FROM Vendedor v WHERE v.nombre = :nombre")
    , @NamedQuery(name = "Vendedor.findByNCuentaBancaria", query = "SELECT v FROM Vendedor v WHERE v.nCuentaBancaria = :nCuentaBancaria")
    , @NamedQuery(name = "Vendedor.findByNombreTienda", query = "SELECT v FROM Vendedor v WHERE v.nombreTienda = :nombreTienda")
    , @NamedQuery(name = "Vendedor.findByTelefono", query = "SELECT v FROM Vendedor v WHERE v.telefono = :telefono")})
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VendedorPK vendedorPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nombre")
    private int nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nCuentaBancaria")
    private String nCuentaBancaria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombreTienda")
    private String nombreTienda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "telefono")
    private String telefono;
    @JoinTable(name = "suscripcion", joinColumns = {
        // Debes mapear AMBOS componentes de la clave primaria compuesta de VendedorPK
        @JoinColumn(name = "dni", referencedColumnName = "dni"), // Columna en 'suscripcion' que mapea a VendedorPK.dni
        @JoinColumn(name = "idCuenta", referencedColumnName = "idCuenta") // Columna en 'suscripcion' que mapea a VendedorPK.idCuenta
    }, inverseJoinColumns = {
        // Asumiendo que 'Cuenta' tiene un solo ID (idCuenta) como clave primaria.
        // Si 'Cuenta' también tiene una clave compuesta, deberías añadir los otros campos aquí.
        // Por ahora, lo dejamos como está en tu código original para inverseJoinColumns.
        @JoinColumn(name = "idCuenta", referencedColumnName = "idCuenta") // Columna en 'suscripcion' que mapea a Cuenta.idCuenta
    })
    @ManyToMany
    private Collection<Cuenta> cuentaCollection;
    @JoinColumn(name = "idCuenta", referencedColumnName = "idCuenta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cuenta cuenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedor")
    private Collection<Venta> ventaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dni")
    private Collection<Producto> productoCollection;

    public Vendedor() {
    }

    public Vendedor(VendedorPK vendedorPK) {
        this.vendedorPK = vendedorPK;
    }

    public Vendedor(VendedorPK vendedorPK, int nombre, String nCuentaBancaria, String nombreTienda, String telefono) {
        this.vendedorPK = vendedorPK;
        this.nombre = nombre;
        this.nCuentaBancaria = nCuentaBancaria;
        this.nombreTienda = nombreTienda;
        this.telefono = telefono;
    }

    public Vendedor(String dni, int idCuenta) {
        this.vendedorPK = new VendedorPK(dni, idCuenta);
    }

    public VendedorPK getVendedorPK() {
        return vendedorPK;
    }

    public void setVendedorPK(VendedorPK vendedorPK) {
        this.vendedorPK = vendedorPK;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public String getNCuentaBancaria() {
        return nCuentaBancaria;
    }

    public void setNCuentaBancaria(String nCuentaBancaria) {
        this.nCuentaBancaria = nCuentaBancaria;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public Collection<Cuenta> getCuentaCollection() {
        return cuentaCollection;
    }

    public void setCuentaCollection(Collection<Cuenta> cuentaCollection) {
        this.cuentaCollection = cuentaCollection;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @XmlTransient
    public Collection<Venta> getVentaCollection() {
        return ventaCollection;
    }

    public void setVentaCollection(Collection<Venta> ventaCollection) {
        this.ventaCollection = ventaCollection;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendedorPK != null ? vendedorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.vendedorPK == null && other.vendedorPK != null) || (this.vendedorPK != null && !this.vendedorPK.equals(other.vendedorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vendedor[ vendedorPK=" + vendedorPK + " ]";
    }
    
}

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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto")
    , @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio")
    , @NamedQuery(name = "Producto.findByStock", query = "SELECT p FROM Producto p WHERE p.stock = :stock")
    , @NamedQuery(name = "Producto.findByURLImagen", query = "SELECT p FROM Producto p WHERE p.uRLImagen = :uRLImagen")
    , @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Producto.findByVendedor", query="SELECT p FROM Producto p WHERE p.dni = :vendedor")})
    

public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProducto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private int stock;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "URLImagen")
    private String uRLImagen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private Collection<Talla> tallaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private Collection<Lineaproducto> lineaproductoCollection;
    
    @ManyToOne(optional = false) // Or adjust the optionality as per your DB schema
    @JoinColumns({
        @JoinColumn(name = "dni", referencedColumnName = "dni"), // Removed insertable/updatable
        @JoinColumn(name = "idCuenta", referencedColumnName = "idCuenta") // Removed insertable/updatable
    })
    private Vendedor dni;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Integer idProducto, int precio, int stock, String uRLImagen, String nombre) {
        this.idProducto = idProducto;
        this.precio = precio;
        this.stock = stock;
        this.uRLImagen = uRLImagen;
        this.nombre = nombre;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getURLImagen() {
        return uRLImagen;
    }

    public void setURLImagen(String uRLImagen) {
        this.uRLImagen = uRLImagen;
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
    public Collection<Talla> getTallaCollection() {
        return tallaCollection;
    }

    public void setTallaCollection(Collection<Talla> tallaCollection) {
        this.tallaCollection = tallaCollection;
    }

    @XmlTransient
    public Collection<Lineaproducto> getLineaproductoCollection() {
        return lineaproductoCollection;
    }

    public void setLineaproductoCollection(Collection<Lineaproducto> lineaproductoCollection) {
        this.lineaproductoCollection = lineaproductoCollection;
    }

    
    public Vendedor getDni() {
        return dni;
    }

    public void setDni(Vendedor dni) {
        this.dni = dni;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Producto[ idProducto=" + idProducto + " ]";
    }
    
}

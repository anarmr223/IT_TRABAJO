/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsModel;

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
@Table(name = "suscripcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Suscripcion.findAll", query = "SELECT s FROM Suscripcion s")
    , @NamedQuery(name = "Suscripcion.findById", query = "SELECT s FROM Suscripcion s WHERE s.id = :id")
    , @NamedQuery(name = "Suscripcion.findByFechaSuscripcion", query = "SELECT s FROM Suscripcion s WHERE s.fechaSuscripcion = :fechaSuscripcion")})
public class Suscripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaSuscripcion")
    private int fechaSuscripcion;
    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "idTienda", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Tienda idTienda;

    public Suscripcion() {
    }

    public Suscripcion(Integer id) {
        this.id = id;
    }

    public Suscripcion(Integer id, int fechaSuscripcion) {
        this.id = id;
        this.fechaSuscripcion = fechaSuscripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getFechaSuscripcion() {
        return fechaSuscripcion;
    }

    public void setFechaSuscripcion(int fechaSuscripcion) {
        this.fechaSuscripcion = fechaSuscripcion;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Tienda getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(Tienda idTienda) {
        this.idTienda = idTienda;
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
        if (!(object instanceof Suscripcion)) {
            return false;
        }
        Suscripcion other = (Suscripcion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "wsModel.Suscripcion[ id=" + id + " ]";
    }
    
}

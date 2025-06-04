/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Asus
 */
@Embeddable
public class CarritoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idCarrito")
    private int idCarrito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCuenta")
    private int idCuenta;

    public CarritoPK() {
    }

    public CarritoPK(int idCarrito, int idCuenta) {
        this.idCarrito = idCarrito;
        this.idCuenta = idCuenta;
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCarrito;
        hash += (int) idCuenta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarritoPK)) {
            return false;
        }
        CarritoPK other = (CarritoPK) object;
        if (this.idCarrito != other.idCarrito) {
            return false;
        }
        if (this.idCuenta != other.idCuenta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CarritoPK[ idCarrito=" + idCarrito + ", idCuenta=" + idCuenta + " ]";
    }
    
}

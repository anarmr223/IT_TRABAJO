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
public class PagoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idPago")
    private String idPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idVenta")
    private int idVenta;

    public PagoPK() {
    }

    public PagoPK(String idPago, int idVenta) {
        this.idPago = idPago;
        this.idVenta = idVenta;
    }

    public String getIdPago() {
        return idPago;
    }

    public void setIdPago(String idPago) {
        this.idPago = idPago;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash +=  idPago.hashCode();
        hash += (int) idVenta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoPK)) {
            return false;
        }
        PagoPK other = (PagoPK) object;
        if (this.idPago != other.idPago) {
            return false;
        }
        if (this.idVenta != other.idVenta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PagoPK[ idPago=" + idPago + ", idVenta=" + idVenta + " ]";
    }
    
}

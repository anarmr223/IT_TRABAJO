package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Carrito;
import model.Cuenta;
import model.Pago;
import model.Vendedor;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2025-06-05T03:28:54")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Carrito> idCarrito;
    public static volatile SingularAttribute<Venta, Vendedor> vendedor;
    public static volatile SingularAttribute<Venta, Cuenta> idCuenta;
    public static volatile SingularAttribute<Venta, Integer> idVenta;
    public static volatile CollectionAttribute<Venta, Pago> pagoCollection;

}
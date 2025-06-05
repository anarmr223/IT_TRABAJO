package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.CarritoPK;
import model.Cuenta;
import model.Lineaproducto;
import model.Venta;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2025-06-05T03:28:54")
@StaticMetamodel(Carrito.class)
public class Carrito_ { 

    public static volatile SingularAttribute<Carrito, CarritoPK> carritoPK;
    public static volatile CollectionAttribute<Carrito, Venta> ventaCollection;
    public static volatile CollectionAttribute<Carrito, Lineaproducto> lineaproductoCollection;
    public static volatile SingularAttribute<Carrito, Cuenta> cuenta;

}
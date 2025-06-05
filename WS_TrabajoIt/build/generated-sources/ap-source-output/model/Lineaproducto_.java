package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Carrito;
import model.Producto;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2025-06-05T18:22:15")
@StaticMetamodel(Lineaproducto.class)
public class Lineaproducto_ { 

    public static volatile SingularAttribute<Lineaproducto, Integer> idLinea;
    public static volatile SingularAttribute<Lineaproducto, Carrito> idCarrito;
    public static volatile SingularAttribute<Lineaproducto, Integer> cantidad;
    public static volatile SingularAttribute<Lineaproducto, Producto> idProducto;

}
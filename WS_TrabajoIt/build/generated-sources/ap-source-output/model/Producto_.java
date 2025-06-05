package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Lineaproducto;
import model.Talla;
import model.Vendedor;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2025-06-05T12:41:08")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, Integer> precio;
    public static volatile SingularAttribute<Producto, String> uRLImagen;
    public static volatile CollectionAttribute<Producto, Lineaproducto> lineaproductoCollection;
    public static volatile SingularAttribute<Producto, Integer> idProducto;
    public static volatile SingularAttribute<Producto, Integer> stock;
    public static volatile SingularAttribute<Producto, String> nombre;
    public static volatile SingularAttribute<Producto, Vendedor> dni;
    public static volatile CollectionAttribute<Producto, Talla> tallaCollection;

}
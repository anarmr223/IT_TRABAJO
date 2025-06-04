package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Carrito;
import model.Publicacion;
import model.Vendedor;
import model.Venta;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2025-06-05T00:43:44")
@StaticMetamodel(Cuenta.class)
public class Cuenta_ { 

    public static volatile SingularAttribute<Cuenta, String> contraseniaHash;
    public static volatile SingularAttribute<Cuenta, String> salt;
    public static volatile CollectionAttribute<Cuenta, Vendedor> vendedorCollection1;
    public static volatile CollectionAttribute<Cuenta, Venta> ventaCollection;
    public static volatile SingularAttribute<Cuenta, String> correo;
    public static volatile CollectionAttribute<Cuenta, Carrito> carritoCollection;
    public static volatile SingularAttribute<Cuenta, String> usuario;
    public static volatile SingularAttribute<Cuenta, Integer> idCuenta;
    public static volatile CollectionAttribute<Cuenta, Publicacion> publicacionCollection;
    public static volatile CollectionAttribute<Cuenta, Vendedor> vendedorCollection;

}
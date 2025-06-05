package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cuenta;
import model.Producto;
import model.VendedorPK;
import model.Venta;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2025-06-05T18:58:58")
@StaticMetamodel(Vendedor.class)
public class Vendedor_ { 

    public static volatile CollectionAttribute<Vendedor, Venta> ventaCollection;
    public static volatile SingularAttribute<Vendedor, String> nCuentaBancaria;
    public static volatile SingularAttribute<Vendedor, Cuenta> cuenta;
    public static volatile SingularAttribute<Vendedor, VendedorPK> vendedorPK;
    public static volatile SingularAttribute<Vendedor, String> nombreTienda;
    public static volatile CollectionAttribute<Vendedor, Producto> productoCollection;
    public static volatile SingularAttribute<Vendedor, String> telefono;
    public static volatile SingularAttribute<Vendedor, String> nombre;
    public static volatile CollectionAttribute<Vendedor, Cuenta> cuentaCollection;

}
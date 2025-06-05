package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.PagoPK;
import model.Venta;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2025-06-05T18:22:15")
@StaticMetamodel(Pago.class)
public class Pago_ { 

    public static volatile SingularAttribute<Pago, String> descripcion;
    public static volatile SingularAttribute<Pago, Date> fecha;
    public static volatile SingularAttribute<Pago, PagoPK> pagoPK;
    public static volatile SingularAttribute<Pago, Double> total;
    public static volatile SingularAttribute<Pago, Venta> venta;
    public static volatile SingularAttribute<Pago, Boolean> pagado;
    public static volatile SingularAttribute<Pago, String> metodo;

}
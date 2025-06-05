package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Cuenta;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2025-06-05T18:22:15")
@StaticMetamodel(Publicacion.class)
public class Publicacion_ { 

    public static volatile SingularAttribute<Publicacion, String> contenido;
    public static volatile SingularAttribute<Publicacion, Date> fechaPublicacion;
    public static volatile SingularAttribute<Publicacion, Cuenta> idCuenta;
    public static volatile SingularAttribute<Publicacion, Integer> idPublicacion;

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import model.Carrito;
import model.CarritoPK;

/**
 *
 * @author Asus
 */
@Stateless
@Path("model.carrito")
public class CarritoFacadeREST extends AbstractFacade<Carrito> {

    @PersistenceContext(unitName = "WS_TrabajoItPU")
    private EntityManager em;

    private CarritoPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idCarrito=idCarritoValue;idCuenta=idCuentaValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        model.CarritoPK key = new model.CarritoPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idCarrito = map.get("idCarrito");
        if (idCarrito != null && !idCarrito.isEmpty()) {
            key.setIdCarrito(new java.lang.Integer(idCarrito.get(0)));
        }
        java.util.List<String> idCuenta = map.get("idCuenta");
        if (idCuenta != null && !idCuenta.isEmpty()) {
            key.setIdCuenta(new java.lang.Integer(idCuenta.get(0)));
        }
        return key;
    }

    public CarritoFacadeREST() {
        super(Carrito.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Carrito entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Carrito entity) {
        super.edit(entity);
    }
    
    

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        model.CarritoPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Carrito find(@PathParam("id") PathSegment id) {
        model.CarritoPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Carrito> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Carrito> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}

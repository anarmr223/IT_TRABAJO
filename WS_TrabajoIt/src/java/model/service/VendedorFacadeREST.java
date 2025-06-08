/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.ArrayList;
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
import javax.ws.rs.core.Response;
import model.Cuenta;
import model.Vendedor;
import model.VendedorPK;

/**
 *
 * @author Asus
 */
@Stateless
@Path("model.vendedor")
public class VendedorFacadeREST extends AbstractFacade<Vendedor> {

    @PersistenceContext(unitName = "WS_TrabajoItPU")
    private EntityManager em;

    private VendedorPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;dni=dniValue;idCuenta=idCuentaValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        model.VendedorPK key = new model.VendedorPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> dni = map.get("dni");
        if (dni != null && !dni.isEmpty()) {
            key.setDni(dni.get(0));
        }
        java.util.List<String> idCuenta = map.get("idCuenta");
        if (idCuenta != null && !idCuenta.isEmpty()) {
            key.setIdCuenta(new java.lang.Integer(idCuenta.get(0)));
        }
        return key;
    }

    public VendedorFacadeREST() {
        super(Vendedor.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Vendedor entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Vendedor entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        model.VendedorPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Vendedor find(@PathParam("id") PathSegment id) {
        model.VendedorPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vendedor> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vendedor> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
    
    @GET
    @Path("findByNombreTienda/{nombreTienda}") 
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vendedor> findByNombreTienda(@PathParam("nombreTienda") String nombreTienda) {
        
        return em.createNamedQuery("Vendedor.findByNombreTienda", Vendedor.class)
                 .setParameter("nombreTienda", nombreTienda)
                 .getResultList();
    }
    
    
    @POST // Usamos POST para crear una nueva "relación" de suscripción
    @Path("{dni}/{idCuentaVendedor}/suscripciones/{idCuentaSuscripcion}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) // No consume cuerpo, pero es buena práctica
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) // Para devolver el vendedor actualizado o un mensaje
    public Response addSuscripcion(
            @PathParam("dni") String dni,
            @PathParam("idCuentaVendedor") int idCuentaVendedor,
            @PathParam("idCuentaSuscripcion") int idCuentaSuscripcion) {

        // 1. Encontrar al Vendedor
        VendedorPK vendedorPK = new VendedorPK(dni, idCuentaVendedor);
        Vendedor vendedor = em.find(Vendedor.class, vendedorPK);

        if (vendedor == null) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("Vendedor no encontrado.")
                           .build();
        }

        // 2. Encontrar la Cuenta a la que se suscribirá
        // Asume que la entidad Cuenta existe y tiene un ID simple 'idCuenta'
        Cuenta cuenta = em.find(Cuenta.class, idCuentaSuscripcion);

        if (cuenta == null) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("Cuenta de suscripción no encontrada.")
                           .build();
        }

        // 3. Verificar si la suscripción ya existe
        if (vendedor.getCuentaCollection() != null && vendedor.getCuentaCollection().contains(cuenta)) {
            return Response.status(Response.Status.CONFLICT) // 409 Conflict
                           .entity("El vendedor ya está suscrito a esta cuenta.")
                           .build();
        }

        // 4. Añadir la Cuenta a la colección del Vendedor
        // Asegúrate de que la colección no sea nula. Si no ha sido inicializada por JPA, puede serlo.
        if (vendedor.getCuentaCollection() == null) {
            vendedor.setCuentaCollection(new ArrayList<>());
        }
        vendedor.getCuentaCollection().add(cuenta);

        try {
            // 5. Actualizar el Vendedor (JPA se encargará de la tabla de unión)
            // Usamos super.edit(entity) para aprovechar el AbstractFacade
            super.edit(vendedor);
            // Si el Vendedor se ha desincronizado, podrías necesitar em.merge(vendedor);
            // em.merge(vendedor); // Si super.edit() no funciona como esperas.

            return Response.status(Response.Status.OK) // 200 OK o 201 Created si es un nuevo recurso
                           .entity("Suscripción creada exitosamente.")
                           .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error al crear la suscripción: " + e.getMessage())
                           .build();
        }
    }
    
    
    @DELETE // Usamos DELETE para eliminar una "relación" de suscripción
    @Path("{dni}/{idCuentaVendedor}/suscripciones/{idCuentaSuscripcion}")
    public Response removeSuscripcion(
            @PathParam("dni") String dni,
            @PathParam("idCuentaVendedor") int idCuentaVendedor,
            @PathParam("idCuentaSuscripcion") int idCuentaSuscripcion) {

        VendedorPK vendedorPK = new VendedorPK(dni, idCuentaVendedor);
        Vendedor vendedor = em.find(Vendedor.class, vendedorPK);

        if (vendedor == null) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("Vendedor no encontrado.")
                           .build();
        }

        Cuenta cuenta = em.find(Cuenta.class, idCuentaSuscripcion);

        if (cuenta == null) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("Cuenta de suscripción no encontrada.")
                           .build();
        }

        if (vendedor.getCuentaCollection() == null || !vendedor.getCuentaCollection().contains(cuenta)) {
            return Response.status(Response.Status.NOT_FOUND) // O 409 Conflict, dependiendo de la semántica
                           .entity("La suscripción no existe.")
                           .build();
        }

        vendedor.getCuentaCollection().remove(cuenta);

        try {
            super.edit(vendedor);
            return Response.status(Response.Status.OK) // 200 OK
                           .entity("Suscripción eliminada exitosamente.")
                           .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Error al eliminar la suscripción: " + e.getMessage())
                           .build();
        }
    }
    
    
}

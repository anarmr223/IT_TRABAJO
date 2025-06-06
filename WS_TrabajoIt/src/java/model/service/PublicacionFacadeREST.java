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
import model.Publicacion;

/**
 *
 * @author Asus
 */
@Stateless
@Path("model.publicacion")
public class PublicacionFacadeREST extends AbstractFacade<Publicacion> {

    @PersistenceContext(unitName = "WS_TrabajoItPU")
    private EntityManager em;

    public PublicacionFacadeREST() {
        super(Publicacion.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Publicacion entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Publicacion entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Publicacion find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Publicacion> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Publicacion> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    //nuestras funciones
    
    //Nuestras funciones
    @GET
    @Path("findExcludingUser/{idCuentaExcluir}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Publicacion> findExcludingUser(@PathParam("idCuentaExcluir") Long idCuentaExcluir) {
        return em.createQuery("SELECT p FROM Publicacion p WHERE p.idCuenta.idCuenta != :idCuentaExcluir", Publicacion.class)
                 .setParameter("idCuentaExcluir", idCuentaExcluir)
                 .getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}

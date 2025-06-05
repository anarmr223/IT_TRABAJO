/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.WebServiceException;
import model.Cuenta;

/**
 *
 * @author Asus
 */
@Stateless
@Path("model.cuenta")
public class CuentaFacadeREST extends AbstractFacade<Cuenta> {

    @PersistenceContext(unitName = "WS_TrabajoItPU")
    private EntityManager em;

    public CuentaFacadeREST() {
        super(Cuenta.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Cuenta entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Cuenta entity) {
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
    public Cuenta find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cuenta> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("usuario/{usuario}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Cuenta findCuentaByUsuario(@PathParam("usuario")String usuario){
        try{
            return em.createQuery("SELECT c FROM Cuenta c WHERE c.usuario = :usuario", Cuenta.class)
                 .setParameter("usuario", usuario)
                 .getSingleResult();
        } catch (NoResultException ex) {
        // If no account is found, return a 404 Not Found response
        throw new WebApplicationException("Usuario no encontrado", Response.Status.NOT_FOUND);
        } catch (Exception ex) {
        // For other internal server errors, log the exception and return a 500 Internal Server Error
        // It's crucial to log the full exception for debugging in production environments
        ex.printStackTrace(); // In a real application, use a logging framework like SLF4J/Logback
        throw new WebApplicationException("Error interno del servidor al buscar usuario", Response.Status.INTERNAL_SERVER_ERROR);
    }
        
    }
    
    @GET
    @Path("correo/{correo}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Cuenta findCuentaByCorreo(@PathParam("correo")String correo){
        try{
            return em.createQuery("SELECT c FROM cuenta c WHERE c.correo=correo", Cuenta.class)
                .setParameter("usuario", correo)
                .getSingleResult();
        }catch (Exception ex){
            throw new WebServiceException("Usuario no encontrado");
        }
        
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cuenta> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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

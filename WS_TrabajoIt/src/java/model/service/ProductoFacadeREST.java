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
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Producto;
import model.Vendedor; 
import model.VendedorPK; 

/**
 *
 * @author Asus
 */
@Stateless
@Path("model.producto")
public class ProductoFacadeREST extends AbstractFacade<Producto> {

    @PersistenceContext(unitName = "WS_TrabajoItPU")
    private EntityManager em;

    public ProductoFacadeREST() {
        super(Producto.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Producto entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Producto entity) {
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
    public Producto find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("byVendedor/{dni}/{idCuenta}") // Este es el endpoint que tu cliente ProductoWS llamará
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> findByVendedor(
            @PathParam("dni") String dni,
            @PathParam("idCuenta") int idCuenta) {

        // 1. Reconstruir la clave primaria compuesta del Vendedor
        VendedorPK vendedorPK = new VendedorPK(dni, idCuenta);

        // 2. Recuperar el objeto Vendedor de la base de datos
        // Esto es necesario para poder pasar un objeto Vendedor a la NamedQuery
        // que espera un parámetro de tipo Vendedor.
        Vendedor vendedor = em.find(Vendedor.class, vendedorPK);

        // 3. Verificar si el vendedor existe
        if (vendedor == null) {
            // Si el vendedor no se encuentra, puedes lanzar una excepción
            // o devolver una lista vacía, o un 404. Devolver una lista vacía es común
            // pero si quieres indicar que el vendedor no existe, un 404 es más RESTful.
            // Opción 1: Devolver una lista vacía (no indica si el vendedor existe o no)
            // return new ArrayList<>();

            // Opción 2: Lanzar una excepción WebApplicationException para un 404 NOT FOUND
            throw new javax.ws.rs.WebApplicationException(Response.Status.NOT_FOUND);
        }

        // 4. Ejecutar la NamedQuery
        // La NamedQuery "Producto.findByVendedor" espera un objeto Vendedor como parámetro
        return em.createNamedQuery("Producto.findByVendedor", Producto.class)
                 .setParameter("vendedor", vendedor) // Asignar el objeto Vendedor recuperado al parámetro
                 .getResultList();
    }
    
    
    @GET
    @Path("byNombre/{nombreProducto}") // Define la ruta para esta consulta
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> findByNombre(@PathParam("nombreProducto") String nombreProducto) {
        // Ejecuta la NamedQuery "Producto.findByNombre"
        // Devuelve una lista porque puede haber varios productos con el mismo nombre
        // o si usas % para búsquedas parciales (no es el caso de tu NamedQuery actual).
        return em.createNamedQuery("Producto.findByNombre", Producto.class)
                 .setParameter("nombre", nombreProducto)
                 .getResultList();
    }
    
     
    
    
}
    
    
    


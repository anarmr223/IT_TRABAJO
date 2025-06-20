/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import model.Vendedor;

/**
 * Jersey REST client generated for REST resource:we [model.vendedor]<br>
 * USAGE:
 * <pre>
 *        VendedorWS client = new VendedorWS();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Jose
 */
public class VendedorWS {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/WS_TrabajoIt/webresources/";

    public VendedorWS() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("model.vendedor");
    }

    /**
     * @param requestEntity request data@return response object (instance of responseType class)
     */
    public void create_XML(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    /**
     * @param requestEntity request data@return response object (instance of responseType class)
     */
    public void create_JSON(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    /**
     * @param responseType Class representing the response
     * @return response object (instance of responseType class)
     */
    public <T> T findAll_XML(Class<T> responseType) throws ClientErrorException {
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }
    
    
      public <T> T findAll_XML(GenericType<T> gn) throws ClientErrorException {
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(gn);
    }

    /**
     * @param responseType Class representing the response
     * @return response object (instance of responseType class)
     */
    public <T> T findAll_JSON(Class<T> responseType) throws ClientErrorException {
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    
    //Nuestras funciones
    
    public void actualizarVendedor(Vendedor v){
        Entity<Vendedor> entity= Entity.xml(v);
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(entity);
    }
    
    public List<Vendedor> findByNombreTienda(String nombreTienda) throws ClientErrorException {
        WebTarget resource = webTarget.path("findByNombreTienda").path(nombreTienda);
        // Usamos GenericType para manejar la deserialización de una lista de Vendedor
        return resource.request(MediaType.APPLICATION_XML).get(new GenericType<List<Vendedor>>() {});
       
    }
    
    
    public String addSuscripcion(String dniVendedor, int idCuentaVendedor, int idCuentaSuscripcion) throws ClientErrorException {
        WebTarget resource = webTarget.path(dniVendedor)
                                    .path(String.valueOf(idCuentaVendedor))
                                    .path("suscripciones")
                                    .path(String.valueOf(idCuentaSuscripcion));
        
        // No hay cuerpo de entidad para POST, ya que los IDs están en la URL
        return resource.request(MediaType.APPLICATION_XML) // O MediaType.APPLICATION_JSON
                       .post(null, String.class); // Enviamos null como entidad, esperamos String de vuelta
    }
    
    
    public String removeSuscripcion(String dniVendedor, int idCuentaVendedor, int idCuentaSuscripcion) throws ClientErrorException {
        WebTarget resource = webTarget.path(dniVendedor)
                                    .path(String.valueOf(idCuentaVendedor))
                                    .path("suscripciones")
                                    .path(String.valueOf(idCuentaSuscripcion));
        
        return resource.request(MediaType.APPLICATION_XML) // O MediaType.APPLICATION_JSON
                       .delete(String.class); // Esperamos String de vuelta
    }
    
    
    public void close() {
        client.close();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 * Jersey REST client generated for REST resource:we [model.producto]<br>
 * USAGE:
 * <pre>
 *        ProductoWS client = new ProductoWS();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Jose
 */
public class ProductoWS {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/WS_TrabajoIt/webresources/";

    public ProductoWS() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("model.producto");
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
    
    
    public <T> T findProductosByTienda(GenericType<T> gn, String nombreTienda){
        WebTarget resource=webTarget;
        return resource.path("producto").path(nombreTienda).request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(gn);
    }
    
    public void eliminarProductoPorId(int id){
        
       WebTarget resource= client.target(BASE_URI+"model.producto"+"/"+id);
       
       resource.request().delete();
        
        
        
    }
    
    
    public <T> T findProductosByVendedor_XML(GenericType<T> gn, String dni, int idCuenta) throws ClientErrorException {
        WebTarget resource = webTarget.path("byVendedor").path(dni).path(String.valueOf(idCuenta));
        return resource.request(MediaType.APPLICATION_XML).get(gn);
    }
    

    public void close() {
        client.close();
    }
    
}

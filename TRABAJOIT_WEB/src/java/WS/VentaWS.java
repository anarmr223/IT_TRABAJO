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

/**
 * Jersey REST client generated for REST resource:we [model.venta]<br>
 * USAGE:
 * <pre>
 *        VentaWS client = new VentaWS();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author josem
 */
public class VentaWS {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/WS_TrabajoIt/webresources/";

    public VentaWS() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("model.venta");
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

    public void close() {
        client.close();
    }
    
}

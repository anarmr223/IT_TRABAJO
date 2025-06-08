/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import model.Producto;

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
     * @param requestEntity request data@return response object (instance of
     * responseType class)
     */
    public void create_XML(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    /**
     * @param requestEntity request data@return response object (instance of
     * responseType class)
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

    public <T> T findProductosByTienda(GenericType<T> gn, String nombreTienda) {
        WebTarget resource = webTarget;
        return resource.path("producto").path(nombreTienda).request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(gn);
    }

    public void eliminarProductoPorId(int id) {

        WebTarget resource = client.target(BASE_URI + "model.producto" + "/" + id);

        resource.request().delete();

    }

    public <T> T findProductosByVendedor_XML(GenericType<T> gn, String dni, int idCuenta) throws ClientErrorException {
        WebTarget resource = webTarget.path("byVendedor").path(dni).path(String.valueOf(idCuenta));
        return resource.request(MediaType.APPLICATION_XML).get(gn);
    }

    public void edit_XML(Integer id, Producto requestEntity) throws ClientErrorException {
        // Construye la URL incluyendo el ID del producto
        WebTarget resource = webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        // Realiza la petición PUT con el objeto Producto en formato XML
        resource.request(MediaType.APPLICATION_XML)
                .put(javax.ws.rs.client.Entity.entity(requestEntity, MediaType.APPLICATION_XML));
    }

    public Producto find(Integer id) throws ClientErrorException {
        WebTarget resource = webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(MediaType.APPLICATION_XML).get(Producto.class); // O MediaType.APPLICATION_JSON si prefieres
    }
    
     public List<Producto> findByNombre(String nombreProducto) throws ClientErrorException {
        WebTarget resource = webTarget.path("byNombre").path(nombreProducto);
        // Usamos GenericType para manejar la deserialización de una lista de Producto
        return resource.request(MediaType.APPLICATION_XML).get(new GenericType<List<Producto>>() {});
        // O si esperas JSON: return resource.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Producto>>() {});
    }
    

    public void close() {
        client.close();
    }

}

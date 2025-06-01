/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Jose
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ws.service.CarritoFacadeREST.class);
        resources.add(ws.service.CuentaFacadeREST.class);
        resources.add(ws.service.LineaproductoFacadeREST.class);
        resources.add(ws.service.PagoFacadeREST.class);
        resources.add(ws.service.ProductoFacadeREST.class);
        resources.add(ws.service.PublicacionFacadeREST.class);
        resources.add(ws.service.SuscripcionFacadeREST.class);
        resources.add(ws.service.TiendaFacadeREST.class);
        resources.add(ws.service.UsuarioFacadeREST.class);
        resources.add(ws.service.VendedorFacadeREST.class);
        resources.add(ws.service.VentaFacadeREST.class);
    }
    
}

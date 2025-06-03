/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

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
        resources.add(model.service.CarritoFacadeREST.class);
        resources.add(model.service.CuentaFacadeREST.class);
        resources.add(model.service.LineaproductoFacadeREST.class);
        resources.add(model.service.PagoFacadeREST.class);
        resources.add(model.service.ProductoFacadeREST.class);
        resources.add(model.service.PublicacionFacadeREST.class);
        resources.add(model.service.SuscripcionFacadeREST.class);
        resources.add(model.service.TallaFacadeREST.class);
        resources.add(model.service.TiendaFacadeREST.class);
        resources.add(model.service.UsuarioFacadeREST.class);
        resources.add(model.service.VendedorFacadeREST.class);
        resources.add(model.service.VentaFacadeREST.class);
    }
    
}

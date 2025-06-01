/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Cuenta;
import model.DAO.CuentaDAO;

/**
 * REST Web Service
 *
 * @author Jose
 */
@Path("TRABAJOITWS")
public class TrabajoITWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TrabajoITWS
     */
    public TrabajoITWS() {
    }

    /**
     * Retrieves representation of an instance of ws.TrabajoITWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("/Usuarios/{usuario}")
    @Produces(MediaType.APPLICATION_XML)
    public Cuenta getCuentaFormUsuario(@PathParam("usuario")String usuario){
        try{
            return CuentaDAO.getCuentaFromUsuario(usuario);
        }catch(SQLException ex){
            System.out.println("Error consulta: "+ex.getMessage());
            return null;
        }
        
    }
    
    @GET
    @Path("/Usuarios")
    @Produces(MediaType.APPLICATION_XML)
    public List<Cuenta> getCuentas(){
        try {
            return CuentaDAO.getCuentas();
        } catch (SQLException ex) {
            System.out.println("Error listar: "+ex.getMessage());
            return null;
        }
    }
}

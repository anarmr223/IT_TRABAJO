/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.detalle;

import WS.CuentaWS;
import WS.VendedorWS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import controller.util.GestorContrasenias;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import model.Cuenta;
import model.Vendedor;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Usuario
 */

public class actualizarUsuarioAction extends ActionSupport implements SessionAware{
    
    private String usuario;
    private String correo;
    private String nombre;
    private String nCuenta;
    private String nombreTienda;
    private String telefono;
    private String cuentaBancaria;
    private String oldPassword;
    private String newPassword;
    private Map<String,Object> session;
    
    
    public actualizarUsuarioAction() {
    }
    
    public String execute() throws Exception {
        
        boolean actualizarVendedor=false;
        
            GestorContrasenias gc = new GestorContrasenias();
            Cuenta c = (Cuenta)session.get("usuario");
            if(!usuario.isEmpty()){
                c.setUsuario(usuario);
            }
            
            if(!correo.isEmpty()){
                c.setCorreo(correo);
            }
            
            if(!newPassword.isEmpty()&&!oldPassword.isEmpty()&&gc.verificarContrasenia(oldPassword,c.getContraseniaHash(),c.getSalt())){
                String[] newPasswordHash = gc.generarPasswordHash(newPassword);
                    
                    c.setContraseniaHash(newPasswordHash[0]);
                    c.setSalt(newPasswordHash[1]);
            }
            
            Vendedor v= c.getVendedor();
            
            if(!nombreTienda.isEmpty()){
               v.setNombreTienda(nombreTienda);
               actualizarVendedor=true;
            }
            
            if(!nombre.isEmpty()){
                v.setNombre(nombre);
                actualizarVendedor=true;
            }
            
            if(!telefono.isEmpty()){
                v.setTelefono(telefono);
                actualizarVendedor=true;
            }
            if(actualizarVendedor){
                VendedorWS vendedorWS=new VendedorWS();
                vendedorWS.actualizarVendedor(v);
                c.setVendedor(v);
            }
            CuentaWS cws = new CuentaWS();
            cws.actualizarCuenta(c);
        
        
        
        return SUCCESS;
        
        
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG(Logger LOG) {
        ActionSupport.LOG = LOG;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getnCuenta() {
        return nCuenta;
    }

    public void setnCuenta(String nCuenta) {
        this.nCuenta = nCuenta;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    

    @Override
    public void setSession(Map<String, Object> map) {
        
        this.session = map;
        
    }
    
    
    @Override
    public void validate(){
        if(!correo.isEmpty()&&!correo.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
            addFieldError("correo", "No es un correo válido");
        }
        
        if(!usuario.isEmpty()&&!usuario.matches("^[a-zA-Z0-9_-]{0,20}$")){
            addFieldError("usuario","El nombre de usuario solo puede contener: letras, numeros, -, _");
        }
        
        CuentaWS servicio= new CuentaWS();
        
        GenericType<Cuenta> genericType = new GenericType<Cuenta>() {
        };
        
        Cuenta c=null;
        
        if(!usuario.isEmpty()){
            try{
                c=servicio.findCuentaByUsuario(genericType, usuario);
            }catch(Exception ex){
                c=null;
            }
            
        }
        
        if(c!=null){
            addFieldError("usuario", "El nombre de usuario ya está registrado.");
        }
        
        if(!correo.isEmpty()){
            try{
                c=servicio.findCuentaByCorreo(genericType, usuario);
            }catch(Exception ex){
                c=null;
            }
        }
        
        if(c!=null){
            addFieldError("correo", "El correo ya está registrado");
        }
        
        c=(Cuenta) session.get("usuario");
        
        if(c.getVendedor()!=null){
            
            if(!telefono.isEmpty()&&!telefono.matches("^\\d{9}$")){
                addFieldError("telefono", "telefono introducido es incorrecto");
            }
        }
    }
    
}

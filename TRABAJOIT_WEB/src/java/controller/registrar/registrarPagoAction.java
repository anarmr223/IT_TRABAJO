/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.registrar;

import WS.PagoWS;
import WS.VentaWS;
import com.opensymphony.xwork2.ActionSupport;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import static com.stripe.net.OAuth.token;
import com.stripe.param.ChargeCreateParams;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import model.Cuenta;
import model.Pago;
import model.PagoPK;
import model.Venta;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author josem
 */
public class registrarPagoAction extends ActionSupport implements SessionAware {
    
    private double precio;
    private String token;
    private Map<String,Object> session;
    
    public registrarPagoAction() {
    }
    
    @Override
    public String execute() throws Exception{
       Stripe.apiKey = "sk_test_tuClavePrivada";

        ChargeCreateParams params = ChargeCreateParams.builder()
                .setAmount((long) precio)
                .setCurrency("eur")
                .setDescription("Pago desde Struts 2")
                .setSource(token)
                .build();

        try {
            Charge charge = Charge.create(params);
            Venta v= new Venta();
            Cuenta c= (Cuenta) session.get("usuario");
            v.setIdCarrito(c.getCarrito());
            v.setIdCuenta(c);
            VentaWS servicioVenta= new VentaWS();
            servicioVenta.create_XML(v);
            GenericType<List<Venta>> gn= new GenericType<List<Venta>>(){};
            List<Venta> lista=servicioVenta.findAll_XML(gn);
            v=lista.get(lista.size()-1);
            Pago p= new Pago(new PagoPK(charge.getId(),v.getIdVenta()));
            p.setDescripcion(charge.getDescription());
            p.setFecha(new Date());
            p.setMetodo(charge.getPaymentMethod());
            p.setTotal(charge.getAmount());
            p.setVenta(v);
            PagoWS servicioPago= new PagoWS();
            servicioPago.create_XML(p);
            return SUCCESS;
        } catch (StripeException e) {
            e.printStackTrace();
            addActionError("Error al procesar el pago: " + e.getMessage());
            return ERROR;
        }
    }

    @Override
    public void setSession(Map<String, Object> map) {
        session=map;
    }
    
}

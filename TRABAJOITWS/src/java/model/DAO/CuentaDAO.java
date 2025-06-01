/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cuenta;
import model.DAO.CONSTANTESDAO;
/**
 *
 * @author Jose
 */
public class CuentaDAO {
    static{
        try{
            Class.forName(CONSTANTESDAO.CONTROLADOR);
        }catch (ClassNotFoundException ex){
            throw new RuntimeException("Error en el controlador: "+ex.getMessage());
        }
    }
    
    private static Cuenta resultSetToUsuario(ResultSet rs) throws SQLException {
        return new Cuenta(rs.getInt("id"), rs.getNString("usuario"), rs.getNString("contraseniaHash"), rs.getNString("salt"), rs.getNString("correo"));
    }
    
    public static Cuenta getCuentaFromUsuario(String usuario) throws SQLException{
        Connection conn=DriverManager.getConnection(CONSTANTESDAO.URL, CONSTANTESDAO.USUARIO, CONSTANTESDAO.PASSWORD);
        Statement stmt= conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM cuenta WHERE usuario='test'");
        while(rs.next()){
            return resultSetToUsuario(rs);
        }
        return null;
    }
    
    public static List<Cuenta> getCuentas() throws SQLException{
        Connection conn=DriverManager.getConnection(CONSTANTESDAO.URL, CONSTANTESDAO.USUARIO, CONSTANTESDAO.PASSWORD);
        Statement stmt= conn.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM cuenta");
        List<Cuenta> cuentas=new ArrayList();
        while(rs.next()){
            cuentas.add(resultSetToUsuario(rs));
        }
        return cuentas;
    }

    
}

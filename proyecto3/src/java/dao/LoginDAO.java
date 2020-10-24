/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Usuario;
import utils.Encriptar;
import utils.VariablesGlobales;

/**
 *
 * @author cesar
 */
public class LoginDAO {
    
    public boolean autenticationUser(Usuario user) throws NoSuchAlgorithmException{
        boolean flag = false;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            //Statement statement = VariablesGlobales.conn.createStatement();
            
            String consulta = " SELECT usuario FROM proyecto3.usuarios WHERE usuario = ? AND password = ?";
            pst = VariablesGlobales.conn.prepareStatement(consulta);
            pst.setString(1, user.getUsuario().toString());
            pst.setString(2, Encriptar.sha1(user.getPassword().toString()));
            
            rs = pst.executeQuery();
            /*if(rs.absolute(1)){
                flag = true;
            }*/
            while(rs.next()){
                flag = true;
                //System.out.println(rs.getString("usuario"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            try {
                //if(VariablesGlobales.conn != null) VariablesGlobales.conn.close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
            
        }
        return flag;
    }
    
    public boolean createUser(String nombre, String apellido, String mail, String user, String pwd){
        boolean flag = false;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        
            String consulta = "INSERT INTO proyecto3.usuarios(\n" +
                                "nombre, apellido, mail, usuario, password, reg_date)\n" +
                                "VALUES (?, ?, ?, ?, ?, now());";
            pst = VariablesGlobales.conn.prepareStatement(consulta);
            pst.setString(1, nombre);
            pst.setString(2, apellido);
            pst.setString(3, mail);
            pst.setString(4, user);
            pst.setString(5, Encriptar.sha1(pwd));
            
            if(pst.executeUpdate() == 1){
                flag = true;
            }
        
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }finally{
            try {
                if(VariablesGlobales.conn != null) VariablesGlobales.conn.close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
            
        }
        return flag;
        
    }
    
    public static void main(String[] args) {
        /*LoginDAO test = new LoginDAO();
        try{
            System.out.println(test.autenticationUser(new Usuario("cmorales", "12345")));
        }catch(Exception e){
            e.printStackTrace();
        }*/
        //System.out.println(test.createUser("Cesar", "Morales", "cmorales@test.com", "cmorales", "12345"));
    }
}

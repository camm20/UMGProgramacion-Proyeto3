/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Producto;
import utils.VariablesGlobales;

/**
 *
 * @author cesar
 */
public class ProductosDAO {
    
    public List<Producto> getAllProducts(){
        List<Producto> products = new ArrayList<Producto>();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = VariablesGlobales.conn.createStatement();
            
            String consulta = "SELECT rid, nombre, precio\n" +
                                "  FROM proyecto3.productos\n" +
                                "WHERE status = 'Active';";
            rs = statement.executeQuery(consulta);
            while(rs.next()){
                products.add(new Producto(rs.getInt("rid"), rs.getString("nombre"), rs.getDouble("precio")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                //if(VariablesGlobales.conn != null) VariablesGlobales.conn.close();
                if(statement != null) statement.close();
                if(rs != null) rs.close();
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
            
        }
        return products;
    }
    
    
    public boolean addProducto(Producto prd){
        boolean flag = false;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        
            String consulta = "INSERT INTO proyecto3.productos(\n" +
                                "            nombre, precio, reg_date, status)\n" +
                                "    VALUES (?, ?, now(), 'Active');";
            pst = VariablesGlobales.conn.prepareStatement(consulta);
            pst.setString(1, (String) prd.getNombre());
            pst.setDouble(2, prd.getPrecio());
            
            
            if(pst.executeUpdate() == 1){
                flag = true;
            }
        
        }catch (Exception e) {
            System.err.println(e.getMessage());
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
    
    
    public List<Producto> getProductoById(int id){
        List<Producto> producto = new ArrayList<Producto>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            
            String consulta = "SELECT rid, nombre, precio\n" +
                                "  FROM proyecto3.productos\n" +
                                "WHERE status = 'Active' AND rid = ?;";
            
            pst = VariablesGlobales.conn.prepareStatement(consulta);
            
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            while(rs.next()){
                producto.add(new Producto(rs.getInt("rid"), rs.getString("nombre"), 
                        rs.getDouble("precio")));
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
        return producto;
    }
    
    
    public boolean editProducto(Producto prd){
        boolean flag = false;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        
            String consulta = "UPDATE proyecto3.productos\n" +
                                "   SET nombre=?, precio=? \n" +
                                " WHERE rid=?;";
            pst = VariablesGlobales.conn.prepareStatement(consulta);
            pst.setString(1, (String) prd.getNombre());
            pst.setDouble(2, prd.getPrecio());
            pst.setInt(3, prd.getId());
            
            if(pst.executeUpdate() == 1){
                flag = true;
            }
        
        }catch (Exception e) {
            System.err.println(e.getMessage());
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
    
    public boolean changeStatusProducto(int id, String status){
        boolean flag = false;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        
            String consulta = "UPDATE proyecto3.productos\n" +
                                "   SET status=? \n" +
                                " WHERE rid=?;";
            pst = VariablesGlobales.conn.prepareStatement(consulta);
            pst.setString(1, (String) status);
            pst.setInt(2, (int) id);
            
            if(pst.executeUpdate() == 1){
                flag = true;
            }
        
        }catch (Exception e) {
            System.err.println(e.getMessage());
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
    
    
    
}

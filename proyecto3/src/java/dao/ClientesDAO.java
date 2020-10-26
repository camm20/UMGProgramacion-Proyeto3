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
import model.Cliente;
import model.Empresas;
import model.Individual;
import model.Utilerias;
import utils.VariablesGlobales;

/**
 *
 * @author cesar
 */
public class ClientesDAO {
    
    
    public List<Cliente> getAllClients(){
        List<Cliente> clients = new ArrayList<Cliente>();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = VariablesGlobales.conn.createStatement();
            
            String consulta = "SELECT rid, nombres, apellidos, direccion, departamento, dpi, contacto, \n" +
                                "       descuento, tipo\n" +
                                "  FROM proyecto3.clientes\n" +
                                "WHERE status = 'Active' ORDER BY rid;";
            rs = statement.executeQuery(consulta);
            while(rs.next()){
                if("Individual".equals(rs.getString("tipo"))){
                    clients.add(new Individual(rs.getInt("rid"), rs.getString("nombres"), 
                            rs.getString("apellidos"), rs.getString("direccion"), 
                            rs.getString("departamento"), rs.getString("dpi")));
                }else if("Empresas".equals(rs.getString("tipo"))){
                    clients.add(new Empresas(rs.getInt("rid"), rs.getString("nombres"), 
                            rs.getString("apellidos"), rs.getString("direccion"), 
                            rs.getString("departamento"), rs.getString("contacto"),
                            rs.getInt("descuento")));
                }
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
        return clients;
    }
    
    public List<Individual> getClienteIndividual(){
        List<Individual> clients = new ArrayList<Individual>();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = VariablesGlobales.conn.createStatement();
            
            String consulta = "SELECT rid, nombres, apellidos, direccion, departamento, dpi, contacto, \n" +
                                "       descuento, tipo\n" +
                                "  FROM proyecto3.clientes\n" +
                                " WHERE tipo = 'Individual' AND status = 'Active' ORDER BY rid;";
            rs = statement.executeQuery(consulta);
            while(rs.next()){
                clients.add(new Individual(rs.getInt("rid"), rs.getString("nombres"), 
                        rs.getString("apellidos"), rs.getString("direccion"), 
                        rs.getString("departamento"), rs.getString("dpi")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            try {
                //if(VariablesGlobales.conn != null) VariablesGlobales.conn.close();
                if(statement != null) statement.close();
                if(rs != null) rs.close();
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
            
        }
        return clients;
    }
    
    public List<Individual> getClienteIndividualById(int id){
        List<Individual> clients = new ArrayList<Individual>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            
            
            String consulta = "SELECT rid, nombres, apellidos, direccion, departamento, dpi, contacto, \n" +
                                "       descuento, tipo\n" +
                                "  FROM proyecto3.clientes\n" +
                                " WHERE tipo = 'Individual' AND status = 'Active' AND rid = ?;";
            
            pst = VariablesGlobales.conn.prepareStatement(consulta);
            
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            while(rs.next()){
                clients.add(new Individual(rs.getInt("rid"), rs.getString("nombres"), 
                        rs.getString("apellidos"), rs.getString("direccion"), 
                        rs.getString("departamento"), rs.getString("dpi")));
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
        return clients;
    }
    
    
    public boolean addClientesIndividual(Individual cl){
        boolean flag = false;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        
            String consulta = "INSERT INTO proyecto3.clientes(\n" +
                                "            nombres, apellidos, direccion, departamento, dpi, \n" +
                                "            tipo, status, reg_date)\n" +
                                "    VALUES (?, ?, ?, ?, ?, ?, \n" +
                                "            'Active', now());";
            pst = VariablesGlobales.conn.prepareStatement(consulta);
            pst.setString(1, (String) cl.getNombres());
            pst.setString(2, (String) cl.getApellidos());
            pst.setString(3, (String) cl.getDireccion());
            pst.setString(4, (String) cl.getDepartamento());
            pst.setString(5, (String) cl.getDPI());
            pst.setString(6, (String) Utilerias.getNombreClase(cl.getClass()));
            
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
    
    public boolean editClientesIndividual(Individual cl){
        boolean flag = false;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        
            String consulta = "UPDATE proyecto3.clientes\n" +
                                "   SET nombres=?, apellidos=?, direccion=?, departamento=?, dpi=? \n" +
                                " WHERE rid=?;";
            pst = VariablesGlobales.conn.prepareStatement(consulta);
            pst.setString(1, (String) cl.getNombres());
            pst.setString(2, (String) cl.getApellidos());
            pst.setString(3, (String) cl.getDireccion());
            pst.setString(4, (String) cl.getDepartamento());
            pst.setString(5, (String) cl.getDPI());
            pst.setInt(6, cl.getId());
            
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
    
    public boolean changeStatusClientesIndividual(int id, String status){
        boolean flag = false;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        
            String consulta = "UPDATE proyecto3.clientes\n" +
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
    
    
    
    
    public boolean addClientesEmpresas(Empresas cl){
        boolean flag = false;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        
            String consulta = "INSERT INTO proyecto3.clientes(\n" +
                                "            nombres, apellidos, direccion, departamento, contacto, \n" +
                                "            descuento, tipo, status, reg_date)\n" +
                                "    VALUES (?, ?, ?, ?, ?, ?, \n" +
                                "            ?, 'Active', now());";
            pst = VariablesGlobales.conn.prepareStatement(consulta);
            pst.setString(1, (String) cl.getNombres());
            pst.setString(2, (String) cl.getApellidos());
            pst.setString(3, (String) cl.getDireccion());
            pst.setString(4, (String) cl.getDepartamento());
            pst.setString(5, (String) cl.getContacto());
            pst.setInt(6, (int) cl.getDescuento());
            pst.setString(7, (String) Utilerias.getNombreClase(cl.getClass()));
            
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
    
    
    public List<Empresas> getClienteEmpresas(){
        List<Empresas> clients = new ArrayList<Empresas>();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = VariablesGlobales.conn.createStatement();
            
            String consulta = "SELECT rid, nombres, apellidos, direccion, departamento, dpi, contacto, \n" +
                                "       descuento, tipo\n" +
                                "  FROM proyecto3.clientes\n" +
                                " WHERE tipo = 'Empresas' AND status = 'Active';";
            rs = statement.executeQuery(consulta);
            while(rs.next()){
                clients.add(new Empresas(rs.getInt("rid"), rs.getString("nombres"), 
                            rs.getString("apellidos"), rs.getString("direccion"), 
                            rs.getString("departamento"), rs.getString("contacto"),
                            rs.getInt("descuento")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            try {
                //if(VariablesGlobales.conn != null) VariablesGlobales.conn.close();
                if(statement != null) statement.close();
                if(rs != null) rs.close();
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
            
        }
        return clients;
    }
    
    public List<Empresas> getClienteEmpresasById(int id){
        List<Empresas> clients = new ArrayList<Empresas>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            
            
            String consulta = "SELECT rid, nombres, apellidos, direccion, departamento, dpi, contacto, \n" +
                                "       descuento, tipo\n" +
                                "  FROM proyecto3.clientes\n" +
                                " WHERE tipo = 'Empresas' AND status = 'Active' AND rid = ?;";
            
            pst = VariablesGlobales.conn.prepareStatement(consulta);
            
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            while(rs.next()){
                clients.add(new Empresas(rs.getInt("rid"), rs.getString("nombres"), 
                        rs.getString("apellidos"), rs.getString("direccion"), 
                        rs.getString("departamento"), rs.getString("contacto"), rs.getInt("descuento")));
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
        return clients;
    }
    
    
    public boolean editClientesEmpresas(Empresas cl){
        boolean flag = false;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        
            String consulta = "UPDATE proyecto3.clientes\n" +
                                "   SET nombres=?, apellidos=?, direccion=?, departamento=?, contacto=?, descuento=?\n" +
                                " WHERE rid=?;";
            pst = VariablesGlobales.conn.prepareStatement(consulta);
            pst.setString(1, (String) cl.getNombres());
            pst.setString(2, (String) cl.getApellidos());
            pst.setString(3, (String) cl.getDireccion());
            pst.setString(4, (String) cl.getDepartamento());
            pst.setString(5, (String) cl.getContacto());
            pst.setInt(6, (int) cl.getDescuento());
            pst.setInt(7, cl.getId());
            
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
    
    public boolean changeStatusClientesEmpresas(int id, String status){
        boolean flag = false;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        
            String consulta = "UPDATE proyecto3.clientes\n" +
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
    
    
    
    
    public static void main(String[] args) {
        /*ClientesDAO cli = new ClientesDAO();
        
        List<Individual> clientes = cli.getClienteIndividual();
        //int i=0;
        clientes.forEach(cliente -> {
            System.out.println(cliente.toString());
        });*/
        /*ClientesDAO cli = new ClientesDAO();
        
        System.out.print(cli.editClientesIndividual(new Individual(2,"Mario","Ruiz","Zona 13","Guatemala","123555899")));*/
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Empresas;
import model.Individual;
import model.ItemOrden;
import model.Orden;
import model.Producto;
import utils.VariablesGlobales;

/**
 *
 * @author cesar
 */
public class OrdenesdeCompraDAO {
    
    public boolean checkClientById(int id){
        boolean flag = false;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        
            String consulta = "SELECT rid, nombres, apellidos, direccion, departamento, dpi, contacto, \n" +
                                "       descuento, tipo\n" +
                                "  FROM proyecto3.clientes\n" +
                                " WHERE status = 'Active' AND rid = ?;";
            
            pst = VariablesGlobales.conn.prepareStatement(consulta);
            
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            while(rs.next()){
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
    
    public int getCorrelat(){
        int correlat = 0;
        
        Statement st = null;
        ResultSet rs = null;
        try{
            st = VariablesGlobales.conn.createStatement();
            String consulta = "SELECT secuence \n" +
                                "  FROM proyecto3.correlat\n" +
                                " WHERE tabla = 'orden_compra';";
            
            
            
            rs = st.executeQuery(consulta);
            
            while(rs.next()){
                correlat = rs.getInt("secuence");
            }
        
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }finally{
            try {
                //if(VariablesGlobales.conn != null) VariablesGlobales.conn.close();
                if(st != null) st.close();
                if(rs != null) rs.close();
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
            
        } 
        return correlat;
    }
    
    public void updateCorrelat(int secuence){
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        
            String consulta = "UPDATE proyecto3.correlat \n" +
                                "   SET secuence = ? \n" +
                                " WHERE tabla='orden_compra';";
            pst = VariablesGlobales.conn.prepareStatement(consulta);
            pst.setInt(1, secuence);
            pst.executeUpdate();
            
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
    }
    
    public Cliente getCliente(int id){
        Cliente cli = null;
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        
            String consulta = "SELECT rid, nombres, apellidos, direccion, departamento, dpi, contacto, \n" +
                                "       descuento, tipo\n" +
                                "  FROM proyecto3.clientes\n" +
                                " WHERE status = 'Active' AND rid = ?;";
            
            pst = VariablesGlobales.conn.prepareStatement(consulta);
            
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            while(rs.next()){
                if("Individual".equals(rs.getString("tipo"))){
                    cli = (new Individual(rs.getInt("rid"), rs.getString("nombres"), 
                            rs.getString("apellidos"), rs.getString("direccion"), 
                            rs.getString("departamento"), rs.getString("dpi")));
                }else if("Empresas".equals(rs.getString("tipo"))){
                    cli = (new Empresas(rs.getInt("rid"), rs.getString("nombres"), 
                            rs.getString("apellidos"), rs.getString("direccion"), 
                            rs.getString("departamento"), rs.getString("contacto"),
                            rs.getInt("descuento")));
                }
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
        return cli;
    }
    
    public void altaOrdendeCompra(int ocId, int idClient){
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        
            String consulta = "INSERT INTO proyecto3.orden_compra(\n" +
                                "            numero_oc, id_cliente, \"fechaOrden\", \"precioEnvio\", \"tipoEnvio\", \n" +
                                "            estado)\n" +
                                "    VALUES (?, ?, now(), 0, 'Ninguno','Generada');";
            pst = VariablesGlobales.conn.prepareStatement(consulta);
            pst.setInt(1, ocId);
            pst.setInt(2, idClient);
            
            
            pst.executeUpdate();
            
        
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
    }
    
    public boolean checkProductByCod(int idProducto){
        boolean flag = false;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        
            String consulta = "SELECT nombre, precio\n" +
                                "  FROM proyecto3.productos\n" +
                                "  WHERE rid = ? AND status = 'Active';";
            
            pst = VariablesGlobales.conn.prepareStatement(consulta);
            
            pst.setInt(1, idProducto);
            rs = pst.executeQuery();
            
            while(rs.next()){
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
    
    public Producto getProductoByCod(int idProducto){
        Producto producto = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        
            String consulta = "SELECT nombre, precio\n" +
                                "  FROM proyecto3.productos\n" +
                                "  WHERE rid = ? AND status = 'Active';";
            
            pst = VariablesGlobales.conn.prepareStatement(consulta);
            
            pst.setInt(1, idProducto);
            rs = pst.executeQuery();
            
            while(rs.next()){
                producto = new Producto(idProducto, rs.getString("nombre"), rs.getDouble("precio"));
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
        
        return producto;
    }
    
    public void addItemOC(int ocId, ItemOrden item){

        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        
            String consulta = "INSERT INTO proyecto3.\"itemOrden\"(\n" +
                                "            numero_oc, linea, cantidad, cod_producto)\n" +
                                "    VALUES (?, ?, ?, ?);";
            pst = VariablesGlobales.conn.prepareStatement(consulta);
            pst.setInt(1, ocId);
            pst.setInt(2, item.getNoLinea());
            pst.setInt(3, item.getCantidad());
            pst.setInt(4, item.getProducto().getId());
            
            
            pst.executeUpdate();
            
        
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
        
    }
    
    public boolean searchOC(int idOC){
        boolean flag = false;
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        
            String consulta = "SELECT rid, numero_oc, id_cliente, \"fechaOrden\", \"precioEnvio\", \"tipoEnvio\", \n" +
                                "       estado\n" +
                                "  FROM proyecto3.orden_compra\n" +
                                "  WHERE rid = ? AND estado != 'Baja';";
            
            pst = VariablesGlobales.conn.prepareStatement(consulta);
            
            pst.setInt(1, idOC);
            rs = pst.executeQuery();
            
            while(rs.next()){
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
    
    public Orden getHeadOC(int idOC){
        Orden orden = null;
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        
            String consulta = "SELECT rid, numero_oc, id_cliente, \"fechaOrden\", \"precioEnvio\", \"tipoEnvio\", \"diasEnvio\", \n" +
                                "       estado\n" +
                                "  FROM proyecto3.orden_compra\n" +
                                "  WHERE rid = ?;";
            
            pst = VariablesGlobales.conn.prepareStatement(consulta);
            
            pst.setInt(1, idOC);
            rs = pst.executeQuery();
            
            while(rs.next()){
                orden = new Orden(rs.getInt("numero_oc"), rs.getDate("fechaOrden"), rs.getString("estado"), rs.getString("tipoEnvio"), rs.getDouble("precioEnvio"), rs.getInt("diasEnvio"));
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
        
        return orden;
    }
    
    public int getClienteCodOC(int idOC){
        int cli = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        
            String consulta = "SELECT id_cliente \n" +
                                "  FROM proyecto3.orden_compra\n" +
                                "  WHERE rid = ?;";
            
            pst = VariablesGlobales.conn.prepareStatement(consulta);
            
            pst.setInt(1, idOC);
            rs = pst.executeQuery();
            
            while(rs.next()){
                cli = rs.getInt("id_cliente");
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
        
        return cli;
    }
    
    
    public List<ItemOrden> getItemsOC(int idOC){
        List<ItemOrden> items = new ArrayList<ItemOrden>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        
            String consulta = "SELECT rid, numero_oc, linea, cantidad, cod_producto\n" +
                                "  FROM proyecto3.\"itemOrden\"" +
                                "  WHERE numero_oc = ? ORDER BY linea";
            
            pst = VariablesGlobales.conn.prepareStatement(consulta);
            
            pst.setInt(1, idOC);
            rs = pst.executeQuery();
            
            while(rs.next()){
                items.add(new ItemOrden(rs.getInt("linea"), rs.getInt("cantidad"), this.getProductoByCod(rs.getInt("cod_producto"))));
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
        
        return items;
    }
    
    public boolean baja0C(int idOC){
        boolean flag = false;
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
        
            String consulta = "UPDATE proyecto3.orden_compra\n" +
                                "   SET estado='Baja'\n" +
                                " WHERE numero_oc=?;";
            pst = VariablesGlobales.conn.prepareStatement(consulta);
            pst.setInt(1, idOC);
            
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

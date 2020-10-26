/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductosDAO;
import java.util.List;
import model.Producto;

/**
 *
 * @author cesar
 */
public class ControladorProductos {
    
    public boolean addProducto(Producto prd){
        boolean valid = false;
        try {
            ProductosDAO prdDao = new ProductosDAO();
            valid = prdDao.addProducto(prd);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return valid;
    }
    
    
    public String getProductos(){
        String html_resp = "";
        ProductosDAO prdDao = new ProductosDAO();
        List<Producto> productos = prdDao.getAllProducts();
        int line =0;
        
        for( Producto producto : productos){
            line++;
            html_resp += "<tr>\n" +
"                            <th scope=\"row\" style=\"vertical-align: middle;\">"+  String.valueOf(line) +"</th>\n" +
"                            <td style=\"vertical-align: middle;\">"+ producto.getId() +"</td>\n" +
"                            <td style=\"vertical-align: middle;\">"+ producto.getNombre() +"</td>\n" +
"                            <td style=\"vertical-align: middle;\">"+ producto.getPrecio() +"</td>\n" +
"                            <td style=\"vertical-align: middle;\">\n" +
"                                <button type=\"button\" class=\"btn btn-warning\" onclick=\"edit_producto("+ producto.getId() +")\">Editar</button>\n" +
"                                <button type=\"button\" class=\"btn btn-danger\" onclick=\"inactive_producto("+ producto.getId() +")\">Baja</button>\n" +
"                            </td>\n" +
"                          </tr>";
            
        }
        return html_resp;
    }
    
    public String getReportProductos(){
        String html_resp = "";
        ProductosDAO prdDao = new ProductosDAO();
        List<Producto> productos = prdDao.getAllProducts();
        int line =0;
        
        for( Producto producto : productos){
            line++;
            html_resp += "<tr>\n" +
"                            <th scope=\"row\" style=\"vertical-align: middle;\">"+  String.valueOf(line) +"</th>\n" +
"                            <td style=\"vertical-align: middle;\">"+ producto.getId() +"</td>\n" +
"                            <td style=\"vertical-align: middle;\">"+ producto.getNombre() +"</td>\n" +
"                            <td style=\"vertical-align: middle;\">"+ producto.getPrecio() +"</td>\n" +
"                          </tr>";
            
        }
        return html_resp;
    }
    
    
    public String editProductoById(int id){
        String html_resp = "";
        ProductosDAO cliDao = new ProductosDAO();
        List <Producto> producto = cliDao.getProductoById(id);
        
        if(producto.size() == 1){
            html_resp += "<div class=\"header-login-container\">\n" +
"                            <label>EDITAR</label>\n" +
"                            <p id=\"btn-close-alert\" class=\"btn-close-alertclass\" onclick=\"close_windalert()\">X</p>\n" +
"                        </div>\n" +
"                        <div class=\"content-msg-container\">\n" +
"         \n" +
"                            <div class=\"row\">\n" +
"                                <div class=\"col-md-12\">\n" +
"                                    <label>Nombre:</label>\n" +
"                                    <input type=\"text\" class=\"edit_producto\" id=\"nombre\" validate=\"1\" value=\""+ producto.get(0).getNombre() +"\"/>\n" +
"                                </div>\n" +
"                                <div class=\"col-md-12\">\n" +
"                                    <label>Precio:</label>\n" +
"                                    <input type=\"text\" class=\"edit_producto\" id=\"precio\" validate=\"1\" value=\""+ producto.get(0).getPrecio() +"\"/>\n" +
"                                </div>\n" +
"                                <div class=\"col-md-12\" style=\"text-align: center;\">\n" +
"                                    <button type=\"button\" class=\"btn btn-primary\" style=\"margin-top: 30px; margin-bottom: 15px;\" onclick=\"save_edit_producto("+ producto.get(0).getId() +")\">Guardar</button>\n" +
"                                    <button type=\"button\" class=\"btn btn-danger\" style=\"margin-top: 30px; margin-bottom: 15px;\" onclick=\"close_windalert()\">Cancelar</button>\n" +
"                                </div>\n" +
"                            </div>\n" +
"                        </div>";          
            
        }else{
            html_resp += "<div class=\"header-login-container\">\n" +
"                            <label>EDITAR</label>\n" +
"                            <p id=\"btn-close-alert\" class=\"btn-close-alertclass\" onclick=\"close_windalert()\">X</p>\n" +
"                        </div>\n" +
"                        <div class=\"content-msg-container\">\n" +
"                                <p>No se han encontrado datos.</p>\n" +
"                                <div class=\"col-md-12\" style=\"text-align: center;\">\n" +
"                                    <button type=\"button\" class=\"btn btn-danger\" style=\"margin-top: 30px; margin-bottom: 15px;\" onclick=\"close_windalert()\">Cancelar</button>\n" +
"                                </div>\n" +
"                            </div>\n" +
"                        </div>";  
        }
        
        return html_resp;
    }
    
    
    public String saveEditProductoById(Producto prd){
        String html_resp = "";
        ProductosDAO prdDao = new ProductosDAO();
        if(prdDao.editProducto(prd)){
            html_resp += this.getProductos();
        }else{
            html_resp += "Error";
        }
        
        return html_resp;
    }
    
    public String changeStatusProductoById(int id, String status){
        String html_resp = "";
        ProductosDAO prdDao = new ProductosDAO();
        if(prdDao.changeStatusProducto(id, status)){
            html_resp += this.getProductos();
        }else{
            html_resp += "Error";
        }
        
        return html_resp;
    }
    
}

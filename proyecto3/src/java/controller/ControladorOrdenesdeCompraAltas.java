/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OrdenesdeCompraDAO;
import model.Cliente;
import model.DataSistema;
import model.ItemOrden;
import model.Orden;

/**
 *
 * @author cesar
 */
public class ControladorOrdenesdeCompraAltas {
    
    public String altaOrdenCompra(int idClient){
        String html_resp = "";
        OrdenesdeCompraDAO ocDAO = new OrdenesdeCompraDAO();
        if(ocDAO.checkClientById(idClient)){
            
            
            int ocId = ocDAO.getCorrelat();
            ocDAO.updateCorrelat(ocId+1);
            ocDAO.altaOrdendeCompra(ocId,idClient);
            
            Cliente cli = ocDAO.getCliente(idClient);
            
            DataSistema.orden = new Orden(ocId,cli);
            
            html_resp += "<div class=\"row\">\n" +
"                \n" +
"                <div class=\"col-md-12\">\n" +
"                    <table class=\"table table-sm table-hover\" id=\"tbl_productos\">\n" +
"                        <thead>\n" +
"                          <tr>\n" +
"                            <th scope=\"col\">Orden</th>\n" +
"                            <th scope=\"col\">Nombre</th>\n" +
"                            <th scope=\"col\">Apellido</th>\n" +
"                            <th scope=\"col\">Direccion</th>\n" +
"                            <th scope=\"col\">Departamento</th>\n" +
"                          </tr>\n" +
"                        </thead>\n" +
"                        <tbody>\n" +
"                            <tr>\n" +
"                                <td style=\"vertical-align: middle;\">"+ DataSistema.orden.getId() +"</td>\n" +
"                                <td style=\"vertical-align: middle;\">"+ DataSistema.orden.getCliente().getNombres() +"</td>\n" +
"                                <td style=\"vertical-align: middle;\">"+ DataSistema.orden.getCliente().getApellidos() +"</td>\n" +
"                                <td style=\"vertical-align: middle;\">"+ DataSistema.orden.getCliente().getDireccion() +"</td>\n" +
"                                <td style=\"vertical-align: middle;\">"+ DataSistema.orden.getCliente().getDepartamento() +"</td>\n" +
"                            </tr>\n" +
"                        </tbody>\n" +
"                    </table>\n" +
"                </div>\n" +
"                \n" +
"                \n" +
"            </div>\n" +
"            <div class=\"row\">\n" +
"                <div class=\"col-md-2\">\n" +
"                    <label>Codigo Producto:</label>\n" +
"                    <input type=\"text\" class=\"oc_add_item\" id=\"oc_codigo_producto\" validate=\"1\"/>\n" +
"                </div>\n" +
"                <div class=\"col-md-2\">\n" +
"                    <label>Cantidad:</label>\n" +
"                    <input type=\"text\" class=\"oc_add_item\" id=\"oc_cantidad\" validate=\"1\"/>\n" +
"                </div>\n" +
"                <div class=\"col-md-2\">\n" +
"                    <button type=\"button\" class=\"btn btn-primary\" style=\"margin-bottom: 15px;margin-top: 30px;\" onclick=\"oc_add_item()\">Agregar</button>\n" +
"                </div>\n" +
"                \n" +
"            </div>\n" +
"            <div class=\"row\">\n" +
"                <div class=\"col-md-12\">\n" +
"                    <table class=\"table table-sm\" id=\"tbl_oc_items\">\n" +
"                        <thead>\n" +
"                          <tr>\n" +
"                            <th scope=\"col\">Linea</th>\n" +
"                            <th scope=\"col\">Cod Producto</th>\n" +
"                            <th scope=\"col\">Producto</th>\n" +
"                            <th scope=\"col\">Cantidad</th>\n" +
"                            <th scope=\"col\">Precio</th>\n" +
"                            <th scope=\"col\">Total</th>\n" +
"                          </tr>\n" +
"                        </thead>\n" +
"                        <tbody>\n" +
"                            <tr>\n" +
"                                <td style=\"vertical-align: middle;\"></td>\n" +
"                                <td style=\"vertical-align: middle;\"></td>\n" +
"                                <td style=\"vertical-align: middle;\"></td>\n" +
"                                <td style=\"vertical-align: middle;\"></td>\n" +
"                            </tr>\n" +
"                        </tbody>\n" +
"                    </table>\n" +
"                </div>\n" +
"            </div>";
            
            
        }else{
            html_resp += "Error";
        }
        
        
        return html_resp;
    }
    
    public String addItemOC(int idProducto, int cantidad){
        String html_resp = "";
        OrdenesdeCompraDAO ocDAO = new OrdenesdeCompraDAO();
        
        if(ocDAO.checkProductByCod(idProducto)){
            DataSistema.orden.addItems(cantidad, ocDAO.getProductoByCod(idProducto));
            ocDAO.addItemOC(DataSistema.orden.getId(), DataSistema.orden.getItems().get(DataSistema.orden.getItems().size()-1));
            for( ItemOrden item : DataSistema.orden.getItems()){
                html_resp += "<tr>\n" +
    "                            <th scope=\"row\" style=\"vertical-align: middle;\">"+  item.getNoLinea() +"</th>\n" +
    "                            <td style=\"vertical-align: middle;\">"+ item.getProducto().getId() +"</td>\n" +
    "                            <td style=\"vertical-align: middle;\">"+ item.getProducto().getNombre() +"</td>\n" +
    "                            <td style=\"vertical-align: middle;\">"+ item.getCantidad() +"</td>\n" +
    "                            <td style=\"vertical-align: middle;\">"+ item.getProducto().getPrecio() +"</td>\n" +
    "                            <td style=\"vertical-align: middle;\">"+ item.getTotalItem() +"</td>\n" +
    "                          </tr>";

            }
        }else{
            html_resp += "No Product";
        }
       
        return html_resp;
    }
    
}

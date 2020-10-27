/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OrdenesdeCompraDAO;
import java.util.ArrayList;
import java.util.List;
import model.DataSistema;
import model.ItemOrden;

/**
 *
 * @author cesar
 */
public class ControladorOrdenesdeCompraModificar {
    
    public String getOrdenCompra(int codOC){
        String html_resp = "";
        try{
            OrdenesdeCompraDAO ocDAO = new OrdenesdeCompraDAO();
            if(ocDAO.searchOC(codOC)){

                DataSistema.orden = ocDAO.getHeadOC(codOC);
                DataSistema.orden.setCliente(ocDAO.getCliente(ocDAO.getClienteCodOC(codOC)));

                ocDAO.getItemsOC(codOC).forEach(item -> {
                    DataSistema.orden.addItems(item.getCantidad(), item.getProducto());
                });

                html_resp += "<div class=\"row\">\n" +
    "                \n" +
    "                <div class=\"col-md-12\">\n" +
    "                    <table class=\"table table-sm table-hover\" id=\"tbl_productos\">\n" +
    "                        <thead>\n" +
    "                          <tr>\n" +
    "                            <th scope=\"col\">Nombre</th>\n" +
    "                            <th scope=\"col\">Apellido</th>\n" +
    "                            <th scope=\"col\">Direccion</th>\n" +
    "                            <th scope=\"col\">Departamento</th>\n" +
    "                          </tr>\n" +
    "                        </thead>\n" +
    "                        <tbody>\n" +
    "                            <tr>\n" +
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
    "               <div class=\"col-md-2\">\n" +
    "                <label>Tipo Envio</label>\n" +
    "                <input class=\"oc_envio\" id=\"tipo_envio\" value=\""+ DataSistema.orden.getTipoEnvio() +"\" validate=\"1\" disabled>\n" +
    "            </div>\n" +
    "            <div class=\"col-md-1\">\n" +
    "                <label>Dias</label>\n" +
    "                <input type=\"number\" class=\"oc_envio\" id=\"dias_envio\" value=\""+ DataSistema.orden.getDiasEnvio() +"\" validate=\"1\" disabled />\n" +
    "            </div>\n" +
    "            <div class=\"col-md-1\">\n" +
    "                <label>Costo</label>\n" +
    "                <input type=\"number\" class=\"oc_envio\" id=\"costo_envio\" value=\""+ DataSistema.orden.getPrecioEnvio() +"\" validate=\"1\" disabled />\n" +
    "            </div>\n" +
    "            <div class=\"col-md-2\">\n" +
    "            </div>" +
    "                <div class=\"col-md-2\">\n" +
    "                    <label>Codigo Producto:</label>\n" +
    "                    <input type=\"text\" class=\"oc_add_item\" id=\"oc_codigo_producto\" validate=\"1\"/>\n" +
    "                </div>\n" +
    "                <div class=\"col-md-2\">\n" +
    "                    <label>Cantidad:</label>\n" +
    "                    <input type=\"text\" class=\"oc_add_item\" id=\"oc_cantidad\" validate=\"1\"/>\n" +
    "                </div>\n" +
    "                <div class=\"col-md-2\">\n" +
    "                    <button type=\"button\" class=\"btn btn-primary\" style=\"margin-bottom: 15px;margin-top: 30px;\" onclick=\"edit_oc_add_item()\">Agregar</button>\n" +
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
    "                            <th scope=\"col\">Accion</th>\n" +
    "                          </tr>\n" +
    "                        </thead>\n" +
    "                        <tbody>\n";
                html_resp = DataSistema.orden.getItems().stream().map(item -> "                <tr>\n" +
                        "                                <td style=\"vertical-align: middle;\">"+item.getNoLinea()+"</td>\n" +
                                "                                <td style=\"vertical-align: middle;\">"+item.getProducto().getId()+"</td>\n" +
                                        "                                <td style=\"vertical-align: middle;\">"+item.getProducto().getNombre()+"</td>\n" +
                                                "                                <td style=\"vertical-align: middle;\">"+item.getCantidad()+"</td>\n" +
                                                        "                                <td style=\"vertical-align: middle;\">"+item.getProducto().getPrecio()+"</td>\n" +
                                                                "                                <td style=\"vertical-align: middle;\">"+item.getTotalItem()+"</td>\n" +
"                            <td style=\"vertical-align: middle;\">\n" +
"                                <button type=\"button\" class=\"btn btn-warning\" onclick=\"edit_oc_item("+ item.getNoLinea() +")\">Editar</button>\n" +
"                                <button type=\"button\" class=\"btn btn-danger\" onclick=\"edit_oc_remove_item("+ item.getNoLinea() +")\">Eliminar</button></td>\n" +
                                                                        "                            </tr>\n").reduce(html_resp, String::concat);

                html_resp += "</tbody>\n" +
    "                    </table>\n" +
    "                </div>\n" +
    "            </div>";


            }else{
                html_resp += "No OC";
            }
        }catch(Exception e){
            e.printStackTrace();
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
            //AQUI VA LA FUNCION DE ITEMS
            html_resp += this.renderItemOrden();
        }else{
            html_resp += "No Product";
        }
       
        return html_resp;
    }
    
    public String renderItemOrden(){
        String html_resp = "";
        for( ItemOrden item : DataSistema.orden.getItems()){
            html_resp += "<tr>\n" +
"                            <th scope=\"row\" style=\"vertical-align: middle;\">"+  item.getNoLinea() +"</th>\n" +
"                            <td style=\"vertical-align: middle;\">"+ item.getProducto().getId() +"</td>\n" +
"                            <td style=\"vertical-align: middle;\">"+ item.getProducto().getNombre() +"</td>\n" +
"                            <td style=\"vertical-align: middle;\">"+ item.getCantidad() +"</td>\n" +
"                            <td style=\"vertical-align: middle;\">"+ item.getProducto().getPrecio() +"</td>\n" +
"                            <td style=\"vertical-align: middle;\">"+ item.getTotalItem() +"</td>\n" +
"                            <td style=\"vertical-align: middle;\">\n" +
"                                <button type=\"button\" class=\"btn btn-warning\" onclick=\"edit_oc_item("+ item.getNoLinea() +")\">Editar</button>\n" +
"                                <button type=\"button\" class=\"btn btn-danger\" onclick=\"edit_oc_remove_item("+ item.getNoLinea() +")\">Eliminar</button></td>\n" +
"                          </tr>";

        }
        return html_resp;
    }
    
    public String editItemOrdenOCByLine(int id){
        String html_resp = "";
        
        ItemOrden item = DataSistema.orden.getItems().get(id-1);
        
        html_resp += "<div class=\"header-login-container\">\n" +
"                            <label>EDITAR</label>\n" +
"                            <p id=\"btn-close-alert\" class=\"btn-close-alertclass\" onclick=\"close_windalert()\">X</p>\n" +
"                        </div>\n" +
"                        <div class=\"content-msg-container\">\n" +
"         \n" +
"                            <div class=\"row\">\n" +
"                                <div class=\"col-md-12\">\n" +
"                                    <label>Cod Producto:</label>\n" +
"                                    <input type=\"text\" id=\"nombres\" value=\""+ item.getProducto().getId() +"\" disabled/>\n" +
"                                </div>\n" +
"                                <div class=\"col-md-12\">\n" +
"                                    <label>Producto:</label>\n" +
"                                    <input type=\"text\" id=\"apellidos\" value=\""+ item.getProducto().getNombre() +"\" disabled/>\n" +
"                                </div>\n" +
"                                <div class=\"col-md-12\">\n" +
"                                    <label>Cantidad:</label>\n" +
"                                    <input type=\"number\" class=\"edit_itemorden_oc\" id=\"cantidad\" validate=\"1\" value=\""+ item.getCantidad() +"\"/>\n" +
"                                </div>\n" +
"                                <div class=\"col-md-12\" style=\"text-align: center;\">\n" +
"                                    <button type=\"button\" class=\"btn btn-primary\" style=\"margin-top: 30px; margin-bottom: 15px;\" onclick=\"save_edit_itemorden_oc("+ item.getNoLinea() +")\">Guardar</button>\n" +
"                                    <button type=\"button\" class=\"btn btn-danger\" style=\"margin-top: 30px; margin-bottom: 15px;\" onclick=\"close_windalert()\">Cancelar</button>\n" +
"                                </div>\n" +
"                            </div>\n" +
"                        </div>";        
        return html_resp;
    }
    
    public String saveEditItemOrdenOC(int itemLine, int cantidad){
        String html_resp = "";
        OrdenesdeCompraDAO ocDAO = new OrdenesdeCompraDAO();
        List <ItemOrden> itemsBK = new ArrayList<ItemOrden>();
        int line = 0;
        for( ItemOrden item : DataSistema.orden.getItems()){
            line++;
            if(itemLine == line){
                ocDAO.updateItemOrden(DataSistema.orden.getId(), itemLine, cantidad);
                item.setCantidad(cantidad);
            }
            itemsBK.add(item);
        }
        DataSistema.orden.setTotal(0);
        DataSistema.orden.setItemLine(0);
        DataSistema.orden.setItems(new ArrayList<ItemOrden>());
        itemsBK.forEach(regitem -> {
            DataSistema.orden.addItems(regitem.getCantidad(), regitem.getProducto());
        });
        
        html_resp += this.renderItemOrden();        
        return html_resp;
    }
    
    public String deleteItemOrdenOC(int itemLine){
        String html_resp = "";
        OrdenesdeCompraDAO ocDAO = new OrdenesdeCompraDAO();
        List <ItemOrden> itemsBK = new ArrayList<ItemOrden>();
        int line = 0;
        for( ItemOrden item : DataSistema.orden.getItems()){
            line++;
            if(itemLine == line){
                ocDAO.deleteItemOrden(DataSistema.orden.getId());
            }else{
                itemsBK.add(item);
            }
        }        
        DataSistema.orden.setTotal(0);
        DataSistema.orden.setItemLine(0);
        DataSistema.orden.setItems(new ArrayList<ItemOrden>());
        itemsBK.forEach(regitem -> {
            DataSistema.orden.addItems(regitem.getCantidad(), regitem.getProducto());
        });
        
        DataSistema.orden.getItems().forEach(itemsave -> {
            ocDAO.addItemOC(DataSistema.orden.getId(), itemsave);
        });
        
        html_resp += this.renderItemOrden();
        return html_resp;
    }
    
    public String addEnvioOC(String tipo_envio, int dias_envio, double costo_envio){
        String html_resp = "";
        
        DataSistema.orden.setTipoEnvio(tipo_envio);
        DataSistema.orden.setDiasEnvio(dias_envio);
        DataSistema.orden.setPrecioEnvio(costo_envio);
        OrdenesdeCompraDAO ocDAO = new OrdenesdeCompraDAO();
        if(ocDAO.setEnvio(DataSistema.orden)){
            html_resp += "Success";
        }else{
            html_resp += "Error";
        }
        
        return html_resp;
    }
    
}

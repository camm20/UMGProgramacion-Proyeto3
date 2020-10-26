/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OrdenesdeCompraDAO;
import model.DataSistema;
import model.ItemOrden;

/**
 *
 * @author cesar
 */
public class ControladorOrdenesdeCompraBajas {
    
    public String searchOC(int idOC){
        String html_resp = "";
        try{
            OrdenesdeCompraDAO ocDAO = new OrdenesdeCompraDAO();

            if(ocDAO.searchOC(idOC)){
                DataSistema.orden = ocDAO.getHeadOC(idOC);
                DataSistema.orden.setCliente(ocDAO.getCliente(ocDAO.getClienteCodOC(idOC)));
                
                ocDAO.getItemsOC(idOC).forEach(item -> {
                    DataSistema.orden.addItems(item.getCantidad(), item.getProducto());
                });
                
                
                html_resp += "<div class=\"row\">\n" +
                "                <div class=\"col-md-12\">\n" +
                "                    <table class=\"table table-sm table-hover\" id=\"tbl_productos\">\n" +
                "                        <thead>\n" +
                "                            <tr>\n" +
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
                "                        <tbody>\n";
                
                for(ItemOrden item : DataSistema.orden.getItems()){
                    html_resp += "                <tr>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+item.getNoLinea()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+item.getProducto().getId()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+item.getProducto().getNombre()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+item.getCantidad()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+item.getProducto().getPrecio()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+item.getTotalItem()+"</td>\n" +
                    "                            </tr>\n";
                }
                html_resp += "               <tr style=\"background-color: #e4e4e4;\">\n" +
                "                                <td style=\"vertical-align: middle;\"></td>\n" +
                "                                <td style=\"vertical-align: middle;\"></td>\n" +
                "                                <td style=\"vertical-align: middle;\"><strong>SUBTOTAL</strong></td>\n" +
                "                                <td style=\"vertical-align: middle;\"></td>\n" +
                "                                <td style=\"vertical-align: middle;\"></td>\n" +
                "                                <td style=\"vertical-align: middle;\">"+DataSistema.orden.getTotal()+"</td>\n" +
                "                            </tr>\n" +
                "                            <tr style=\"background-color: #b3b4bd;\">\n" +
                "                                <td style=\"vertical-align: middle;\"></td>\n" +
                "                                <td style=\"vertical-align: middle;\"></td>\n" +
                "                                <td style=\"vertical-align: middle;\"><strong>TOTAL</strong></td>\n" +
                "                                <td style=\"vertical-align: middle;\"></td>\n" +
                "                                <td style=\"vertical-align: middle;\"></td>\n" +
                "                                <td style=\"vertical-align: middle;\"><strong>"+DataSistema.orden.getTotalOrden()+"</strong></td>\n" +
                "                            </tr>\n" +
                "                       </tbody>\n" +        
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
    
    public String bajaOC(int idOC){
        String html_resp = "";
        
        OrdenesdeCompraDAO ocDAO = new OrdenesdeCompraDAO();
        
        if(ocDAO.baja0C(idOC)){
            html_resp += "Success";
        }else{
            html_resp += "Error";
        }
        
        return html_resp;
    }
    
}

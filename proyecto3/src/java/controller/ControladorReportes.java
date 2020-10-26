/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClientesDAO;
import dao.OrdenesdeCompraDAO;
import model.Cliente;
import model.DataSistema;
import model.Empresas;
import model.Individual;
import model.ItemOrden;
import model.Utilerias;

/**
 *
 * @author cesar
 */
public class ControladorReportes {
    
    public String getAllClients(){        
        String html_resp = "<thead>\n" +
"                          <tr>\n" +
"                            <th scope=\"col\">#</th>\n" +
"                            <th scope=\"col\">Tipo</th>\n" +
"                            <th scope=\"col\">Codigo</th>\n" +
"                            <th scope=\"col\">Nombres</th>\n" +
"                            <th scope=\"col\">Apellidos</th>\n" +
"                            <th scope=\"col\">Direccion</th>\n" +
"                            <th scope=\"col\">Departamento</th>\n" +
"                            <th scope=\"col\">DPI</th>\n" +
"                            <th scope=\"col\">Contacto</th>\n" +
"                            <th scope=\"col\">Descuento</th>\n" +
"                          </tr>\n" +
"                        </thead>\n" +
"                        <tbody>\n";

        ClientesDAO cliDAO = new ClientesDAO();
        Empresas cliEmp = null;
        Individual cliInd = null;
        int line = 0;
        for(Cliente cli : cliDAO.getAllClients()){
            line++;
            if("Individual".equals(Utilerias.getNombreClase(cli.getClass()))){
                cliInd = (Individual) cli;
                html_resp += "                <tr>\n" +
                    "                                <th scope=\"row\" style=\"vertical-align: middle;\">"+line+"</td>\n" +
                    "                                <th style=\"vertical-align: middle;\">"+(String) Utilerias.getNombreClase(cliInd.getClass())+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliInd.getId()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliInd.getNombres()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliInd.getApellidos()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliInd.getDireccion()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliInd.getDepartamento()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliInd.getDPI()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\"></td>\n" +
                    "                                <td style=\"vertical-align: middle;\"></td>\n" +
                    "                            </tr>\n";
            }else if("Empresas".equals(Utilerias.getNombreClase(cli.getClass()))){
                cliEmp = (Empresas) cli;
                html_resp += "                <tr>\n" +
                    "                                <th scope=\"row\" style=\"vertical-align: middle;\">"+line+"</td>\n" +
                    "                                <th style=\"vertical-align: middle;\">"+(String) Utilerias.getNombreClase(cliEmp.getClass())+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliEmp.getId()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliEmp.getNombres()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliEmp.getApellidos()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliEmp.getDireccion()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliEmp.getDepartamento()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\"></td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliEmp.getContacto()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliEmp.getDescuento()+"</td>\n" +
                    "                            </tr>\n";
            }
            
        }
        
        html_resp += "                        </tbody>";
        
        return html_resp;
    }
    
    public String getIndividualClients(){        
        String html_resp = "<thead>\n" +
"                          <tr>\n" +
"                            <th scope=\"col\">#</th>\n" +
"                            <th scope=\"col\">Tipo</th>\n" +
"                            <th scope=\"col\">Codigo</th>\n" +
"                            <th scope=\"col\">Nombres</th>\n" +
"                            <th scope=\"col\">Apellidos</th>\n" +
"                            <th scope=\"col\">Direccion</th>\n" +
"                            <th scope=\"col\">Departamento</th>\n" +
"                            <th scope=\"col\">DPI</th>\n" +
"                          </tr>\n" +
"                        </thead>\n" +
"                        <tbody>\n";

        ClientesDAO cliDAO = new ClientesDAO();
        Individual cliInd = null;
        int line = 0;
        for(Cliente cli : cliDAO.getAllClients()){
            line++;
            if("Individual".equals(Utilerias.getNombreClase(cli.getClass()))){
                cliInd = (Individual) cli;
                html_resp += "                <tr>\n" +
                    "                                <th scope=\"row\" style=\"vertical-align: middle;\">"+line+"</td>\n" +
                    "                                <th style=\"vertical-align: middle;\">"+(String) Utilerias.getNombreClase(cliInd.getClass())+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliInd.getId()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliInd.getNombres()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliInd.getApellidos()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliInd.getDireccion()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliInd.getDepartamento()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliInd.getDPI()+"</td>\n" +
                    "                            </tr>\n";
            }
            
        }
        
        html_resp += "                        </tbody>";
        
        return html_resp;
    }
    
    public String getEmpresasClients(){        
        String html_resp = "<thead>\n" +
"                          <tr>\n" +
"                            <th scope=\"col\">#</th>\n" +
"                            <th scope=\"col\">Tipo</th>\n" +
"                            <th scope=\"col\">Codigo</th>\n" +
"                            <th scope=\"col\">Nombres</th>\n" +
"                            <th scope=\"col\">Apellidos</th>\n" +
"                            <th scope=\"col\">Direccion</th>\n" +
"                            <th scope=\"col\">Departamento</th>\n" +
"                            <th scope=\"col\">Contacto</th>\n" +
"                            <th scope=\"col\">Descuento</th>\n" +
"                          </tr>\n" +
"                        </thead>\n" +
"                        <tbody>\n";

        ClientesDAO cliDAO = new ClientesDAO();
        Empresas cliEmp = null;
        int line = 0;
        for(Cliente cli : cliDAO.getAllClients()){
            line++;
            if("Empresas".equals(Utilerias.getNombreClase(cli.getClass()))){
                cliEmp = (Empresas) cli;
                html_resp += "                <tr>\n" +
                    "                                <th scope=\"row\" style=\"vertical-align: middle;\">"+line+"</td>\n" +
                    "                                <th style=\"vertical-align: middle;\">"+(String) Utilerias.getNombreClase(cliEmp.getClass())+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliEmp.getId()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliEmp.getNombres()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliEmp.getApellidos()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliEmp.getDireccion()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliEmp.getDepartamento()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\"></td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliEmp.getContacto()+"</td>\n" +
                    "                                <td style=\"vertical-align: middle;\">"+cliEmp.getDescuento()+"</td>\n" +
                    "                            </tr>\n";
            }
            
        }
        
        html_resp += "                        </tbody>";
        
        return html_resp;
    }
    
    public String getReportOC(int idOC){
        String html_resp = "";
        try{
            OrdenesdeCompraDAO ocDAO = new OrdenesdeCompraDAO();

            if(ocDAO.searchOCAllStatus(idOC)){
                DataSistema.orden = ocDAO.getHeadOC(idOC);
                DataSistema.orden.setCliente(ocDAO.getCliente(ocDAO.getClienteCodOC(idOC)));
                
                ocDAO.getItemsOC(idOC).forEach(item -> {
                    DataSistema.orden.addItems(item.getCantidad(), item.getProducto());
                });
                
                
                html_resp += "<div class=\"row\">\n" +
                "                <div class=\"col-md-12\">\n" +
                "                    <h4>OC Cliente:</h4>\n" +
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
                "            </div>\n" +
                "            <div class=\"row\">\n" +
                "                <div class=\"col-md-12\">\n" +
                "                    <h4>OC Head:</h4>\n" +        
                "                    <table class=\"table table-sm table-hover\" id=\"tbl_productos\">\n" +
                "                        <thead>\n" +
                "                            <tr>\n" +
                "                            <th scope=\"col\">Creacion</th>\n" +
                "                            <th scope=\"col\">Envio</th>\n" +
                "                            <th scope=\"col\">Costo Envio</th>\n" +
                "                            <th scope=\"col\">Dias Envio</th>\n" +
                "                            <th scope=\"col\">Estado</th>\n" +
                "                          </tr>\n" +
                "                        </thead>\n" +
                "                        <tbody>\n" +
                "                            <tr>\n" +
                "                                <td style=\"vertical-align: middle;\">"+ DataSistema.orden.getFechaOrden() +"</td>\n" +
                "                                <td style=\"vertical-align: middle;\">"+ DataSistema.orden.getTipoEnvio() +"</td>\n" +
                "                                <td style=\"vertical-align: middle;\">"+ DataSistema.orden.getPrecioEnvio() +"</td>\n" +
                "                                <td style=\"vertical-align: middle;\">"+ DataSistema.orden.getDiasEnvio() +"</td>\n" +
                "                                <td style=\"vertical-align: middle;\">"+ DataSistema.orden.getEstado() +"</td>\n" +
                "                            </tr>\n" +
                "                        </tbody>\n" +
                "                    </table>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"row\">\n" +
                "                <div class=\"col-md-12\">\n" +
                "                    <h4>OC Detail:</h4>\n" +
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
    
}

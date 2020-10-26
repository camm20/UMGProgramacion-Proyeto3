/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClientesDAO;
import java.util.List;
import model.Empresas;
import model.Individual;

/**
 *
 * @author cesar
 */
public class ControladorClientes {
    
    public boolean addClienteIndividual(Individual cl){
        boolean valid = false;
        try {
            ClientesDAO cliDao = new ClientesDAO();
            valid = cliDao.addClientesIndividual(cl);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return valid;
    }
    
    public String getClienteIndividual(){
        String html_resp = "";
        ClientesDAO cliDao = new ClientesDAO();
        List<Individual> clientes = cliDao.getClienteIndividual();
        int line =0;
        
        for( Individual cliente : clientes){
            line++;
            html_resp += "<tr>\n" +
"                            <th scope=\"row\" style=\"vertical-align: middle;\">"+  String.valueOf(line) +"</th>\n" +
"                            <td style=\"vertical-align: middle;\">"+ cliente.getId() +"</td>\n" +
"                            <td style=\"vertical-align: middle;\">"+ cliente.getNombres() +"</td>\n" +
"                            <td style=\"vertical-align: middle;\">"+ cliente.getApellidos() +"</td>\n" +
"                            <td style=\"vertical-align: middle;\">"+ cliente.getDireccion() +"</td>\n" +
"                            <td style=\"vertical-align: middle;\">"+ cliente.getDepartamento() +"</td>\n" +
"                            <td style=\"vertical-align: middle;\">"+ cliente.getDPI() +"</td>\n" +
"                            <td style=\"vertical-align: middle;\">\n" +
"                                <button type=\"button\" class=\"btn btn-warning\" onclick=\"edit_cliente_individual("+ cliente.getId() +")\">Editar</button>\n" +
"                                <button type=\"button\" class=\"btn btn-danger\" onclick=\"inactive_cliente_individual("+ cliente.getId() +")\">Baja</button>\n" +
"                            </td>\n" +
"                          </tr>";
            
        }
        return html_resp;
    }
    
    public String editClienteIndividualById(int id){
        String html_resp = "";
        ClientesDAO cliDao = new ClientesDAO();
        List <Individual> cliente = cliDao.getClienteIndividualById(id);
        
        if(cliente.size() == 1){
            html_resp += "<div class=\"header-login-container\">\n" +
"                            <label>EDITAR</label>\n" +
"                            <p id=\"btn-close-alert\" class=\"btn-close-alertclass\" onclick=\"close_windalert()\">X</p>\n" +
"                        </div>\n" +
"                        <div class=\"content-msg-container\">\n" +
"         \n" +
"                            <div class=\"row\">\n" +
"                                <div class=\"col-md-12\">\n" +
"                                    <label>Nombres:</label>\n" +
"                                    <input type=\"text\" class=\"edit_individual_clients\" id=\"nombres\" validate=\"1\" value=\""+ cliente.get(0).getNombres() +"\"/>\n" +
"                                </div>\n" +
"                                <div class=\"col-md-12\">\n" +
"                                    <label>Apellidos:</label>\n" +
"                                    <input type=\"text\" class=\"edit_individual_clients\" id=\"apellidos\" validate=\"1\" value=\""+ cliente.get(0).getApellidos() +"\"/>\n" +
"                                </div>\n" +
"                                <div class=\"col-md-12\">\n" +
"                                    <label>Direccion:</label>\n" +
"                                    <input type=\"text\" class=\"edit_individual_clients\" id=\"direccion\" validate=\"1\" value=\""+ cliente.get(0).getDireccion() +"\"/>\n" +
"                                </div>\n" +
"                                <div class=\"col-md-12\">\n" +
"                                    <label>Departamento:</label>\n" +
"                                    <input type=\"text\" class=\"edit_individual_clients\" id=\"departamento\" validate=\"1\" value=\""+ cliente.get(0).getDepartamento() +"\"/>\n" +
"                                </div>\n" +
"                                <div class=\"col-md-12\">\n" +
"                                    <label>DPI:</label>\n" +
"                                    <input type=\"text\" class=\"edit_individual_clients\" id=\"dpi\" validate=\"1\" value=\""+ cliente.get(0).getDPI() +"\"/>\n" +
"                                </div>\n" +
"                                <div class=\"col-md-12\" style=\"text-align: center;\">\n" +
"                                    <button type=\"button\" class=\"btn btn-primary\" style=\"margin-top: 30px; margin-bottom: 15px;\" onclick=\"save_edit_cliente_individual("+ cliente.get(0).getId() +")\">Guardar</button>\n" +
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
    
    
    public String saveEditClienteIndividualById(Individual ci){
        String html_resp = "";
        ClientesDAO cliDao = new ClientesDAO();
        if(cliDao.editClientesIndividual(ci)){
            html_resp += this.getClienteIndividual();
        }else{
            html_resp += "Error";
        }
        
        return html_resp;
    }
    
    public String changeStatusClienteIndividualById(int id, String status){
        String html_resp = "";
        ClientesDAO cliDao = new ClientesDAO();
        if(cliDao.changeStatusClientesIndividual(id, status)){
            html_resp += this.getClienteIndividual();
        }else{
            html_resp += "Error";
        }
        
        return html_resp;
    }
    
    
    
    public boolean addClienteEmpresas(Empresas cl){
        boolean valid = false;
        try {
            ClientesDAO cliDao = new ClientesDAO();
            valid = cliDao.addClientesEmpresas(cl);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return valid;
    }
    
    
    public String getClienteEmpresas(){
        String html_resp = "";
        ClientesDAO cliDao = new ClientesDAO();
        List<Empresas> clientes = cliDao.getClienteEmpresas();
        int line =0;
        
        for( Empresas cliente : clientes){
            line++;
            html_resp += "<tr>\n" +
"                            <th scope=\"row\" style=\"vertical-align: middle;\">"+  String.valueOf(line) +"</th>\n" +
"                            <td style=\"vertical-align: middle;\">"+ cliente.getId() +"</td>\n" +
"                            <td style=\"vertical-align: middle;\">"+ cliente.getNombres() +"</td>\n" +
"                            <td style=\"vertical-align: middle;\">"+ cliente.getApellidos() +"</td>\n" +
"                            <td style=\"vertical-align: middle;\">"+ cliente.getDireccion() +"</td>\n" +
"                            <td style=\"vertical-align: middle;\">"+ cliente.getDepartamento() +"</td>\n" +
"                            <td style=\"vertical-align: middle;\">"+ cliente.getContacto() +"</td>\n" +
"                            <td style=\"vertical-align: middle;\">"+ cliente.getDescuento() +"</td>\n" +
"                            <td style=\"vertical-align: middle;\">\n" +
"                                <button type=\"button\" class=\"btn btn-warning\" onclick=\"edit_cliente_empresas("+ cliente.getId() +")\">Editar</button>\n" +
"                                <button type=\"button\" class=\"btn btn-danger\" onclick=\"inactive_cliente_empresas("+ cliente.getId() +")\">Baja</button>\n" +
"                            </td>\n" +
"                          </tr>";
            
        }
        return html_resp;
    }
    
    
    public String editClienteEmpresasById(int id){
        String html_resp = "";
        ClientesDAO cliDao = new ClientesDAO();
        List <Empresas> cliente = cliDao.getClienteEmpresasById(id);
        
        if(cliente.size() == 1){
            html_resp += "<div class=\"header-login-container\">\n" +
"                            <label>EDITAR</label>\n" +
"                            <p id=\"btn-close-alert\" class=\"btn-close-alertclass\" onclick=\"close_windalert()\">X</p>\n" +
"                        </div>\n" +
"                        <div class=\"content-msg-container\">\n" +
"         \n" +
"                            <div class=\"row\">\n" +
"                                <div class=\"col-md-12\">\n" +
"                                    <label>Nombres:</label>\n" +
"                                    <input type=\"text\" class=\"edit_empresas_clients\" id=\"nombres\" validate=\"1\" value=\""+ cliente.get(0).getNombres() +"\"/>\n" +
"                                </div>\n" +
"                                <div class=\"col-md-12\">\n" +
"                                    <label>Apellidos:</label>\n" +
"                                    <input type=\"text\" class=\"edit_empresas_clients\" id=\"apellidos\" validate=\"1\" value=\""+ cliente.get(0).getApellidos() +"\"/>\n" +
"                                </div>\n" +
"                                <div class=\"col-md-12\">\n" +
"                                    <label>Direccion:</label>\n" +
"                                    <input type=\"text\" class=\"edit_empresas_clients\" id=\"direccion\" validate=\"1\" value=\""+ cliente.get(0).getDireccion() +"\"/>\n" +
"                                </div>\n" +
"                                <div class=\"col-md-12\">\n" +
"                                    <label>Departamento:</label>\n" +
"                                    <input type=\"text\" class=\"edit_empresas_clients\" id=\"departamento\" validate=\"1\" value=\""+ cliente.get(0).getDepartamento() +"\"/>\n" +
"                                </div>\n" +
"                                <div class=\"col-md-12\">\n" +
"                                    <label>Contacto:</label>\n" +
"                                    <input type=\"text\" class=\"edit_empresas_clients\" id=\"contacto\" validate=\"1\" value=\""+ cliente.get(0).getContacto() +"\"/>\n" +
"                                </div>\n" +
"                                <div class=\"col-md-12\">\n" +
"                                    <label>Descuento:</label>\n" +
"                                    <input type=\"numeric\" class=\"edit_empresas_clients\" id=\"descuento\" validate=\"1\" value=\""+ cliente.get(0).getDescuento() +"\"/>\n" +
"                                </div>\n" +
"                                <div class=\"col-md-12\" style=\"text-align: center;\">\n" +
"                                    <button type=\"button\" class=\"btn btn-primary\" style=\"margin-top: 30px; margin-bottom: 15px;\" onclick=\"save_edit_cliente_empresas("+ cliente.get(0).getId() +")\">Guardar</button>\n" +
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
    
    
    public String saveEditClienteEmpresasById(Empresas ci){
        String html_resp = "";
        ClientesDAO cliDao = new ClientesDAO();
        if(cliDao.editClientesEmpresas(ci)){
            html_resp += this.getClienteEmpresas();
        }else{
            html_resp += "Error";
        }
        
        return html_resp;
    }
    
    public String changeStatusClienteEmpresasById(int id, String status){
        String html_resp = "";
        ClientesDAO cliDao = new ClientesDAO();
        if(cliDao.changeStatusClientesEmpresas(id, status)){
            html_resp += this.getClienteEmpresas();
        }else{
            html_resp += "Error";
        }
        
        return html_resp;
    }
    
    
    
}



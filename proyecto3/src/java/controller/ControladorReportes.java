/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClientesDAO;
import model.Cliente;
import model.Empresas;
import model.Individual;
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
    
}

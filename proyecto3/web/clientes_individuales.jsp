<%-- 
    Document   : clientes_individuales
    Created on : 23/10/2020, 08:38:44 PM
    Author     : cesar
--%>

<%@page import="controller.ControladorClientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    HttpSession sesion = request.getSession(false);
    Object usuario = sesion.getAttribute("usuario") == null ? null : sesion.getAttribute("usuario");

    if(usuario != null){
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proyecto 3 | Clientes Individuales</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>


        <%@ include file="header.jsp" %>
        <div class="container-fluid" style="padding-top:15px;">
            
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item">Clientes</li>
                  <li class="breadcrumb-item active" aria-current="page">Individuales</li>
                </ol>
            </nav>
            <div class="row">
                <div class="col-md-2">
                    <label>Nombres:</label>
                    <input type="text" class="individual_clients" id="nombres" validate="1"/>
                </div>
                <div class="col-md-2">
                    <label>Apellidos:</label>
                    <input type="text" class="individual_clients" id="apellidos" validate="1"/>
                </div>
                <div class="col-md-2">
                    <label>Direccion:</label>
                    <input type="text" class="individual_clients" id="direccion" validate="1"/>
                </div>
                <div class="col-md-2">
                    <label>Departamento:</label>
                    <input type="text" class="individual_clients" id="departamento" validate="1"/>
                </div>
                <div class="col-md-2">
                    <label>DPI:</label>
                    <input type="text" class="individual_clients" id="dpi" validate="1"/>
                </div>
                <div class="col-md-2" style="text-align: center;">
                    <button type="button" class="btn btn-primary" style="margin-top: 30px; margin-bottom: 15px;" onclick="cliente_individual_save()">Guardar</button>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-sm table-hover" id="tbl_clientes_individuales">
                        <thead>
                          <tr>
                            <th scope="col">#</th>
                            <th scope="col">codigo</th>
                            <th scope="col">Nombres</th>
                            <th scope="col">Apellidos</th>
                            <th scope="col">Direccion</th>
                            <th scope="col">Departamento</th>
                            <th scope="col">DPI</th>
                            <th scope="col">Actions</th>
                          </tr>
                        </thead>
                        <tbody>
                            
                            
                        <%
                        ControladorClientes cliController = new ControladorClientes();
                        %>
                        <%= cliController.getClienteIndividual() %>
                        
                                                  
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
                        
                        
                        
        <div class="window-msg-general">
            <div class="window-box-question" id="msg-content">
                
            </div>
        </div>
        
        <div class="window-workfunction-general">
            <div class="window-box-workform" id="workform-content">
                
                
            </div>
        </div>
        
        <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
        <script type="text/javascript" src="js/ajax_function_json.js"></script>
        <script type="text/javascript" src="js/functions.js"></script>
    </body>
</html>
<%}else{%>
<% response.sendRedirect("/proyecto3"); %>
<%}%>
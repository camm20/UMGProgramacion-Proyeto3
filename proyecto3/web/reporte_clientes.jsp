<%-- 
    Document   : reporte_clientes
    Created on : 26/10/2020, 01:26:25 AM
    Author     : cesar
--%>

<%@page import="controller.ControladorReportes"%>
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
        <title>Proyecto 3 | Reporte Clientes</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>


        <%@ include file="header.jsp" %>
        <div class="container-fluid" style="padding-top:15px;">
            
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item">Reporte</li>
                  <li class="breadcrumb-item active" aria-current="page">Clientes</li>
                </ol>
            </nav>
            <div class="row">
                <div class="col-md-2">
                    <label>Tipo Cliente:</label>
                    <select class="form-control select_report_clients" id="tipo_cliente" onchange="report_client_select()" validate="1">
                        <option value="Individual">Individual</option>
                        <option value="Empresas">Empresas</option>
                        <option value="Todos" selected>Todos</option>
                    </select>
                </div>
                <div class="col-md-10"></div>
            </div>
            <div class="row" style="padding-top: 20px;">
                
                <div class="col-md-12">
                    
                    <table class="table table-sm table-hover" id="report_clients">
                        
                        <% ControladorReportes repController = new ControladorReportes();
                        %>
                        <%= repController.getAllClients() %>
                        
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

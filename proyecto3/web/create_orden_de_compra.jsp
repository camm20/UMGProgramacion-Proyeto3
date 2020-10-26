<%-- 
    Document   : create_orden_de_compra.jsp
    Created on : 24/10/2020, 09:17:12 PM
    Author     : cesar
--%>

<%@page import="controller.ControladorProductos"%>
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
        <title>Proyecto 3 | Orden de Compra Altas</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>


        <%@ include file="header.jsp" %>
        <div class="container-fluid" style="padding-top:15px;">
            
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                  <li class="breadcrumb-item">Ordenes de Compra</li>
                  <li class="breadcrumb-item active" aria-current="page">Alta</li>
                </ol>
            </nav>
            <div class="row">
                <div class="col-md-2">
                    <label>Cod. Cliente:</label>
                    <input type="number" class="alta_oc_search_client" id="cod_client" validate="1"/>
                </div>
                <div class="col-md-2" style="text-align: center;">
                    <button type="button" class="btn btn-primary" id="btn_buscar_cliente_oc" style="margin-bottom: 15px;margin-top: 30px;" onclick="alta_oc_search_client()">Buscar</button>
                    <button type="button" class="btn btn-primary" id="btn_end_alta_oc" style="margin-bottom: 15px;margin-top: 30px;" onclick="alta_oc_end_process()" disabled>Finalizar</button>
                </div>
                <div class="col-md-8"></div>
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
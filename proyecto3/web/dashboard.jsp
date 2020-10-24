<%-- 
    Document   : dashboard
    Created on : 21/10/2020, 09:59:02 PM
    Author     : cesar
--%>

    <%@page import="model.Usuario"%>
<%@page import="controller.ControladorUsuario"%>
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
            <title>Proyecto 3 | Login</title>
            <!-- Bootstrap CSS -->
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
            <link rel="stylesheet" type="text/css" href="css/style.css">
        </head>
        <body>
                         

            <%@ include file="header.jsp" %>

            <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
            <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
        </body>
    </html>
    <%}else{%>
    <% response.sendRedirect("/proyecto3"); %>
    <%}%>
<%-- 
    Document   : index
    Created on : 21/10/2020, 07:49:52 PM
    Author     : cesar
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <% 
        HttpSession sesion = request.getSession(false);
        Object usuario = sesion.getAttribute("usuario") == null ? null : sesion.getAttribute("usuario");
        
        if(usuario != null){
            response.sendRedirect("/proyecto3/dashboard.jsp");
        }
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
        
        <div class="divlogcontainer">
		<div class="containerloginform">
			<div class="headerloginform">LOGIN</div>
			<div class="content_inpunts_loginform">
				<label for="login_user">USERNAME:</label>
				<input type="text" class="login_form" validate="1" onkeypress="login_key(event);" id="login_user" placeholder="John Wick" />
				<label for="login_password">PASSWORD:</label>
				<input type="password" class="login_form" validate="1" onkeypress="login_key(event);" id="login_password" placeholder="****" />
				
                                <span id="login_error_msg" style="color:red;"></span>
                                
                                <div style="text-align: right;">
					<button id="login_button" onclick="login()">Aceptar</button>
				</div>
			</div>
		</div>
         
	</div>
        
        
        <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
        <script type="text/javascript" src="js/ajax_function_json.js"></script>
        <script type="text/javascript" src="js/functions.js"></script>
    </body>
</html>

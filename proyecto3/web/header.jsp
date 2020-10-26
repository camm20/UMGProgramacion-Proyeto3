<%-- 
    Document   : header
    Created on : 21/10/2020, 09:50:27 PM
    Author     : cesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header class="navbar navbar-expand navbar-dark flex-column flex-md-row bd-navbar local-navbar">
    <a class="navbar-brand mr-0 mr-md-2" href="/proyecto3" aria-label="Oreja"><svg xmlns="http://www.w3.org/2000/svg" width="36" height="36" class="d-block" viewBox="0 0 612 612" role="img" focusable="false"><title>Bootstrap</title><path fill="currentColor" d="M510 8a94.3 94.3 0 0 1 94 94v408a94.3 94.3 0 0 1-94 94H102a94.3 94.3 0 0 1-94-94V102a94.3 94.3 0 0 1 94-94h408m0-8H102C45.9 0 0 45.9 0 102v408c0 56.1 45.9 102 102 102h408c56.1 0 102-45.9 102-102V102C612 45.9 566.1 0 510 0z"></path><path fill="currentColor" d="M196.77 471.5V154.43h124.15c54.27 0 91 31.64 91 79.1 0 33-24.17 63.72-54.71 69.21v1.76c43.07 5.49 70.75 35.82 70.75 78 0 55.81-40 89-107.45 89zm39.55-180.4h63.28c46.8 0 72.29-18.68 72.29-53 0-31.42-21.53-48.78-60-48.78h-75.57zm78.22 145.46c47.68 0 72.73-19.34 72.73-56s-25.93-55.37-76.46-55.37h-74.49v111.4z"></path></svg></a>

    <div class="navbar-nav-scroll">
      <ul class="navbar-nav bd-navbar-nav flex-row">
        <li class="nav-item dropdown">
            <a class="nav-item nav-link dropdown-toggle mr-md-2" href="#" id="bd-versions" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
              Clientes
            </font></font></a>
            <div class="dropdown-menu dropdown-menu-md-left" aria-labelledby="bd-versions">
                <a class="dropdown-item" href="/proyecto3/clientes_individuales.jsp"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Individuales</font></font></a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="/proyecto3/clientes_empresas.jsp"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Empresas</font></font></a>
            </div>
        </li>


        <li class="nav-item">
          <a class="nav-link " href="/proyecto3/productos.jsp"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Productos</font></font></a>
        </li>
          
        <li class="nav-item dropdown">
            <a class="nav-item nav-link dropdown-toggle mr-md-2" href="#" id="bd-versions" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
              Ordenes de Compra
            </font></font></a>
            <div class="dropdown-menu dropdown-menu-md-left" aria-labelledby="bd-versions">
                <a class="dropdown-item" href="/proyecto3/create_orden_de_compra.jsp"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Alta</font></font></a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="/proyecto3/edit_orden_de_compra.jsp"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Modificar</font></font></a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="/proyecto3/delete_orden_de_compra.jsp"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Baja</font></font></a>
            </div>
        </li>

        <li class="nav-item dropdown">
            <a class="nav-item nav-link dropdown-toggle mr-md-2" href="#" id="bd-versions" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
              Reportes
            </font></font></a>
            <div class="dropdown-menu dropdown-menu-md-right" aria-labelledby="bd-versions">
                <a class="dropdown-item" href="/proyecto3/reporte_clientes.jsp"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Clientes</font></font></a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="/proyecto3/reporte_productos.jsp"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Productos</font></font></a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="/proyecto3/clientes_empresas.jsp"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Orden de Compra</font></font></a>
            </div>
        </li>
      </ul>
    </div>

    <ul class="navbar-nav ml-md-auto">
      <li class="nav-item dropdown">
        <a class="nav-item nav-link dropdown-toggle mr-md-2" href="#" id="bd-versions" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
          Usuario
        </font></font></a>
        <div class="dropdown-menu dropdown-menu-md-right" aria-labelledby="bd-versions">
          <a class="dropdown-item active" href="/proyecto3/logout"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Logout</font></font></a>
        </div>
      </li>
    </ul>
</header>
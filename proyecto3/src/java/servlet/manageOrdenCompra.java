/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.ControladorOrdenesdeCompraAltas;
import controller.ControladorOrdenesdeCompraBajas;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cesar
 */
@WebServlet(name = "manageOrdenCompra", urlPatterns = {"/managoc"})
public class manageOrdenCompra extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String _action = request.getParameter("action");
        
        ControladorOrdenesdeCompraAltas altasOCController = new ControladorOrdenesdeCompraAltas();
        switch (_action) {
            case "altaOC":{
                    int _idCli = Integer.parseInt(request.getParameter("idCliente"));    
                    response.getWriter().print(altasOCController.altaOrdenCompra(_idCli));
                    break;
            }case "addItemOC":{
                int _idProducto = Integer.parseInt(request.getParameter("oc_codigo_producto"));
                int _cantidad = Integer.parseInt(request.getParameter("oc_cantidad"));
                
                response.getWriter().print(altasOCController.addItemOC(_idProducto, _cantidad));
                break;
            }case "bajaSearchOC":{
                int _idOC = Integer.parseInt(request.getParameter("cod_oc"));
                ControladorOrdenesdeCompraBajas bajasOCController = new ControladorOrdenesdeCompraBajas();
                
                response.getWriter().print(bajasOCController.searchOC(_idOC));
                
                break;
            }case "bajaAceptOC":{
                int _idOC = Integer.parseInt(request.getParameter("cod_oc"));
                ControladorOrdenesdeCompraBajas bajasOCController = new ControladorOrdenesdeCompraBajas();
                
                response.getWriter().print(bajasOCController.bajaOC(_idOC));
                break;
            }
            default:
                break;
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

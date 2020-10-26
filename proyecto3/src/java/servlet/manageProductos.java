package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controller.ControladorProductos;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Producto;

/**
 *
 * @author cesar
 */
@WebServlet(urlPatterns = {"/manageproducts"})
public class manageProductos extends HttpServlet {

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
        
        ControladorProductos prdController = new ControladorProductos();
        switch (_action) {
            case "getDataProduct":{
                    //ControladorClientes cliController = new ControladorClientes();
                    int _id = Integer.parseInt(request.getParameter("id"));    
                    response.getWriter().print(prdController.editProductoById(_id));
                    break;
            }
            case "addNewDataProduct":{
                    String _nombre = request.getParameter("nombre");
                    String _precio = request.getParameter("precio");
                    Producto producto = new Producto(_nombre, Double.parseDouble(_precio));
                    //ControladorProductos prdController = new ControladorProductos();
                    if(prdController.addProducto(producto)){
                        response.getWriter().print(prdController.getProductos());
                    }else{
                        response.getWriter().print("Error");
                    }
                    
                    break;
            }
            case "saveDataProduct":{
                    int _id = Integer.parseInt(request.getParameter("id"));
                    String _nombre = request.getParameter("nombre");
                    String _precio = request.getParameter("precio");
                    Producto product = new Producto(_id,_nombre,Double.parseDouble(_precio));
                    //ControladorClientes cliController = new ControladorClientes();
                    response.getWriter().print(prdController.saveEditProductoById(product));
                    break;
            }
            case "inactiveDataProduct":{
                    int _id = Integer.parseInt(request.getParameter("id"));
                    response.getWriter().print(prdController.changeStatusProductoById(_id, "Inactive"));
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

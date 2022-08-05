/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import PaqueteJava.ClienteModell;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Chacón Berreondo
 */
@WebServlet(urlPatterns = {"/ClienteController"})
public class ClienteController extends HttpServlet {

    ClienteModell cliente;

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
        try ( PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct\" crossorigin=\"anonymous\"></script>"
                    + "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\" integrity=\"sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N\" crossorigin=\"anonymous\">\n");
            out.println("</head>");
            out.println("<body>");
            out.println("<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n"
                    + "            <a class=\"navbar-brand\" href=\"#\">UMG</a>\n"
                    + "            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarTogglerDemo02\" aria-controls=\"navbarTogglerDemo02\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
                    + "              <span class=\"navbar-toggler-icon\"></span>\n"
                    + "            </button>\n"
                    + "\n"
                    + "            <div class=\"collapse navbar-collapse\" id=\"navbarTogglerDemo02\">\n"
                    + "              <ul class=\"navbar-nav mr-auto mt-2 mt-lg-0\">\n"
                    + "                <li class=\"nav-item active\">\n"
                    + "                  <a class=\"nav-link\" href=\"#\">Registrarse <span class=\"sr-only\">(current)</span></a>\n"
                    + "                </li>\n"
                    + "                <li class=\"nav-item\">\n"
                    + "                  <a class=\"nav-link\" href=\"#\">Tienda</a>\n"
                    + "                </li>\n"
                    + "                <li class=\"nav-item\">\n"
                    + "                  <a class=\"nav-link disabled\">Acerca de nosotros</a>\n"
                    + "                </li>\n"
                    + "              </ul>\n"
                    + "              <form class=\"form-inline my-2 my-lg-0\">\n"
                    + "                <input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Search\">\n"
                    + "                <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Buscar</button>\n"
                    + "              </form>\n"
                    + "            </div>\n"
                    + "        </nav>");
            out.print("<div class=\"mx-auto\" style=\"width: 600px;\">\n"
                    + "<h1 class='display-4'>Datos de Usuario</h1>"
                    + "<br><br>"
                    + "<dl class=\"row\">\n"
                    + "  <dt class=\"col-sm-3\">Description lists</dt>\n"
                    + "  <dd class=\"col-sm-9\">A description list is perfect for defining terms.</dd>\n"
                    + "\n"
                    + "  <dt class=\"col-sm-3\">Term</dt>\n"
                    + "  <dd class=\"col-sm-9\">\n"
                    + "    <p>Definition for the term.</p>\n"
                    + "    <p>And some more placeholder definition text.</p>\n"
                    + "  </dd>\n"
                    + "\n"
                    + "  <dt class=\"col-sm-3\">Another term</dt>\n"
                    + "  <dd class=\"col-sm-9\">This definition is short, so no extra paragraphs or anything.</dd>\n"
                    + "\n"
                    + "  <dt class=\"col-sm-3 text-truncate\">Truncated term is truncated</dt>\n"
                    + "  <dd class=\"col-sm-9\">This can be useful when space is tight. Adds an ellipsis at the end.</dd>\n"
                    + "\n"
                    + "  <dt class=\"col-sm-3\">Nesting</dt>\n"
                    + "  <dd class=\"col-sm-9\">\n"
                    + "    <dl class=\"row\">\n"
                    + "      <dt class=\"col-sm-4\">Nested definition list</dt>\n"
                    + "      <dd class=\"col-sm-8\">I heard you like definition lists. Let me put a definition list inside your definition list.</dd>\n"
                    + "    </dl>\n"
                    + "  </dd>\n"
                    + "</dl>"
                    + "</div>");
            out.println("</body>");
            out.println("</html>");
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

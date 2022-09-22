/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import PaqueteJava.ClienteModel;
import PaqueteJava.RegistroArray;
import PaqueteJava.ConexionBaseDeDatos;
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

    ClienteModel cliente;
    RegistroArray registroArray;
    ClienteModel[] registroCliente; //Creamos de nuevo un objeto donde se encuentran todas la variables del cliente, su función es almacenar lo que se registre en el primer vector
    StringBuffer objetoRespuesta = new StringBuffer();

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

        try ( PrintWriter respuesta = response.getWriter()) {
            /* Inicializamos el objeto de la clase alumnos que posee todas los datos del cliente y
            le asignamos a este objeto todos los datos que han sido ingresados en el formulario en el archivo index.html
            Esto debe hacerse en orden y con los nombres que le asignamos a los input del formulario.
             */
            registroArray = new RegistroArray();
            String control = request.getParameter("control");

            if (control.toUpperCase().equals("GUARDAR")) {
                cliente = new ClienteModel(
                        request.getParameter("name"),//Nombre de los ID que colocamos a cada input en index
                        request.getParameter("lastname"),
                        Integer.parseInt(request.getParameter("code")),
                        Integer.parseInt(request.getParameter("phone")),
                        request.getParameter("email"),
                        request.getParameter("address"),
                        request.getParameter("municipio"),
                        request.getParameter("city"));
                registroArray.guardarClienteBD(cliente);//Almacenar en BD

            } else if (control.toUpperCase().equals("ELIMINAR")) {
                int codigoEliminar = Integer.parseInt(request.getParameter("codigo_cliente"));//Nombre de encabezado de tabla Mysql con not null
                registroArray.eliminarCliente(codigoEliminar);
            }

            registroArray.getClientes2(objetoRespuesta);//consultar registro cliente en el BD
            respuesta.write(objetoRespuesta.toString());
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

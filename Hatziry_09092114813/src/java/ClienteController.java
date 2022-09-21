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
            /* Inicializamos el objeto de la clase alumnos que posee todas los datos del cliente y
            le asignamos a este objeto todos los datos que han sido ingresados en el formulario en el archivo index.html
            Esto debe hacerse en orden y con los nombres que le asignamos a los input del formulario.
             */
            cliente = new ClienteModel(
                    request.getParameter("name"),
                    request.getParameter("lastname"),
                    Integer.parseInt(request.getParameter("code")),
                    Integer.parseInt(request.getParameter("phone")),
                    request.getParameter("email"),
                    request.getParameter("address"),
                    request.getParameter("municipio"),
                    request.getParameter("city")
            );

            /*
            Con este método al previamente haber creado el objeto de la clase, al iniciarlo dentro del try y asignarle los datos 
            obtenidos en el formulario con los metodos set, de igual manera se cambian los valores de enteros
            a string con Integer.parseInt para evitar problemas a futuro.
            
            cliente.setNombre(request.getParameter("nombre"));
            cliente.setApellido(request.getParameter("apellido"));
            cliente.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            cliente.setTelefono(Integer.parseInt(request.getParameter("telefono")));
            cliente.setCorreo(request.getParameter("email"));
            cliente.setDirección(request.getParameter("direccion"));
            cliente.setMunicipio(request.getParameter("municipio"));
            cliente.setCiudad(request.getParameter("ciudad"));
             */
            if (registroArray == null) {
                registroArray = new RegistroArray();
            }

            registroArray.guardarRegistro(cliente); 
            
            if(registroArray.guardarEnBD(cliente)){
                out.println(1);
            }else{
                out.println(0);
            }
            registroCliente = registroArray.returnCliente();
            
            if(request.getParameter("position")!= null){
                String position = request.getParameter("position");
                registroArray.delete(position);
            }
            
            for (int i = 0; i < registroCliente.length; i++) {
                if (!registroCliente[i].getNombre().isEmpty()) {
                    
                    out.println("<tr><td>" + registroCliente[i].getCodigo() + "</td>");
                    out.println("<td>" + registroCliente[i].getNombre() + "</td>");
                    out.println("<td>" + registroCliente[i].getApellido() + "</td>");
                    out.println("<td>" + registroCliente[i].getTelefono() + "</td>");
                    out.println("<td>" + registroCliente[i].getCorreo() + "</td>");
                    out.println("<td>" + registroCliente[i].getCiudad() + "</td>");
                    out.println("<td>"
                            + "<button \"<buttontype=\"button\" class=\"btn btn-outline-warning btn-sm \" id=\"btn1\" onclick=\"eliminar()\" >Delete 1</button> "
                            + "<button type=\"button\" class=\"btn btn-outline-danger btn-sm\" id=\"btn2\" onclick=\"eliminar2("+ i +")\">Delete 2</button>"
                            + "</td>" + "    </tr>\n");
                }
            } 
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

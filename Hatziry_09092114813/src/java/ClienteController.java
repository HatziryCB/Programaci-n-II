/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import PaqueteJava.ClienteModel;
import PaqueteJava.RegistroArray;
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
            //mandamos a llamar el metodo que registra los datos en el vector, donde también el índice aumenta uno en uno
            registroCliente = registroArray.returnCliente();
            //Ahora vamos a llamar al método de la clase registroArray que nos retorna lo que se encuentra registrado en el vector
            int iterador=0;
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct\" crossorigin=\"anonymous\"></script>"
                    + "<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\" integrity=\"sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N\" crossorigin=\"anonymous\">\n");
            out.println("</head>");
            out.println("<body>");
            out.println("<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n"
                    + "            <a class=\"navbar-brand\" href=\"https://www.acer.com/ac/en/US/content/home\">ACER</a>\n"
                    + "            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarTogglerDemo02\" aria-controls=\"navbarTogglerDemo02\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
                    + "              <span class=\"navbar-toggler-icon\"></span>\n"
                    + "            </button>\n"
                    + "\n"
                    + "            <div class=\"collapse navbar-collapse\" id=\"navbarTogglerDemo02\">\n"
                    + "              <ul class=\"navbar-nav mr-auto mt-2 mt-lg-0\">\n"
                    + "                <li class=\"nav-item active\">\n"
                    + "                  <a class=\"nav-link\" href=\"index.html\">Registrarse <span class=\"sr-only\">(current)</span></a>\n"
                    + "                </li>\n"
                    + "                <li class=\"nav-item active\">\n"
                    + "                  <a class=\"nav-link\" href=\"https://store.acer.com/en-us/?internal_source=us.acer.com&internal_medium=referral&internal_campaign=Ongoing&internal_content=Nav\">Tienda</a>\n"
                    + "                </li>\n"
                    + "                <li class=\"nav-item active\">\n"
                    + "                  <a class=\"nav-link\" href=\"https://www.acer.com/ac/en/US/content/service-contact\">Contacto</a>\n"
                    + "                </li>\n"
                    + "              </ul>\n"
                    + "              <form class=\"form-inline my-2 my-lg-0\">\n"
                    + "                <input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Search\">\n"
                    + "                <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Buscar</button>\n"
                    + "              </form>\n"
                    + "            </div>\n"
                    + "        </nav>");

            out.println("<div class=\"mx-auto\" style=\"width: 600px;\">\n"
                    + "<br><br><br><h4 class=\"display-4\">Datos de Usuario</h4>"
                    + "<br><br>"
                    + "<dl class=\"row\">\n"
                    + "  <dt class=\"col-sm-3\">Nombre </dt>\n"
                    + "  <dd class=\"col-sm-9\">" + cliente.getNombre() + " " + cliente.getApellido() + "</dd>\n"
                    + "\n"
                    + "  <dt class=\"col-sm-3\">Código</dt>\n"
                    + "  <dd class=\"col-sm-9\">\n"
                    + "    <p>" + cliente.getCodigo() + "</p>\n"
                    + "  </dd>\n"
                    + "\n"
                    + "  <dt class=\"col-sm-3\">Teléfono</dt>\n"
                    + "  <dd class=\"col-sm-9\">" + cliente.getTelefono() + "</dd>\n"
                    + "\n"
                    + "  <dt class=\"col-sm-3 text-truncate\">Correo</dt>\n"
                    + "  <dd class=\"col-sm-9\">" + cliente.getCorreo() + "</dd>\n"
                    + "\n"
                    + "<dt class=\"col-sm-3\">Domicilio</dt>\n"
                    + "  <dd class=\"col-sm-9\">" + cliente.getDirección() + "</dd>\n"
                    + "<dt class=\"col-sm-3\">Locación</dt>\n"
                    + "  <dd class=\"col-sm-9\">" + cliente.getMunicipio() + " , " + cliente.getCiudad() + "</dd>\n"
                    + "</dl>"
                    + "<a class=\"btn btn-primary\" href=\"index.html\" role=\"button\">Registrar otro cliente</a>"
                    + "</div>");

            out.println("<div class=\"mx-auto\" style=\"width:1200px;\">\n "
                    + "<br><br><br><br><br><h2>Historial de Registros</h2>"
                    + "<table class=\"table table-hover\">\n"
                    + "  <thead>\n"
                    + "    <tr>\n"
                    + "      <th scope=\"col\">No.</th>\n"
                    + "      <th scope=\"col\">Nombres</th>\n"
                    + "      <th scope=\"col\">Apellidos</th>\n"
                    + "      <th scope=\"col\">Código</th>\n"
                    + "      <th scope=\"col\">Teléfono</th>\n"
                    + "      <th scope=\"col\">Correo</th>\n"
                    + "      <th scope=\"col\">Municipio</th>\n"
                    + "      <th scope=\"col\">Ciudad</th>\n"
                    + "    </tr>\n"
                    + "  </thead>\n");
                    out.println("<tbody>");
                    
                    for(int i = 0;i<registroCliente.length; i++){
                        iterador=iterador+1;
                        if(!registroCliente[i].getNombre().isEmpty()){
                           out.println("<tr>\n"
                    + "      <th scope=\"row\">"+iterador+"</th>\n"
                    + "      <td>"+registroCliente[i].getNombre()+"</td>\n"
                    + "      <td>"+registroCliente[i].getApellido()+"</td>\n"
                    + "      <td>"+registroCliente[i].getCodigo()+"</td>\n"
                    + "      <td>"+registroCliente[i].getTelefono()+"</td>\n"
                    + "      <td>"+registroCliente[i].getCorreo()+"</td>\n"
                    + "      <td>"+registroCliente[i].getMunicipio()+"</td>\n"
                    + "      <td>"+registroCliente[i].getCiudad()+"</td>\n");
                    out.println("<td>"
                               + "<button type=\"button\" class=\"btn btn-warning\"></i>Editar</button> "
                               + "<button type=\"button\" class=\"btn btn-danger\">Eliminar</button>"
                               + "</td>" + "    </tr>\n");
                        }
                    }
                    out.println("  </tbody>");
                    out.println("</table>");
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

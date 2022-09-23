/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaqueteJava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Hatziry Chacón
 */
public class RegistroArray {

    ClienteModel[] vectorCliente;
    int indice;
    private ConexionBaseDeDatos conectorBD;
    private Connection conexion;
    private PreparedStatement statement = null;
    private ResultSet result = null;

    public RegistroArray() {
        this.vectorCliente = new ClienteModel[100];
        this.indice = 0;
    }

    public void guardarRegistro(ClienteModel cliente) {
        this.vectorCliente[indice] = cliente;
        this.indice = this.indice + 1;
        //Con este método logramos almacenar el registro en el array
    }

    public ClienteModel[] returnCliente() {
        return this.vectorCliente;
        //Retornamos todo nuestro array
    }

    public void delete(String position) {
        int pos = Integer.parseInt(position);
        this.vectorCliente[pos] = null;

        for (int i = pos; i < indice - 1; i++) {
            this.vectorCliente[i - 1] = this.vectorCliente[i + 1];
        }
        this.vectorCliente[indice - 1] = null;
        indice--;
    }

    public void iniciarConexion() {
        conectorBD = new ConexionBaseDeDatos();
        conexion = conectorBD.conectar();
    }

    public String guardarClienteBD(ClienteModel cliente) {
        String sql = "INSERT INTO universidad.cliente(nombre, apellido, codigo, telefono, correo, ciudad)";
        sql += "VALUES (?,?,?,?,?,?)";

        try {
            iniciarConexion();
            statement = conexion.prepareStatement(sql);
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellido());
            statement.setInt(3, cliente.getCodigo());
            statement.setInt(4, cliente.getTelefono());
            statement.setString(5, cliente.getCorreo());
            statement.setString(6, cliente.getCiudad());
            int resultado = statement.executeUpdate();
            // podemos colocar en vez de resultado el llamado de la función 
            // prstmt.executeUpdate() => if(prstmt.executeUpdate() > 0)
            if (resultado > 0) {
                return String.valueOf(resultado);
            } else {
                return String.valueOf(resultado);
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public void getClientes2(StringBuffer respuesta) {
        String sql = "select * from universidad.cliente";
        try {
            iniciarConexion();
            respuesta.setLength(0);
            statement = conexion.prepareStatement(sql);
            result = statement.executeQuery();
            if (result != null) {
                while (result.next()) {
                    respuesta.append("<tr>");
                    //nombre de los encabezados en las columnas del query en mySQL Workbench
                    respuesta.append("<td >").append(result.getString("nombre")).append("</td>");
                    respuesta.append("<td >").append(result.getString("apellido")).append("</td>");
                    respuesta.append("<td >").append(result.getString("codigo")).append("</td>");
                    respuesta.append("<td >").append(result.getString("telefono")).append("</td>");
                    respuesta.append("<td >").append(result.getString("correo")).append("</td>");
                    respuesta.append("<td >").append(result.getString("ciudad")).append("</td>");
                    respuesta.append("<td id=\"").append(result.getString("codigo"))
                            .append("\"  onclick=\"eliminarCliente(this.id);\">")
                            .append(" <a class=\"btn btn-warning\"'><i class=\"fas fa-edit\"></i>  </a>"
                                    + " <a class=\"btn btn-danger\"'> <i class=\"fas fa-trash-alt\"></i> </a>"
                                    + " <td></tr>");
                }
            } else {
                respuesta.append("error al consultar");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String eliminarCliente(int carne) {
        String sql = "DELETE FROM cliente WHERE codigo=" + carne;
        try {
            iniciarConexion();
            statement = conexion.prepareStatement(sql);
            int resultado = statement.executeUpdate();
            if (resultado > 0) {
                return String.valueOf(resultado);
            } else {
                return String.valueOf(resultado);
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}

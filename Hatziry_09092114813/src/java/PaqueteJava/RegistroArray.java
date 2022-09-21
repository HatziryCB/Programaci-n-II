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
   ClienteModel [] vectorCliente;
   int indice;
   private ConexionBaseDeDatos conectorBD;
   private Connection conexion;
   private PreparedStatement prstmt = null;
   private ResultSet result = null;
   
   public RegistroArray(){
       this.vectorCliente = new ClienteModel[100];
       this.indice = 0;
   }
   
   public void guardarRegistro(ClienteModel cliente){
       this.vectorCliente[indice]= cliente;
       this.indice=this.indice+1;
       //Con este método logramos almacenar el registro en el array
   }
   
   public ClienteModel[] returnCliente(){
       return this.vectorCliente;
       //Retornamos todo nuestro array
   }
   public void delete (String position){
       int pos = Integer.parseInt(position);
       this.vectorCliente[pos]= null;
       
       for(int i = pos; i< indice -1; i++){
           this.vectorCliente[i-1] = this.vectorCliente[i+1];
       }
       this.vectorCliente[indice-1]= null;
       indice --;
   }
   
   public void iniciarConexion(){
       conectorBD = new ConexionBaseDeDatos();
       conexion = conectorBD.conectar();
   }
   
   public boolean guardarEnBD(ClienteModel cliente){
       String sql = "INSERT INTO universidad.cliente(codigo, nombre, apellido, telefono, correo, ciudad, genero_idgenero)";
       sql += "VALUES (?,?,?,?,?)";
       
       try{
           iniciarConexion();
           prstmt = conexion.prepareStatement(sql);
           prstmt.setInt(1, cliente.getCodigo());
           prstmt.setString(2, cliente.getNombre());
           prstmt.setString(3, cliente.getApellido());
           prstmt.setInt(4, cliente.getTelefono());
           prstmt.setString(5, cliente.getCorreo());
           prstmt.setString(6, cliente.getCiudad());
           int resultado = prstmt.executeUpdate();
           // podemos colocar en vez de resultado el llamado de la función 
           // prstmt.executeUpdate() => if(prstmt.executeUpdate() > 0)
                if(resultado > 0){
                    return true;
                }else{
                    return false;
                }
       }catch(SQLException e){
           String error = e.getMessage();
           return false;
       }
   }
}

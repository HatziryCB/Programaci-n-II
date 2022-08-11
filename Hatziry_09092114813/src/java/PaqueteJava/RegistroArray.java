/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaqueteJava;

/**
 *
 * @author Hatziry Chacón
 */
public class RegistroArray {
   ClienteModel [] vectorCliente;
   int indice;
   
   public RegistroArray(){
       this.vectorCliente = new ClienteModel[50];
       this.indice = 0;
   }
   
   public void guardarRegistro(ClienteModel cliente){
       this.vectorCliente[indice]= cliente;
       this.indice=this.indice+1;
   }
   
   public ClienteModel[] returnCliente(){
       return this.vectorCliente;
   }
}

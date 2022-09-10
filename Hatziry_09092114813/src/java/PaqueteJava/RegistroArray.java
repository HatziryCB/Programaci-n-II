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
   int btn;
   
   public RegistroArray(){
       this.vectorCliente = new ClienteModel[50];
       this.indice = 0;
       this.btn =0;
   }
   
   public void guardarRegistro(ClienteModel cliente){
       this.vectorCliente[indice]= cliente;
       this.indice=this.indice+1;
   }
   
   public ClienteModel[] returnCliente(){
       return this.vectorCliente;
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
}

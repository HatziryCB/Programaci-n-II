/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PaqueteJava;

/**
 * @author Chacón Berreondo
 */
public class ClienteModel {
    private String nombre;
    private String apellido;
    private int codigo;
    private int telefono;
    private String correo;
    private String pass;
    private String direccion;
    private String municipio;
    private String ciudad;

    public ClienteModel(String nombre, String apellido, int codigo, int telefono, String correo, String direccion, String municipio, String ciudad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.municipio = municipio;
        this.ciudad = ciudad;
    }

    
    public ClienteModel() {
        this.nombre = "Nombre de ejemplo";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDirección() {
        return direccion;
    }

    public void setDirección(String dirección) {
        this.direccion = dirección;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}

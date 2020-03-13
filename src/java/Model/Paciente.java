/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Dell
 */
public class Paciente {
    private int idPaciente;
    private String nombre;
    private String apellido;
    private int dni;
    private String sexo;
    private int telefono;
    private String domicilio;
    private String email;

    public Paciente() {
    }

    public Paciente(String nombre, String apellido, int dni, String sexo, int telefono, String domicilio, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.sexo = sexo;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.email = email;
    }

    public Paciente(int idPaciente, String nombre, String apellido, int dni, String sexo, int telefono, String domicilio, String email) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.sexo = sexo;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.email = email;
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public String toString() {
       return  nombre + ", " + apellido;
    }

    public String toString2() {
        return  idPaciente + ", " + nombre + ", " + apellido + ", " + dni + ", " + sexo + ", " + telefono + ", " + domicilio + ", " + email;
    }
    
}

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
public class Profesional {
    
    private int legajo;
    private String nombre;
    private String apellido;
    private tipoProfesional tipo;
    private int dni;
    private String sexo;
    private int telefono;
    private String domicilio;
    private String email;

    public Profesional() {
    }

    public Profesional(String nombre, String apellido, tipoProfesional tipo, int dni, String sexo, int telefono, String domicilio, String email) {
        this.legajo = -1;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo = tipo;
        this.dni = dni;
        this.sexo = sexo;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.email = email;
    }
    
     public Profesional(int legajo, String nombre, String apellido, tipoProfesional tipo, int dni, String sexo, int telefono, String domicilio, String email) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo = tipo;
        this.dni = dni;
        this.sexo = sexo;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.email = email;
    }


    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
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

    public tipoProfesional getTipo() {
        return tipo;
    }

    public void setTipo(tipoProfesional tipo) {
        this.tipo = tipo;
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

    @Override
    public String toString() {
        return nombre  +", "+ apellido;
    }
    
   
    public String toString2() {
        return legajo + ", " + nombre + ", " + apellido + ", " + tipo.toString() + ", " + dni + ", " + sexo + ", " + telefono + ", " + domicilio + ", " + email;
    }

    
    
    
    

}

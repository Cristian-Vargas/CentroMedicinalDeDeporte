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
public class Inscripcion {
    
    private int idInscripcion;
    private OrdenMedica ordenMedica;
    private String fecha;

    public Inscripcion() {
    }

    public Inscripcion(int idInscripcion, OrdenMedica ordenMedica, String fecha) {
        this.idInscripcion = idInscripcion;
        this.ordenMedica = ordenMedica;
        this.fecha = fecha;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public OrdenMedica getOrdenMedica() {
        return ordenMedica;
    }

    public void setOrdenMedica(OrdenMedica ordenMedica) {
        this.ordenMedica = ordenMedica;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return idInscripcion + ", " + fecha + ", " + ordenMedica.toString2();
    }
    
    
    
    
}

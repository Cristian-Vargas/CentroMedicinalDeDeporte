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
public class Asistencia {
    
    private int idAsistencia;
    private Inscripcion inscripcion;
    private Sede sede;
    private Practica practica;
    private Profesional profesional;
    private String fecha;

    public Asistencia(int idAsistencia, Inscripcion inscripcion, Sede sede, Practica practica, Profesional profesional, String fecha) {
        this.idAsistencia = idAsistencia;
        this.inscripcion = inscripcion;
        this.sede = sede;
        this.practica = practica;
        this.profesional = profesional;
        this.fecha = fecha;
    }

    public Asistencia() {
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Practica getPractica() {
        return practica;
    }

    public void setPractica(Practica practica) {
        this.practica = practica;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}

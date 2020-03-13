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
public class OrdenMedica {
    
    private int idOrdenMedica;
    private Paciente paciente;
    private Profesional profesional;
    private Disciplina disciplina;
    private int cantidadSesiones;
    private int minXSesion;
    private String diagnostico;

    public OrdenMedica() {
    }

    public OrdenMedica(Paciente paciente, Profesional profesional, Disciplina disciplina, int cantidadSesiones, int minXSesion, String diagnostico) {
        
        this.paciente = paciente;
        this.profesional = profesional;
        this.disciplina = disciplina;
        this.cantidadSesiones = cantidadSesiones;
        this.minXSesion = minXSesion;
        this.diagnostico = diagnostico;
    }
    
    public OrdenMedica(int idOrdenMedica, Paciente paciente, Profesional profesional, Disciplina disciplina, int cantidadSesiones, int minXSesion, String diagnostico) {
        this.idOrdenMedica = idOrdenMedica;
        this.paciente = paciente;
        this.profesional = profesional;
        this.disciplina = disciplina;
        this.cantidadSesiones = cantidadSesiones;
        this.minXSesion = minXSesion;
        this.diagnostico = diagnostico;
    }
    
    

    public int getIdOrdenMedica() {
        return idOrdenMedica;
    }

    public void setIdOrdenMedica(int idOrdenMedica) {
        this.idOrdenMedica = idOrdenMedica;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public int getCantidadSesiones() {
        return cantidadSesiones;
    }

    public void setCantidadSesiones(int cantidadSesiones) {
        this.cantidadSesiones = cantidadSesiones;
    }

    public int getMinXSesion() {
        return minXSesion;
    }

    public void setMinXSesion(int minXSesion) {
        this.minXSesion = minXSesion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    @Override
    public String toString() {
        return idOrdenMedica + ", " + paciente.toString() + ", " + profesional.toString() + ", " + disciplina.toString() + ", " + cantidadSesiones + ", " + minXSesion + ", " + diagnostico ;
    }
    
    public String toString2() {
        return idOrdenMedica + ", " + paciente.toString() + ", " + profesional.toString() + ", " + disciplina.toString() ;
    }
    
    
    
}

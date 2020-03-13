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
public class ProfesionalXDisciplina {
    private int id;
    private Profesional profesional;
    private Disciplina disciplina;

    public ProfesionalXDisciplina(int id, Profesional profesional, Disciplina disciplina) {
        this.id = id;
        this.profesional = profesional;
        this.disciplina = disciplina;
    }

    public ProfesionalXDisciplina() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

   
    
    
    
}

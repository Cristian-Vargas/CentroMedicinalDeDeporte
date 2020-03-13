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
public class Disciplina {
    
    private int idDisciplina;
    private String disciplina;
    private String descripcion;

    public Disciplina() {
    }

    public Disciplina(int idDisciplina, String disciplina, String descripcion) {
        this.idDisciplina = idDisciplina;
        this.disciplina = disciplina;
        this.descripcion = descripcion;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   
    public String toString1() {
        return disciplina;
    }

    @Override
    public String toString() {
        return disciplina ;
    }
    
    
    
    
}

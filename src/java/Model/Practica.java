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
public class Practica {
    
    private int idPractica;
    private String horario;
    private int duracion;

    public Practica() {
    }

    public Practica(int idPractica, String horario, int duracion) {
        this.idPractica = idPractica;
        this.horario = horario;
        this.duracion = duracion;
    }

    public int getIdPractica() {
        return idPractica;
    }

    public void setIdPractica(int idPractica) {
        this.idPractica = idPractica;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return horario;
    }
    
    
    
    
}

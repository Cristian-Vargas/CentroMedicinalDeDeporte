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
public class tipoProfesional {
   
    private int idTipoProfesional;
    private String tipoProfesional;

    public tipoProfesional() {
    }

    public tipoProfesional(int idTipoProfesional, String tipoProfesional) {
        this.idTipoProfesional = idTipoProfesional;
        this.tipoProfesional = tipoProfesional;
    }

    public int getIdTipoProfesional() {
        return idTipoProfesional;
    }

    public void setIdTipoProfesional(int idTipoProfesional) {
        this.idTipoProfesional = idTipoProfesional;
    }

    public String getTipoProfesional() {
        return tipoProfesional;
    }

    public void setTipoProfesional(String tipoProfesional) {
        this.tipoProfesional = tipoProfesional;
    }
    
    
   

    @Override
    public String toString() {
        return tipoProfesional ;
    }
    
    
}

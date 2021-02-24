/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author victo
 */
@Embeddable
public class IdCompostoAlunoEtapaSala implements Serializable{
    @Column(name = "idAluno")
    private int idAluno;
    @Column(name = "idEtapa")
    private int idEtapa;
    @Column(name = "idSala")
    private int idSala;


    

    
    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(int idEtapa) {
        this.idEtapa = idEtapa;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    @Override
    public String toString() {
        return "IdCompostoAlunoEtapaSala{" + "idAluno=" + idAluno + ", idEtapa=" + idEtapa + ", idSala=" + idSala + '}';
    }
    
    
}

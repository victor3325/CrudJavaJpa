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
public class IdCompostoAlunoEtapaEspaco implements Serializable{
    @Column(name = "idAluno")
    private int idAluno;
    @Column(name = "idEtapa")
    private int idEtapa;
    @Column(name = "idEspaco")
    private int idEspaco; 


    
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

    public int getIdEspaco() {
        return idEspaco;
    }

    public void setIdEspaco(int idEspaco) {
        this.idEspaco = idEspaco;
    }

    @Override
    public String toString() {
        return "IdCompostoAlunoEtapaEspaco{" + "idAluno=" + idAluno + ", idEtapa=" + idEtapa + ", idEspaco=" + idEspaco + '}';
    }

    
    
    
}

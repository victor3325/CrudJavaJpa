/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author victo
 */
@Embeddable
public class AlunoetapasalaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idAluno")
    private int idAluno;
    @Basic(optional = false)
    @Column(name = "idSala")
    private int idSala;
    @Basic(optional = false)
    @Column(name = "idEtapa")
    private int idEtapa;

    public AlunoetapasalaPK() {
    }

    public AlunoetapasalaPK(int idAluno, int idSala, int idEtapa) {
        this.idAluno = idAluno;
        this.idSala = idSala;
        this.idEtapa = idEtapa;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(int idEtapa) {
        this.idEtapa = idEtapa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAluno;
        hash += (int) idSala;
        hash += (int) idEtapa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoetapasalaPK)) {
            return false;
        }
        AlunoetapasalaPK other = (AlunoetapasalaPK) object;
        if (this.idAluno != other.idAluno) {
            return false;
        }
        if (this.idSala != other.idSala) {
            return false;
        }
        if (this.idEtapa != other.idEtapa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.AlunoetapasalaPK[ idAluno=" + idAluno + ", idSala=" + idSala + ", idEtapa=" + idEtapa + " ]";
    }
    
}

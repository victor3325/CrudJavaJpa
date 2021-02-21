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
public class AlunoetapaespacoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idEspaco")
    private int idEspaco;
    @Basic(optional = false)
    @Column(name = "idAluno")
    private int idAluno;
    @Basic(optional = false)
    @Column(name = "idEtapa")
    private int idEtapa;

    public AlunoetapaespacoPK() {
    }

    public AlunoetapaespacoPK(int idEspaco, int idAluno, int idEtapa) {
        this.idEspaco = idEspaco;
        this.idAluno = idAluno;
        this.idEtapa = idEtapa;
    }

    public int getIdEspaco() {
        return idEspaco;
    }

    public void setIdEspaco(int idEspaco) {
        this.idEspaco = idEspaco;
    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEspaco;
        hash += (int) idAluno;
        hash += (int) idEtapa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoetapaespacoPK)) {
            return false;
        }
        AlunoetapaespacoPK other = (AlunoetapaespacoPK) object;
        if (this.idEspaco != other.idEspaco) {
            return false;
        }
        if (this.idAluno != other.idAluno) {
            return false;
        }
        if (this.idEtapa != other.idEtapa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.AlunoetapaespacoPK[ idEspaco=" + idEspaco + ", idAluno=" + idAluno + ", idEtapa=" + idEtapa + " ]";
    }
    
}

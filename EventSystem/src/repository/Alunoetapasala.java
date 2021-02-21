/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author victo
 */
@Entity
@Table(name = "alunoetapasala", catalog = "mydb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Alunoetapasala.findAll", query = "SELECT a FROM Alunoetapasala a")
    , @NamedQuery(name = "Alunoetapasala.findByIdAluno", query = "SELECT a FROM Alunoetapasala a WHERE a.alunoetapasalaPK.idAluno = :idAluno")
    , @NamedQuery(name = "Alunoetapasala.findByIdSala", query = "SELECT a FROM Alunoetapasala a WHERE a.alunoetapasalaPK.idSala = :idSala")
    , @NamedQuery(name = "Alunoetapasala.findByIdEtapa", query = "SELECT a FROM Alunoetapasala a WHERE a.alunoetapasalaPK.idEtapa = :idEtapa")})
public class Alunoetapasala implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlunoetapasalaPK alunoetapasalaPK;

    public Alunoetapasala() {
    }

    public Alunoetapasala(AlunoetapasalaPK alunoetapasalaPK) {
        this.alunoetapasalaPK = alunoetapasalaPK;
    }

    public Alunoetapasala(int idAluno, int idSala, int idEtapa) {
        this.alunoetapasalaPK = new AlunoetapasalaPK(idAluno, idSala, idEtapa);
    }

    public AlunoetapasalaPK getAlunoetapasalaPK() {
        return alunoetapasalaPK;
    }

    public void setAlunoetapasalaPK(AlunoetapasalaPK alunoetapasalaPK) {
        this.alunoetapasalaPK = alunoetapasalaPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alunoetapasalaPK != null ? alunoetapasalaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alunoetapasala)) {
            return false;
        }
        Alunoetapasala other = (Alunoetapasala) object;
        if ((this.alunoetapasalaPK == null && other.alunoetapasalaPK != null) || (this.alunoetapasalaPK != null && !this.alunoetapasalaPK.equals(other.alunoetapasalaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Alunoetapasala[ alunoetapasalaPK=" + alunoetapasalaPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

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
@Table(name = "alunoetapaespaco", catalog = "mydb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Alunoetapaespaco.findAll", query = "SELECT a FROM Alunoetapaespaco a")
    , @NamedQuery(name = "Alunoetapaespaco.findByIdEspaco", query = "SELECT a FROM Alunoetapaespaco a WHERE a.alunoetapaespacoPK.idEspaco = :idEspaco")
    , @NamedQuery(name = "Alunoetapaespaco.findByIdAluno", query = "SELECT a FROM Alunoetapaespaco a WHERE a.alunoetapaespacoPK.idAluno = :idAluno")
    , @NamedQuery(name = "Alunoetapaespaco.findByIdEtapa", query = "SELECT a FROM Alunoetapaespaco a WHERE a.alunoetapaespacoPK.idEtapa = :idEtapa")})
public class Alunoetapaespaco implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlunoetapaespacoPK alunoetapaespacoPK;

    public Alunoetapaespaco() {
    }

    public Alunoetapaespaco(AlunoetapaespacoPK alunoetapaespacoPK) {
        this.alunoetapaespacoPK = alunoetapaespacoPK;
    }

    public Alunoetapaespaco(int idEspaco, int idAluno, int idEtapa) {
        this.alunoetapaespacoPK = new AlunoetapaespacoPK(idEspaco, idAluno, idEtapa);
    }

    public AlunoetapaespacoPK getAlunoetapaespacoPK() {
        return alunoetapaespacoPK;
    }

    public void setAlunoetapaespacoPK(AlunoetapaespacoPK alunoetapaespacoPK) {
        this.alunoetapaespacoPK = alunoetapaespacoPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alunoetapaespacoPK != null ? alunoetapaespacoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alunoetapaespaco)) {
            return false;
        }
        Alunoetapaespaco other = (Alunoetapaespaco) object;
        if ((this.alunoetapaespacoPK == null && other.alunoetapaespacoPK != null) || (this.alunoetapaespacoPK != null && !this.alunoetapaespacoPK.equals(other.alunoetapaespacoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Alunoetapaespaco[ alunoetapaespacoPK=" + alunoetapaespacoPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

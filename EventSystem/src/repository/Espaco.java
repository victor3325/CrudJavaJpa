/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author victo
 */
@Entity
@Table(name = "espaco", catalog = "mydb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Espaco.findAll", query = "SELECT e FROM Espaco e")
    , @NamedQuery(name = "Espaco.findByIdespaco", query = "SELECT e FROM Espaco e WHERE e.idespaco = :idespaco")
    , @NamedQuery(name = "Espaco.findByLotacao", query = "SELECT e FROM Espaco e WHERE e.lotacao = :lotacao")
    , @NamedQuery(name = "Espaco.findByNomeespaco", query = "SELECT e FROM Espaco e WHERE e.nomeespaco = :nomeespaco")})
public class Espaco implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDESPACO")
    private Integer idespaco;
    @Column(name = "LOTACAO")
    private Integer lotacao;
    @Column(name = "NOMEESPACO")
    private String nomeespaco;

    public Espaco() {
    }

    public Espaco(Integer idespaco) {
        this.idespaco = idespaco;
    }

    public Integer getIdespaco() {
        return idespaco;
    }

    public void setIdespaco(Integer idespaco) {
        Integer oldIdespaco = this.idespaco;
        this.idespaco = idespaco;
        changeSupport.firePropertyChange("idespaco", oldIdespaco, idespaco);
    }

    public Integer getLotacao() {
        return lotacao;
    }

    public void setLotacao(Integer lotacao) {
        Integer oldLotacao = this.lotacao;
        this.lotacao = lotacao;
        changeSupport.firePropertyChange("lotacao", oldLotacao, lotacao);
    }

    public String getNomeespaco() {
        return nomeespaco;
    }

    public void setNomeespaco(String nomeespaco) {
        String oldNomeespaco = this.nomeespaco;
        this.nomeespaco = nomeespaco;
        changeSupport.firePropertyChange("nomeespaco", oldNomeespaco, nomeespaco);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idespaco != null ? idespaco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Espaco)) {
            return false;
        }
        Espaco other = (Espaco) object;
        if ((this.idespaco == null && other.idespaco != null) || (this.idespaco != null && !this.idespaco.equals(other.idespaco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getNomeespaco();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

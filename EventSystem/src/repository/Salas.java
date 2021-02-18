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
@Table(name = "salas", catalog = "mysql", schema = "")
@NamedQueries({
    @NamedQuery(name = "Salas.findAll", query = "SELECT s FROM Salas s")
    , @NamedQuery(name = "Salas.findByIdsala", query = "SELECT s FROM Salas s WHERE s.idsala = :idsala")
    , @NamedQuery(name = "Salas.findByLotacao", query = "SELECT s FROM Salas s WHERE s.lotacao = :lotacao")
    , @NamedQuery(name = "Salas.findByNomesala", query = "SELECT s FROM Salas s WHERE s.nomesala = :nomesala")})
public class Salas implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDSALA")
    private Integer idsala;
    @Column(name = "LOTACAO")
    private Integer lotacao;
    @Column(name = "NOMESALA")
    private String nomesala;

    public Salas() {
    }

    public Salas(Integer idsala) {
        this.idsala = idsala;
    }

    public Integer getIdsala() {
        return idsala;
    }

    public void setIdsala(Integer idsala) {
        Integer oldIdsala = this.idsala;
        this.idsala = idsala;
        changeSupport.firePropertyChange("idsala", oldIdsala, idsala);
    }

    public Integer getLotacao() {
        return lotacao;
    }

    public void setLotacao(Integer lotacao) {
        Integer oldLotacao = this.lotacao;
        this.lotacao = lotacao;
        changeSupport.firePropertyChange("lotacao", oldLotacao, lotacao);
    }

    public String getNomesala() {
        return nomesala;
    }

    public void setNomesala(String nomesala) {
        String oldNomesala = this.nomesala;
        this.nomesala = nomesala;
        changeSupport.firePropertyChange("nomesala", oldNomesala, nomesala);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsala != null ? idsala.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salas)) {
            return false;
        }
        Salas other = (Salas) object;
        if ((this.idsala == null && other.idsala != null) || (this.idsala != null && !this.idsala.equals(other.idsala))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Salas[ idsala=" + idsala + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

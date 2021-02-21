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
@Table(name = "etapa", catalog = "mydb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Etapa.findAll", query = "SELECT e FROM Etapa e")
    , @NamedQuery(name = "Etapa.findByIdetapa", query = "SELECT e FROM Etapa e WHERE e.idetapa = :idetapa")
    , @NamedQuery(name = "Etapa.findByDescricao", query = "SELECT e FROM Etapa e WHERE e.descricao = :descricao")})
public class Etapa implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDETAPA")
    private Integer idetapa;
    @Column(name = "DESCRICAO")
    private String descricao;

    public Etapa() {
    }

    public Etapa(Integer idetapa) {
        this.idetapa = idetapa;
    }

    public Integer getIdetapa() {
        return idetapa;
    }

    public void setIdetapa(Integer idetapa) {
        Integer oldIdetapa = this.idetapa;
        this.idetapa = idetapa;
        changeSupport.firePropertyChange("idetapa", oldIdetapa, idetapa);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idetapa != null ? idetapa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etapa)) {
            return false;
        }
        Etapa other = (Etapa) object;
        if ((this.idetapa == null && other.idetapa != null) || (this.idetapa != null && !this.idetapa.equals(other.idetapa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getDescricao();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

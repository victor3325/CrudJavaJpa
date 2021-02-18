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
@Table(name = "alunos", catalog = "mysql", schema = "")
@NamedQueries({
    @NamedQuery(name = "Alunos.findAll", query = "SELECT a FROM Alunos a")
    , @NamedQuery(name = "Alunos.findByIdaluno", query = "SELECT a FROM Alunos a WHERE a.idaluno = :idaluno")
    , @NamedQuery(name = "Alunos.findByNomealuno", query = "SELECT a FROM Alunos a WHERE a.nomealuno = :nomealuno")
    , @NamedQuery(name = "Alunos.findBySobrenome", query = "SELECT a FROM Alunos a WHERE a.sobrenome = :sobrenome")})
public class Alunos implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDALUNO")
    private Integer idaluno;
    @Column(name = "NOMEALUNO")
    private String nomealuno;
    @Column(name = "SOBRENOME")
    private String sobrenome;

    public Alunos() {
    }

    public Alunos(Integer idaluno) {
        this.idaluno = idaluno;
    }

    public Integer getIdaluno() {
        return idaluno;
    }

    public void setIdaluno(Integer idaluno) {
        Integer oldIdaluno = this.idaluno;
        this.idaluno = idaluno;
        changeSupport.firePropertyChange("idaluno", oldIdaluno, idaluno);
    }

    public String getNomealuno() {
        return nomealuno;
    }

    public void setNomealuno(String nomealuno) {
        String oldNomealuno = this.nomealuno;
        this.nomealuno = nomealuno;
        changeSupport.firePropertyChange("nomealuno", oldNomealuno, nomealuno);
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        String oldSobrenome = this.sobrenome;
        this.sobrenome = sobrenome;
        changeSupport.firePropertyChange("sobrenome", oldSobrenome, sobrenome);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaluno != null ? idaluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alunos)) {
            return false;
        }
        Alunos other = (Alunos) object;
        if ((this.idaluno == null && other.idaluno != null) || (this.idaluno != null && !this.idaluno.equals(other.idaluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Alunos[ idaluno=" + idaluno + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

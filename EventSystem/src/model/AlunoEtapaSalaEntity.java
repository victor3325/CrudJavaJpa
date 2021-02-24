/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import javax.persistence.Table;

/**
 *
 * @author victo
 */
@Entity
@Table(name = "AlunoEtapaSala")
public class AlunoEtapaSalaEntity implements Serializable {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinTable(name = "AlunoEtapaSala" , joinColumns = {
        @JoinColumn( name = "idAlunos" , referencedColumnName = "idAluno" ),
        @JoinColumn( name = "idEtapas" , referencedColumnName = "idEtapas" ),
        @JoinColumn( name = "idSalas" , referencedColumnName = "idSalas" )    
    })
    private IdCompostoAlunoEtapaSala id;
    

    public AlunoEtapaSalaEntity() {
    }

    public IdCompostoAlunoEtapaSala getId() {
        return id;
    }

    public void setId(IdCompostoAlunoEtapaSala id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AlunoEtapaSalaEntity other = (AlunoEtapaSalaEntity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Alunos" + "id=" + id + '}';
    }

    
   
    
    
    
    
}

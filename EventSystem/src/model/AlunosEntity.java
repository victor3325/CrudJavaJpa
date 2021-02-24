/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author victo
 */
@Entity
@Table(name = "Alunos")
public class AlunosEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idAluno;
    @Column(length = 20)
    private String nomeAluno;
    @Column(length = 25)
    private String sobrenome;  

    
    public AlunosEntity() {
    }

    public AlunosEntity(Integer idAluno, String nomeAluno, String sobrenome) {
        this.idAluno = idAluno;
        this.nomeAluno = nomeAluno;
        this.sobrenome = sobrenome;
    }
         
    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    

    @Override
    public String toString() {
        return "\nalunos:\n" + "\nnomeAluno: " + nomeAluno + "\nsobrenome:" + sobrenome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.idAluno);
        hash = 47 * hash + Objects.hashCode(this.nomeAluno);
        hash = 47 * hash + Objects.hashCode(this.sobrenome);
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
        final AlunosEntity other = (AlunosEntity) obj;
        if (!Objects.equals(this.nomeAluno, other.nomeAluno)) {
            return false;
        }
        if (!Objects.equals(this.sobrenome, other.sobrenome)) {
            return false;
        }
        if (!Objects.equals(this.idAluno, other.idAluno)) {
            return false;
        }
        return true;
    }
    
    
    
}

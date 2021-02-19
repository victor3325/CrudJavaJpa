/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



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
           
    @ManyToOne
    @JoinColumn(name = "idSala")
    private SalasEntity salas;

    @ManyToOne
    @JoinColumn(name = "idEspaco")
    private EspacoCafeEntity espaco;

    public EspacoCafeEntity getEspaco() {
        return espaco;
    }

    public void setEspaco(EspacoCafeEntity espaco) {
        this.espaco = espaco;
    }
   
    public SalasEntity getSalas() {
        return salas;
    }

    public void setSalas(SalasEntity salas) {
        this.salas = salas;
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
        return "alunos:\n" + "idAluno: " + idAluno + "\nnomeAluno: " + nomeAluno + "\nsobrenome:" + sobrenome;
    }
    
    
}

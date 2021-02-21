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
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/**
 *
 * @author victo
 */
@Entity
@Table(name = "Salas")
public class SalasEntity implements Serializable{


    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idSala;
    @Column(unique = true, length = 10)
    private String nomeSala;
    @Column (length = 3)
    private int lotacao;
    
    public SalasEntity() {
    }

    public SalasEntity(Integer idSala, String nomeSala, int lotacao) {
        this.idSala = idSala;
        this.nomeSala = nomeSala;
        this.lotacao = lotacao;
    }
    
    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public int getLotacao() {
        return lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }
     
    @Override
    public String toString() {
        return "salas: \n" + "idSala: " + idSala + "\nnomeSala: " + nomeSala + "\nLotação: "+ lotacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.idSala);
        hash = 37 * hash + Objects.hashCode(this.nomeSala);
        hash = 37 * hash + this.lotacao;
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
        final SalasEntity other = (SalasEntity) obj;
        if (this.lotacao != other.lotacao) {
            return false;
        }
        if (!Objects.equals(this.nomeSala, other.nomeSala)) {
            return false;
        }
        if (!Objects.equals(this.idSala, other.idSala)) {
            return false;
        }
        return true;
    }   
    
    
}

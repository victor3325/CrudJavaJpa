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
@Table(name = "Espaco")
public class EspacoCafeEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idEspaco;
    @Column(unique = true,length = 10)
    private String nomeEspaco;
    @Column(length = 3)
    private int lotacao;

    public EspacoCafeEntity() {
    }

    public EspacoCafeEntity(Integer idEspaco, String nomeEspaco, int lotacao) {
        this.idEspaco = idEspaco;
        this.nomeEspaco = nomeEspaco;
        this.lotacao = lotacao;
    }
    
    public Integer getIdEspaco() {
        return idEspaco;
    }

    public void setIdEspaco(Integer idEspaco) {
        this.idEspaco = idEspaco;
    }

    public String getNomeEspaco() {
        return nomeEspaco;
    }

    public void setNomeEspaco(String nomeEspaco) {
        this.nomeEspaco = nomeEspaco;
    }

    public int getLotacao() {
        return lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    @Override
    public String toString() {
        return "EspacoCafe: \n" + "idEspaco: " + idEspaco + "\nnomeEspaco: " + nomeEspaco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.idEspaco);
        hash = 47 * hash + Objects.hashCode(this.nomeEspaco);
        hash = 47 * hash + this.lotacao;
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
        final EspacoCafeEntity other = (EspacoCafeEntity) obj;
        if (this.lotacao != other.lotacao) {
            return false;
        }
        if (!Objects.equals(this.nomeEspaco, other.nomeEspaco)) {
            return false;
        }
        if (!Objects.equals(this.idEspaco, other.idEspaco)) {
            return false;
        }
        return true;
    }
    
    
}


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
@Table(name = "AlunoEtapaEspaco" )
public class AlunoEtapaEspacoEntity implements Serializable{
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @JoinTable(name = "AlunoEtapaEspaco" , joinColumns = {
        @JoinColumn( name = "idAlunos" , referencedColumnName = "idAluno" ),
        @JoinColumn( name = "idEtapas" , referencedColumnName = "idEtapas"),
        @JoinColumn( name = "idSalas" , referencedColumnName = "idSalas")    
    })
    private IdCompostoAlunoEtapaEspaco id;


    public IdCompostoAlunoEtapaEspaco getId() {
        return id;
    }

    public void setId(IdCompostoAlunoEtapaEspaco id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final AlunoEtapaEspacoEntity other = (AlunoEtapaEspacoEntity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}

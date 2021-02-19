package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.EspacoCafeEntity;
import model.SalasEntity;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-19T15:40:00")
@StaticMetamodel(AlunosEntity.class)
public class AlunosEntity_ { 

    public static volatile SingularAttribute<AlunosEntity, SalasEntity> salas;
    public static volatile SingularAttribute<AlunosEntity, String> nomeAluno;
    public static volatile SingularAttribute<AlunosEntity, Integer> idAluno;
    public static volatile SingularAttribute<AlunosEntity, EspacoCafeEntity> espaco;
    public static volatile SingularAttribute<AlunosEntity, String> sobrenome;

}
package facul.boares.trabalhofac.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Aluno {
    
    @Id
    @Column(name = "id")
    private Integer alunoId;

}
